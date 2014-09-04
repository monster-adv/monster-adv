package analysis;

import bean.AnalysisResult;
import analysis.action.AnalysisResultAddAction;

public class AdvSave implements Runnable{
	
	private FloatingPopulationDependencyInjector injector;
	private GenderInfo gender;
	private int man_temp;
	private int female_temp;
	private AnalysisResult result;
	
	public AdvSave(FloatingPopulationDependencyInjector injector, GenderInfo gender)
	{
		this.injector = injector;
		this.gender = gender;
		man_temp = 0;
		female_temp = 0;
		result = new AnalysisResult();
	}
	@Override
	public void run() 
	{
		while(true)
		{
			AnalysisResultAddAction addaction;
			addaction = (AnalysisResultAddAction)injector.getObject(AnalysisResultAddAction.class);
			
			if(man_temp == gender.male && female_temp == gender.female)
			{
				
			}
			else
			{
				man_temp = gender.male;
				female_temp = gender.female;
				
				result.setNumOfMr(man_temp);
				result.setNumOfMs(female_temp);
				
				addaction.add(result);
				System.out.println("result: " + result.getNumOfMr() +"   " +result.getNumOfMs() );
			}
		}
	}
	

}
