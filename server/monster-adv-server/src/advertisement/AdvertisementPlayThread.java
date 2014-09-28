package advertisement;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import bean.AnalysisResult;
import bean.FilmAdvInfo;
import bean.PeopleKind;

import analysis.AnalysisResultDependencyInjector;

public class AdvertisementPlayThread implements Runnable{

	private int port;
	private AnalysisResult analysisResult;
	private AnalysisResultDependencyInjector injector;
	
	public AdvertisementPlayThread(AnalysisResult analysisResult, AnalysisResultDependencyInjector injector,int port)
	{
		this.analysisResult = analysisResult;
		this.injector = injector;
		this.port=port;
	}
	
	public void run(){
		int male, female;
		
		try {
			Socket socket;
			ServerSocket serverSocket = null;			
			String dbg;
			DataInputStream dis;
			DataOutputStream dos;
			FileInputStream fis;
			DecisionMaker decisionMaker;
			
			/*connect socket*/
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			serverSocket.bind(new InetSocketAddress(port));
			socket = serverSocket.accept();
			
			decisionMaker = new DecisionMaker(injector);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			FilmAdvInfo selectedInfo=null;
			
			while(true){
				dbg = dis.readUTF();
				System.out.println(dbg);
				if(dbg .compareTo("<REQUEST>") != 0){
					continue;
				}

				System.out.println("Receive Request Message");
				
				
				
				male = analysisResult.getFemaleCount();
				female = analysisResult.getMaleCount();
				if(male > female){
					selectedInfo = decisionMaker.decision(PeopleKind.M);
				}
				else if(male < female){
					selectedInfo = decisionMaker.decision(PeopleKind.F);
				}
				else{
					selectedInfo = decisionMaker.decision(PeopleKind.N);
				}
				
				dos.writeUTF("<START>");
				
				dos.writeUTF(selectedInfo.getLoaction()); // filename DB�κ��� ��������
				
				dbg = dis.readUTF();
				System.out.println(dbg);
				if(dbg.compareTo("<START>") == 0){
					System.out.println("Receive Start Message");

					File file = new File("C:/AdvFile/" + selectedInfo.getLoaction());
					fis = new FileInputStream(file); 
			        int size = 65536; //������ ������
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
				/*����� ���� ������ �ϴ� �κ��� �������� �ʴ´�.*/
			}	
		}
		catch (IOException e) {
		e.printStackTrace();
		}
	}
}
