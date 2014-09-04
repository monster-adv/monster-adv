package advResult.action;

import java.util.Collection;

import advResult.AdvResult;
import advResult.AdvResultDAO;


public class AdvResultSearchAction {
	private AdvResultDAO advResultDAO;

	
	public Collection<AdvResult> search(String advId,String startDate)
	{
		return advResultDAO.search(advId,startDate);
	}	
	public void setAdvResultDAO(AdvResultDAO advResultDAO)
	{
		this.advResultDAO=advResultDAO;
	}

}
