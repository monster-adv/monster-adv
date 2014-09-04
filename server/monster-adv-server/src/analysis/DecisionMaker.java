package analysis;
import java.util.ArrayList;

import bean.FilmAdvInfo;
import bean.PeopleKind;
import analysis.action.AdvInfoSelectAction;

public class DecisionMaker
{
	private FloatingPopulationDependencyInjector injector;
	private AdvInfoSelectAction selection;
	private ArrayList<FilmAdvInfo> list = new ArrayList<>();
	private ArrayList<FilmAdvInfo> queue_M = new ArrayList<>();
	private ArrayList<FilmAdvInfo> queue_F = new ArrayList<>();
	private ArrayList<FilmAdvInfo> queue_N = new ArrayList<>();
	private GenderInfo gender;
	private int male, female, cnt_M = 0, cnt_F = 0, cnt_N = 0;
	public DecisionMaker(FloatingPopulationDependencyInjector injector, GenderInfo gender)
	{
		this.injector = injector;
		this.gender = gender;
	}
	public FloatingPopulationDependencyInjector getInjector() {
		return injector;
	}

	public void setInjector(FloatingPopulationDependencyInjector injector) {
		this.injector = injector;
	}
	
	public String decision()
	{
		System.out.println("dicision start");
		int i;
		selection = (AdvInfoSelectAction)injector.getObject(AdvInfoSelectAction.class);
		selection.select(list);
		
		for(i=0;i<list.size();i++){
			if((list.get(i)).getKind() == PeopleKind.M)
			{
				System.out.print("man");
				queue_M.add(list.get(i));
			}
			else if((list.get(i)).getKind() == PeopleKind.F)
			{
				System.out.print("woman");
				queue_F.add(list.get(i));
			}
			else
			{
				System.out.print("natural");
				queue_N.add(list.get(i));
			}
		}
		System.out.println("dicision end");
		male = gender.getMale();
		female = gender.getFemale();
		if(male > female){
			if(cnt_M == queue_M.size())
				cnt_M = 0;
			return queue_M.get(cnt_M++).getLoaction();
		}
		else if(male < female){
			if(cnt_F == queue_F.size())
				cnt_F = 0;
			return queue_F.get(cnt_F++).getLoaction();
		}
		else{
			if(cnt_N == queue_N.size())
				cnt_N = 0;
			return queue_N.get(cnt_N++).getLoaction();
		}
		
		
	}


	
}
