package com.example.digitalsignage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.util.Log;

public class DigitalSignageTask extends Activity {
	private ProgressBar p;
    private String ip;
    private int port;
    private OrderReceiver receiver;
    private Intent intent, next_intent;
    private Flag flag;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = (Flag)getApplicationContext();
        
        setContentView(R.layout.activity_player);
        p = (ProgressBar) findViewById(R.id.progressBar1);
        intent = getIntent();
        ip = intent.getExtras().getString("IP");
        port = 38892;
        
        //receiver = new OrderReceiver(ip, port);
        Log.d("Tag",ip);
        receiver = new OrderReceiver(ip, port, flag);
        receiver.execute();
	}

    public class OrderReceiver extends AsyncTask<Void, Void, Void>{
    	private Socket sock;
    	private String ip, filename, path;
    	private int port;
    	private DataInputStream dis;
    	private DataOutputStream dos;
    	private FileOutputStream fos;
    	private AdvSyncList list;
    	private File file;
    	private Flag flag;
    	
    	public OrderReceiver(String ip, int port, Flag flag){
    		this.ip = ip;
    		this.port = port;
    		this.flag = flag;
    		list = new AdvSyncList();
    	}
    	protected Void doInBackground(Void... params) {
    		
    		Log.d("TEST", "TEST");
    		connect();
    		Log.d("TCP", "Connecting...");
    		while(true){
    			if(flag.isFlag())
    			{
    				try {
            			request();
            			Log.d("Tag","sending request");
            			path = broadReceive();
            			Log.d("Tag","Success Broadreceiving! Filename : "+ path);
            		} catch(IOException e){
            			e.printStackTrace();
            		}
            		next_intent = new Intent(getApplicationContext(), AdvPlayer.class);
        			Log.d("Test",path);
            		next_intent.putExtra("PATH", path);
            		flag.setFlag(false);
            		if(flag.isFlag())
            			Log.d("Before flag", "true");
            		else
            			Log.d("Before flag", "false");
                	startActivity(next_intent);
                	if(flag.isFlag())
            			Log.d("After flag", "true");
            		else
            			Log.d("After flag", "false");
    			}
    			else
    				continue;
    		}
    		//return null;
   	}
    	public void connect() {
    		// TODO Auto-generated method stub
    		
    		try {
    			InetAddress serverAddr = InetAddress.getByName(ip);
    			sock = new Socket(serverAddr,port);
    			dis = new DataInputStream(sock.getInputStream());
    			dos = new DataOutputStream(sock.getOutputStream());
    		} catch (UnknownHostException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch(IOException	e){
    			e.printStackTrace();
    		}
    	}
     
    	public void request() throws IOException{
    		//	video send
    		dos.writeUTF("<REQUEST>");
    		dos.flush();
    	}
    	public String broadReceive() throws IOException{
    		//	video receive
    		String order;
    		order = dis.readUTF();
    		Log.d("Tag", "Server order :" + order);
    		while(order.compareTo("<START>") != 0){
    			if(order.compareTo("<DELETE>") == 0){
    				filename = dis.readUTF();
    				list.delete(filename);
    			}
    			order = dis.readUTF();
    			Log.d("Tag", "Server order :" + order);
    		}
    		filename = dis.readUTF();
    		path = android.os.Environment.getExternalStorageDirectory().getAbsolutePath()+ "/" + filename;
    		Log.d("Tag", "Filename : " + filename);
    		if(list.search(filename)){
    			dos.writeUTF("<EXIST>");
    			Log.d("Tag", "Send exist Message!");
    			return path;
    		}
    		list.add(filename);
    		dos.writeUTF("<START>");
    		Log.d("Tag", "Send Start Message");
    		file = new File(path);
    		file.createNewFile();
    		fos = new FileOutputStream(file);
            int size = 65536; //사이즈 재조정
            int len;
            byte[] data = new byte[size];
            while ((len = sock.getInputStream().read(data)) > 0) {
            	Log.d("Tag", "Transferring...");
            	fos.write(data, 0, len);
                fos.flush();
            }
            Log.d("Tag", filename + " is received");
            fos.close();
    		return path;
    	}
    }
}