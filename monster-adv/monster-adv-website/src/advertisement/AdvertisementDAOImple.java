package advertisement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;


import base.BaseDAO;

public class AdvertisementDAOImple extends BaseDAO implements AdvertisementDAO{


	private final String ADV_INSERT ="INSERT INTO adv_info(adv_num, name, master_id, signage_id,people_kind,adv_kind,locate,time,sum,men_count,women_count)"
                                    +" VALUES (ADV_SEQUENCE.NEXTVAL,?,?,?,?,?,?,?,?,0,0)";
	public boolean insert(Advertisement adv) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		
		try
		{
			connection = getConnection();
			pStatement = connection.prepareStatement(ADV_INSERT);
			pStatement.setString(1,adv.getName());
			pStatement.setString(2,adv.getMasterId());
			pStatement.setString(3,adv.getSignageId());
			pStatement.setString(4,adv.getPeopleKind());
			pStatement.setString(5,adv.getAdvKind());
			pStatement.setString(6,adv.getLocate());
			pStatement.setInt(7,adv.getTime());
			pStatement.setInt(8,adv.getSum());
			System.out.println(pStatement.toString());
			pStatement.execute();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}
/**/
	public boolean delete(Advertisement adv) {
		return false;
	}

	private final String SEARCH_BY_MASTER_ID = "SELECT * FROM adv_info WHERE MASTER_ID=?";
	public Collection<Advertisement> search(String masterID) {
		
		Connection connection=null;
		PreparedStatement pStatement = null;
		Collection<Advertisement> result = new LinkedList<Advertisement>();
		ResultSet set=null;
		try
		{
			connection = getConnection();
			pStatement=connection.prepareStatement(SEARCH_BY_MASTER_ID);
			pStatement.setString(1,masterID);
			set=pStatement.executeQuery();
			while(set.next())
			{

				String adv_num = set.getString("adv_num");
				String name = set.getString("name");
				String userId = set.getString("master_id");
				String signageId = set.getString("signage_id");
				String advKind = set.getString("adv_kind");
				String peopleKind = set.getString("people_kind");
				String locate = set.getString("locate");
				
				int time = set.getInt("time");
				int sum = set.getInt("sum");
				int men_count = set.getInt("men_count");
				int women_count = set.getInt("women_count");
				
				Advertisement adv = new Advertisement(name,adv_num,userId,signageId,peopleKind,advKind,time,sum,men_count,women_count,locate);
			
				result.add(adv);
			
			}		
		}
		catch(Exception e)
		{
		}
			return result;
	}
	@Override
	public Collection<Advertisement> search(StringBuilder signageID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
