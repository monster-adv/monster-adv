package user;

import base.DAO;


public interface UserDAO extends DAO{
	

	public LoginInfo login(String userID, String password);


	public boolean regist(User user);
	

	public boolean isValidId(String userID);
	

	public boolean isValidEmail(String email);
	

	public boolean modify(User user);

	public boolean delete(User user);
}

