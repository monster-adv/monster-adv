package advertisement.action;

import java.util.Collection;

import advertisement.AdvertisementDAO;
import advertisement.*;
public class AdvertisementSearchAction {
	private AdvertisementDAO advertisementDAO;

	
	public Collection<Advertisement> search(String masterId)
	{
		return advertisementDAO.search(masterId);
	}
	public Collection<Advertisement> search(StringBuilder signageId)
	{
		return advertisementDAO.search(signageId);
	}

	
	public void setAdvertisementDAO(AdvertisementDAO advertisementDAO)
	{
		this.advertisementDAO=advertisementDAO;
	}

}
