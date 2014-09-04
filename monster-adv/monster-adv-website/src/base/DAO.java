package base;


import java.sql.Connection;
import javax.sql.DataSource;

public interface DAO {
	public Connection getConnection();
	public void setDataSource(DataSource dataSource);
}
 