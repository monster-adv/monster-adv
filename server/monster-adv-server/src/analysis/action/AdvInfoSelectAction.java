package analysis.action;

import java.util.ArrayList;

import bean.FilmAdvInfo;
import analysis.AdvInfoDAO;;

public class AdvInfoSelectAction {

	private AdvInfoDAO AdvInfoDAO;
	public void setAdvInfoDAO(AdvInfoDAO AdvInfoDAO)
	{
		this.AdvInfoDAO=AdvInfoDAO;
	}
	public void select(ArrayList<FilmAdvInfo> list)
	{
		AdvInfoDAO.select(list);
	}
}
