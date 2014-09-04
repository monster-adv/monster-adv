package user.action;
import user.*;

public class UserValidEmailAction {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	public boolean isValidEmail(String email){
		return userDAO.isValidEmail(email);
	}
}
