package advResult;

import javax.sql.DataSource;

import signage.action.DigitalSignageSearchAction;
import user.UserDAO;
import user.UserDAOImple;
import user.action.UserDeleteAction;
import user.action.UserLoginAction;
import user.action.UserModifyAction;
import user.action.UserRegistAction;
import user.action.UserValidEmailAction;
import user.action.UserValidIdAction;

import advResult.action.AdvResultSearchAction;
import advertisement.action.AdvertisementAddAction;
import advertisement.action.AdvertisementSearchAction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class AdvResulttDependencyInjector {

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

		if(type==AdvResultDAO.class){
			return createAdvResultDAO();
		}
		else if(type==AdvResultSearchAction.class){
			return createAdvResultSearchAction();
		}
		return null;
	}
	private AdvResultSearchAction createAdvResultSearchAction() {
		AdvResultSearchAction action = new AdvResultSearchAction();
		action.setAdvResultDAO(createAdvResultDAO());
		return action;
	}

	private AdvResultDAOImple createAdvResultDAO(){
		AdvResultDAOImple advResultDAOImple = new AdvResultDAOImple();
		advResultDAOImple.setDataSource(dataSource);
		return advResultDAOImple;
	}



}
