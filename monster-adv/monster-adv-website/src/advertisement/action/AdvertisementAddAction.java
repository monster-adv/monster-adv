package advertisement.action;

import advertisement.*;

public class AdvertisementAddAction {
	private AdvertisementDAO advertisementDAO;

	
	public boolean insert(Advertisement adv)
	{
		return advertisementDAO.insert(adv);
	}
	
	public void setAdvertisementDAO(AdvertisementDAO advertisementDAO)
	{
		this.advertisementDAO=advertisementDAO;
	}

}
