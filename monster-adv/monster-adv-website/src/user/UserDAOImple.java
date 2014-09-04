package user;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.BaseDAO;

public class UserDAOImple extends BaseDAO implements UserDAO{


	private static final String LOGIN_SQL="SELECT id FROM user_info where id=? AND password=?";	
	public LoginInfo login(String userID, String password) {

		Connection connection=null;
		PreparedStatement pStatement = null;
		LoginInfo info = null;
				
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(LOGIN_SQL);
			pStatement.setString(1,userID);
			pStatement.setString(2,password);

			ResultSet set=pStatement.executeQuery();
			set.next();
			info = new LoginInfo(set.getString("id"));
			return info;
		} catch (SQLException e) {
		}
		
		
		return null;
	}
	private static final String REGIST_USER_SQL="INSERT INTO user_info(id,password,name,email)  VALUES (?,?,?,?)";
	@Override
	public boolean regist(User user) {

		Connection connection=null;
		PreparedStatement pStatement = null;
				
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(REGIST_USER_SQL);
			pStatement.setString(1,user.getUserId());
			pStatement.setString(2,user.getPassword());
			pStatement.setString(3,user.getName());
			pStatement.setString(4,user.getEmail());
			pStatement.execute();
			return true;
		
		} catch (SQLException e) {
			return false;
		}
	}

	private static final String CHECK_ID_SQL="SELECT * FROM user_info where id=?";		
	@Override
	public boolean isValidId(String userID) {
		Connection connection=null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();

			pStatement = connection.prepareStatement(CHECK_ID_SQL);
			pStatement.setString(1,userID);
			ResultSet set=pStatement.executeQuery();
			set.next();
			try
			{
				set.getString("id");
			}
			catch(Exception e)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			return true;			
		}
		return false;
	}

	private static final String CHECK_EMAIL_SQL="SELECT * FROM user_info where email=?";		
	@Override
	public boolean isValidEmail(String email) {
		Connection connection=null;
		PreparedStatement pStatement = null;
		try{
			connection = getConnection();

			pStatement = connection.prepareStatement(CHECK_EMAIL_SQL);
			pStatement.setString(1,email);
			ResultSet set=pStatement.executeQuery();
			set.next();
			try
			{
				set.getString("email");
			}
			catch(Exception e)
			{
				return true;
			}
		}
		catch(Exception e){
			return true;
		}
		return false;
	}

	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
