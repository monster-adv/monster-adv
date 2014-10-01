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
		
		/*gender는 영상 분석에 대한 결과 저장과, 그것에 대한 control할 수 있는 공유 객체이다.*/
		AnalysisResult gender = new AnalysisResult();
		
		/*영상 분석*/
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
