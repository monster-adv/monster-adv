package analysis;
import base.*;
import bean.AnalysisResult;

import java.sql.*;
import java.util.Calendar;


public class AnalysisResultDAOImple extends BaseDAO implements AnalysisResultDAO{
	private Connection conn;

	private final static String ADD_SQL ="insert into analysis values(to_date(?, 'YYYY-MM-DD HH24:MI:SS'),to_date(?, 'YYYY-MM-DD HH24:MI:SS'),?,?)";
	public boolean add(AnalysisResult analysisResult) {

		Calendar cal = Calendar.getInstance();
		Time time = new Time(cal.getTimeInMillis());
		Date date = new Date(cal.getTimeInMillis());;		
		PreparedStatement pStmt;
		ResultSet rs=null;	
		// TODO Auto-generated method stub
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(ADD_SQL);
			//cal = analysisResult.getStartTime();
			pStmt.setString(1, date.toString() + " " + time.toString());
			//cal = analysisResult.getEndTime();
			date = new Date(cal.getTimeInMillis());
			time = new Time(cal.getTimeInMillis());
			pStmt.setString(2, date.toString() + " " +time.toString());
			pStmt.setInt(3,analysisResult.getMaleCount());
			pStmt.setInt(4, analysisResult.getFemaleCount());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	try {
		rs.close();
		pStmt.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true;
	}
	
/*	public boolean delete(AnalysisResult analysisResult) {
		// TODO Auto-generated method stub
		try {
			conn = getConnection();
			sql = "delete from analysis where StartTime = ? and EndTime = ? and NumOfMr = ?" +
				  " and NumOfMs = ?";
			pStmt = conn.prepareStatement(sql);
			cal = analysisResult.getStartTime();
			d = new Date(cal.getTimeInMillis());
			pStmt.setDate(1, d);
			cal = analysisResult.getEndTime();
			d = new Date(cal.getTimeInMillis());
			pStmt.setDate(2, d);
			pStmt.setInt(3,analysisResult.getNumOfMr());
			pStmt.setInt(4, analysisResult.getNumOfMs());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
*/
/*	public AnalysisResult search(Calendar StartTime) {
		// TODO Auto-generated method stub
		AnalysisResult analysisResult = new AnalysisResult();
		//int i = 1;
		try {
			conn = getConnection();
			sql = "select * from analysis where StartTime = ?";
			pStmt = conn.prepareStatement(sql);
			cal = StartTime;
			d = new Date(cal.getTimeInMillis());
			pStmt.setDate(1, d);
			rs = pStmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				cal.setTime(d);
				analysisResult.setStartTime(cal);
				d = rs.getDate(2);
				cal.setTime(d);
				analysisResult.setEndTime(cal);
				analysisResult.setNumOfMr(rs.getInt(3));
				analysisResult.setNumOfMs(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return analysisResult;
	}*/
}
