package user.action;
import user.*;

public class UserValidIdAction {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	public boolean isValidId(String userId){
		return userDAO.isValidId(userId);
	}

}
