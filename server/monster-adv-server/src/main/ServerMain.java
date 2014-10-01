package main;

import bean.AnalysisResult;
import advertisement.AdvertisementPlayThread;
import analysis.AnalysisResultSaveThread;
import analysis.AnalysisThread;
import analysis.AnalysisResultDependencyInjector;





public class ServerMain {

	public static void main(String args[])
	{	
		
		AnalysisResultDependencyInjector injector = new AnalysisResultDependencyInjector();
		
		injector.start();
		
		/*gender�� ���� �м��� ���� ��� �����, �װͿ� ���� control�� �� �ִ� ���� ��ü�̴�.*/
		AnalysisResult gender = new AnalysisResult();
		
		/*���� �м�*/
		AnalysisThread analyzeThread = new AnalysisThread(gender);
		
		AnalysisResultSaveThread saveThread = new AnalysisResultSaveThread(injector, gender);		
		AdvertisementPlayThread order = new AdvertisementPlayThread(gender, injector,8000);
		
		Thread t1 = new Thread(analyzeThread);
		Thread t2 = new Thread(saveThread);
		Thread t3 = new Thread(order);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
