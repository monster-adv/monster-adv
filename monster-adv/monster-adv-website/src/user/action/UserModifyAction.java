package user.action;
import user.*;

public class UserModifyAction {
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	public boolean modify(User user){
		return userDAO.modify(user);
	}
}
