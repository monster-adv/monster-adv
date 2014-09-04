package user;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import user.action.UserDeleteAction;
import user.action.UserLoginAction;
import user.action.UserModifyAction;
import user.action.UserRegistAction;
import user.action.UserValidEmailAction;
import user.action.UserValidIdAction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class UserDependencyInjector {
	
	private DataSource dataSource;
	
	public void start(){				
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try{
			cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		cpds.setUser("system");
		cpds.setPassword("system");
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		dataSource = cpds;
	}
	
	public void shutDown(){
		try{
			DataSources.destroy(dataSource);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Object getObject(@SuppressWarnings("rawtypes") Class type){

		if(type==UserDAO.class){
			return createUserDAO();
		}
		else if(type==UserModifyAction.class){
			return createUserModifyAction();
		}else if(type==UserValidIdAction.class){
			return createUserValidAction();
		}else if(type==UserDeleteAction.class){
			return createUserDeleteAction();
		}else if(type==UserLoginAction.class){
			return createUserLoginAction();
		}else if(type==UserRegistAction.class){
			return createUserRegistAction();
		}
		else if(type==UserValidEmailAction.class){
			return createUserValidEmailAction();
		}
		return null;
	}

	private UserDAO createUserDAO(){
		UserDAO userDAO = new UserDAOImple();
		userDAO.setDataSource(dataSource);
	
		return userDAO;
	}
	private UserValidEmailAction createUserValidEmailAction(){
		UserValidEmailAction action = new UserValidEmailAction();
		action.setUserDAO(createUserDAO());
		return action;
	}
	
	private UserModifyAction createUserModifyAction(){
		UserModifyAction action = new UserModifyAction();
		action.setUserDAO(createUserDAO());
		return action;
	}
	
	private UserValidIdAction createUserValidAction(){
		UserValidIdAction action = new UserValidIdAction();
		action.setUserDAO(createUserDAO());
		return action;
	}
	
	private UserDeleteAction createUserDeleteAction(){
		UserDeleteAction action = new UserDeleteAction();
		action.setUserDAO(createUserDAO());
		return action;
	}
	
	private UserLoginAction createUserLoginAction(){
		UserLoginAction action = new UserLoginAction();
		action.setUserDAO(createUserDAO());
		return action;
	}
	
	private UserRegistAction createUserRegistAction(){
		UserRegistAction action = new UserRegistAction();
		action.setUserDAO(createUserDAO());
		return action;
	}
}
