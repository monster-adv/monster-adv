package analysis;

import bean.AnalysisResult;
import analysis.action.AnalysisResultAddAction;

public class AnalysisResultSaveThread implements Runnable{
	
	private AnalysisResultDependencyInjector injector;
	private AnalysisResult genderInfo;
	
	public AnalysisResultSaveThread(AnalysisResultDependencyInjector injector, AnalysisResult gender)
	{
		this.injector = injector;
		this.genderInfo = gender;
	}
	@Override
	public void run() 
	{
		int man_temp = 0;
		int female_temp = 0;
		AnalysisResultAddAction addaction;
		AnalysisResult analysisResult = new AnalysisResult();
		addaction = (AnalysisResultAddAction)injector.getObject(AnalysisResultAddAction.class);

		while(true)
		{
			/*영상이 저장될 조건과 저장되지 않을 조건을 수정하시오...
			 * 1안. 이 함수 내에 타이머를 건다.
			 * 2안. C++에서 Flag를 만든다 (이렇게 되면 타이머가 C++에 있는 셈)
			 * */
			if(man_temp == genderInfo.getMaleCount() && female_temp == genderInfo.getFemaleCount())
			{				
			}
			else
			{
				man_temp = genderInfo.getMaleCount();
				female_temp = genderInfo.getFemaleCount();
				///gender에  시간을 기록하는 변수를 추가 해야 함...
				analysisResult.setMaleCount(man_temp);
				analysisResult.setFemaleCount(female_temp);
				/*시간에 대한 부분을 추가할것*/	
				addaction.add(analysisResult);
			}
		}
	}
	

}
