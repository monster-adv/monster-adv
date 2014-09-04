package user.action;
import user.*;

public class UserLoginAction {
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	public LoginInfo login(String userId,String password){
		return userDAO.login(userId, password);
	}
}
