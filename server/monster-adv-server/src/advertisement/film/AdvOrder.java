package advertisement.film;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import analysis.DecisionMaker;
import analysis.FloatingPopulationDependencyInjector;
import analysis.GenderInfo;

public class AdvOrder implements Runnable{
	private ServerSocket serverSocket = null;
	private Socket socket;
	private final int port = 38892;
	private String filename, path, dbg;
	private DataInputStream dis;
	private DataOutputStream dos;
	private FileInputStream fis;
	private DecisionMaker dm;
	private GenderInfo gender;
	private FloatingPopulationDependencyInjector injector;
	
	public AdvOrder(GenderInfo gender, FloatingPopulationDependencyInjector injector)
	{
		this.gender = gender;
		this.injector = injector;
	}
	
	public void run(){
		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			serverSocket.bind(new InetSocketAddress(port));
			System.out.println("Ready");
			socket = serverSocket.accept();
			dm = new DecisionMaker(injector, gender);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			while(true){
				dbg = dis.readUTF();
				System.out.println(dbg);
				if(dbg .compareTo("<REQUEST>") != 0){
					continue;
				}
				System.out.println("Receive Request Message");
				filename = dm.decision();
				dos.writeUTF("<START>");
				System.out.println("Send Start Message");
				dos.writeUTF(filename); // filename DB로부터 가져오기
				System.out.println("Send filename : "+filename);
				dbg = dis.readUTF();
				System.out.println(dbg);
				if(dbg.compareTo("<START>") == 0){
					System.out.println("Receive Start Message");
					File file = new File("C:/AdvFile/" + filename);
					fis = new FileInputStream(file); 
			        int size = 65536; //사이즈 재조정
			        int len;
			        byte[] data = new byte[size];
			        while ((len = fis.read(data)) != -1) {
			        	System.out.println(""+len);
		                dos.write(data, 0, len);
		            }
			        dos.flush();
			        System.out.println("Success Transfer Advertisement File");
				}
				else if(dbg.compareTo("<EXIST>") == 0){
					System.out.println("Receive Exist Message");
				}
			}	
		}
		catch (IOException e) {
		e.printStackTrace();
		}
	}
}

