package analysis;

import bean.AnalysisResult;

public class AnalysisThread implements Runnable
{
	AnalysisResult genderInfo;
		
	public AnalysisThread(AnalysisResult genderInfo)
	{
		this.genderInfo = genderInfo;
	}	
	
	public void run() {
		
		this.NativeCall(genderInfo);
		
	}
	native void NativeCall(AnalysisResult gender);
	static{
		System.loadLibrary("genderr");
	}
}
