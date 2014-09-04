package signage.action;

import java.util.Collection;

import signage.DigitalSignage;
import signage.DigitalSignageDAO;

public class DigitalSignageSearchAction {
	private DigitalSignageDAO digitalSignageDAO;

	
	public Collection<DigitalSignage> search(double x1, double y1, double x2, double y2)
	{
		return digitalSignageDAO.search(x1, y1, x2, y2);
	}

	public void setDigitalSignageDAO(DigitalSignageDAO digitalSignageDAO)
	{
		this.digitalSignageDAO=digitalSignageDAO;
	}

}
