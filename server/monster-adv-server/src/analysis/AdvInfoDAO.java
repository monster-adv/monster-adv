package analysis;

import base.DAO;
import bean.FilmAdvInfo;

import java.util.ArrayList;

public interface AdvInfoDAO extends DAO{
	
	public void select(ArrayList<FilmAdvInfo> list);

}
