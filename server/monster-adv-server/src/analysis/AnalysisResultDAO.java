package analysis;
import base.DAO;
import bean.AnalysisResult;

import java.util.Calendar;

public interface AnalysisResultDAO extends DAO{
	
	public boolean add(AnalysisResult analysisResult);
//	public boolean delete(AnalysisResult analysisResult);
//	public AnalysisResult search(Calendar StartTime);
}
