package base;

import java.sql.*;
import javax.sql.DataSource;

public class BaseDAO implements DAO{
	private DataSource dataSource;

	
	@Override
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("¿À·ù¾ß!");
		}
		return null;
	}

	@Override

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	void closeDBObject(ResultSet resultSet,Connection connection,Statement statement){
		try {
			if(!resultSet.isClosed()){
				resultSet.close();	
			}
			if(!connection.isClosed()){
				connection.close(); 
			}
			if(!statement.isClosed()){
				statement.close();
			}
		} catch (SQLException e) {
		}
	}
	
}
