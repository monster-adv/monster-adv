package analysis.action;
import java.util.Calendar;

import analysis.AnalysisResult;
import analysis.AnalysisResultDAO;


public class AnalysisResultSearchAction {
	private AnalysisResultDAO analysisResultDAO;
	public void setAnalysisResultDAO(AnalysisResultDAO analysisResultDAO)
	{
		this.analysisResultDAO=analysisResultDAO;
	}
	
  	public AnalysisResult search(Calendar StartTime)
  	{
		return analysisResultDAO.search(StartTime);
	}
}
