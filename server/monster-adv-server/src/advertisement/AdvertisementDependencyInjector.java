package advertisement;

import javax.sql.DataSource;

import advertisement.action.AdvertisementSearchAction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;


public class AdvertisementDependencyInjector {

	private DataSource dataSource;
	
	public void start()
	{		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try{
			cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		cpds.setUser("system");
		cpds.setPassword("0000");
		
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

		if(type==AdvertisementSearchAction.class)
			return createAdvertisementSearchAction();
		return null;
	}
	
	private AdvertisementDAO createAdvInfoDAO()
	{
		AdvertisementDAO advInfoDAO = new AdvertisementDAOImple();
		advInfoDAO.setDataSource(dataSource);
		return advInfoDAO;
	}
	private AdvertisementSearchAction createAdvertisementSearchAction()
	{
		AdvertisementSearchAction action = new AdvertisementSearchAction();
		action.setAdvInfoDAO(createAdvInfoDAO());
		return action;
	}

}
