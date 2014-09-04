package user.action;
import user.*;

public class UserDeleteAction {

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	public boolean delete(User user){
		return userDAO.delete(user);
	}
}
