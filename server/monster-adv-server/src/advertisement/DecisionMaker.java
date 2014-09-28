package advertisement;
import java.util.ArrayDeque;
import java.util.ArrayList;

import bean.FilmAdvInfo;
import bean.PeopleKind;
import advertisement.action.AdvertisementSearchAction;
import analysis.AnalysisResultDependencyInjector;

public class DecisionMaker
{
	private AnalysisResultDependencyInjector injector;	
	private ArrayDeque<FilmAdvInfo> menQueue;
	private ArrayDeque<FilmAdvInfo> womenQueue;
	private ArrayDeque<FilmAdvInfo> natrualQueue;

	public DecisionMaker(AnalysisResultDependencyInjector injector)
	{
		this.injector = injector;
	}
	public AnalysisResultDependencyInjector getInjector() {
		return injector;
	}

	public void setInjector(AnalysisResultDependencyInjector injector) {
		this.injector = injector;
	}
	public void renewQueue()
	{
		AdvertisementSearchAction	selection = (AdvertisementSearchAction)injector.getObject(AdvertisementSearchAction.class);
		
		/*전체 리스트를 받아와 임시 리스트*/
		ArrayList<FilmAdvInfo> tempList	= selection.search();
		menQueue = new ArrayDeque<FilmAdvInfo>();
		womenQueue = new ArrayDeque<FilmAdvInfo>();
		natrualQueue = new ArrayDeque<FilmAdvInfo>();
		
		for(FilmAdvInfo tInfo : tempList)
		{
			if(tInfo.getKind() == PeopleKind.M)
			{
				System.out.print("man");
				menQueue.push(tInfo);
			}
			else if(tInfo.getKind() == PeopleKind.F)
			{
				System.out.print("woman");
				womenQueue.push(tInfo);
			}
			else
			{
				System.out.print("natural");
				natrualQueue.push(tInfo);
			}
		}		
	}
	
	/*남성 여성 일반의 경우에 맞추어 */
	public FilmAdvInfo decision(PeopleKind kind)
	{
		FilmAdvInfo returnInfo;
		
		if(kind.equals(PeopleKind.M)){
			returnInfo = menQueue.pop();
			menQueue.push(returnInfo);			
		}
		else if(kind.equals(PeopleKind.F)){
			returnInfo = womenQueue.pop();
			womenQueue.push(returnInfo);
		}
		else{
			returnInfo = natrualQueue.pop();
			natrualQueue.push(returnInfo);
		}
		return returnInfo;
	}


	
}
