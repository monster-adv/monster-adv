package analysis.action;
import bean.AnalysisResult;
import analysis.AnalysisResultDAO;



public class AnalysisResultAddAction {
	private AnalysisResultDAO analysisResultDAO;
	public void setAnalysisResultDAO(AnalysisResultDAO analysisResultDAO)
	{
		this.analysisResultDAO=analysisResultDAO;
	}
	public boolean add(AnalysisResult analysisResult)
	{
		return analysisResultDAO.add(analysisResult);
	}
}
