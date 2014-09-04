package analysis.action;
import bean.AnalysisResult;
import analysis.AnalysisResultDAO;


 
public class AnalysisResultDeleteAction {
	private AnalysisResultDAO analysisResultDAO;
	public void setAnalysisResultDAO(AnalysisResultDAO analysisResultDAO)
	{
		this.analysisResultDAO=analysisResultDAO;
	}
	public boolean delete(AnalysisResult analysisResult)
	{
		return analysisResultDAO.delete(analysisResult);
	}

}
