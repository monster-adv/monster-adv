package advResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;
import base.BaseDAO;

public class AdvResultDAOImple extends BaseDAO implements AdvResultDAO{

	@Override
	public boolean insert(AdvResult result) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(AdvResult result) {
		// TODO Auto-generated method stub
		return false;
	}


	private static final String SEARCH_BY_DATE="SELECT start_time, men_num,women_num  FROM adv_result"+
		" WHERE start_time >= ? AND start_time <= ? AND adv_num=?";
	public Collection<AdvResult> search(String adv_num,String date){

		Connection connection = null;
		PreparedStatement pStatement = null;
		Collection<AdvResult> result = new LinkedList<AdvResult>();
		ResultSet set = null;
		try
		{
			connection = getConnection();
			pStatement = connection.prepareStatement(SEARCH_BY_DATE);
			pStatement.setString(1,date);
			pStatement.setString(2,date+"-99");
			pStatement.setString(3,adv_num);
			set=pStatement.executeQuery();
			while(set.next())
			{
				String timeString = set.getString("start_time");
				int mennum = set.getInt("men_num");
				int womennum = set.getInt("women_num");
				
				AdvResult temp = new AdvResult(null,mennum,womennum,timeString);
				System.out.println(temp);
				result.add(temp);
			}		
		}
		
		catch(Exception e)
		{
		}
		return result;
	}


}
