package signage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

import base.BaseDAO;

public class DigitalSignageDAOImple extends BaseDAO implements DigitalSignageDAO{


	private final String SIGNAGE_INSERT ="INSERT INTO digital_signage(id,name,coordinate_x,coordinate_y) VALUES (?,?,?,?)";
	public boolean insert(DigitalSignage signage) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		try
		{
			connection = getConnection();
			pStatement = connection.prepareStatement(SIGNAGE_INSERT);
			pStatement.setString(1, signage.getId());
			pStatement.setString(2, signage.getName());
			pStatement.setDouble(3, signage.getCoordinate_x());
			pStatement.setDouble(4, signage.getCoordinate_y());
			return pStatement.execute();			
		}
		catch(Exception e)
		{
			return false;
		}

	}

	private final String SIGNAGE_DELETE = "DELETE FROM digital_signage WHERE id=? ";
	public boolean delete(DigitalSignage signage) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		try
		{
			connection = getConnection();
			pStatement = connection.prepareStatement(SIGNAGE_DELETE);
			pStatement.setString(1, signage.getId());
			return pStatement.execute();			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	private static final String SEARCH_BY_COORDINATES="select * from digital_signage WHERE coordinate_X BETWEEN ? AND ? AND coordinate_Y BETWEEN ? AND ?";
	public Collection<DigitalSignage> search(double x1, double y1, double x2, double y2) {

		Connection connection=null;
		PreparedStatement pStatement = null;
		Collection<DigitalSignage> result = new LinkedList<DigitalSignage>();
		ResultSet set=null;
		try
		{
			connection = getConnection();
			pStatement=connection.prepareStatement(SEARCH_BY_COORDINATES);
			pStatement.setDouble(1,x1);
			pStatement.setDouble(2,x2);
			pStatement.setDouble(3,y2);
			pStatement.setDouble(4,y1);
			
			set=pStatement.executeQuery();
			while(set.next())
			{
				String id=set.getString("id");
				double x = set.getDouble("coordinate_x");
				double y = set.getDouble("coordinate_y");
				String name = set.getString("name");
				DigitalSignage temp = new DigitalSignage(id,name,x,y);
				result.add(temp);
			}		
		}
		catch(Exception e)
		{
		}
			return result;
	}
	

	@Override
	public Collection<DigitalSignage> search(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigitalSignage search(StringBuilder id) {
		// TODO Auto-generated method stub
		return null;
	}


}
