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
			/*������ ����� ���ǰ� ������� ���� ������ �����Ͻÿ�...
			 * 1��. �� �Լ� ���� Ÿ�̸Ӹ� �Ǵ�.
			 * 2��. C++���� Flag�� ����� (�̷��� �Ǹ� Ÿ�̸Ӱ� C++�� �ִ� ��)
			 * */
			if(man_temp == genderInfo.getMaleCount() && female_temp == genderInfo.getFemaleCount())
			{				
			}
			else
			{
				man_temp = genderInfo.getMaleCount();
				female_temp = genderInfo.getFemaleCount();
				///gender��  �ð��� ����ϴ� ������ �߰� �ؾ� ��...
				analysisResult.setMaleCount(man_temp);
				analysisResult.setFemaleCount(female_temp);
				/*�ð��� ���� �κ��� �߰��Ұ�*/	
				addaction.add(analysisResult);
			}
		}
	}
	

}
