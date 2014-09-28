package advertisement;

import base.DAO;
import bean.FilmAdvInfo;

import java.util.ArrayList;

public interface AdvertisementDAO extends DAO{
	
	public ArrayList<FilmAdvInfo> search();

}
