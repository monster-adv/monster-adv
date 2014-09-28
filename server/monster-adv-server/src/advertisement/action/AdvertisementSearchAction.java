package advertisement.action;

import java.util.ArrayList;

import advertisement.AdvertisementDAO;
import bean.FilmAdvInfo;

public class AdvertisementSearchAction {

	private AdvertisementDAO advertisementDAO;
	public void setAdvInfoDAO(AdvertisementDAO advertisementDAO)
	{
		this.advertisementDAO=advertisementDAO;
	}
	public ArrayList<FilmAdvInfo> search()
	{
		return advertisementDAO.search();
	}
}
