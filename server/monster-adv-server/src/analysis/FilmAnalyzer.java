package analysis;
import java.util.ArrayList;
import java.util.List;

import bean.AnalysisResult;
import bean.Film;




public class FilmAnalyzer implements Runnable
{
	private Film film;
	GenderInfo gender;
	
	public FilmAnalyzer() {
		this.film = null;
	}
	
	public FilmAnalyzer(GenderInfo gender)
	{
		this.gender = gender;
	}
	
	public FilmAnalyzer(Film film) {
		this.film = film;
	}
	
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	
	/**
	 * 영상을 분석하여 분석된 결과를 반환합니다.
	 * @return result
	 */
	public AnalysisResult analyzeFilm()
	{
		AnalysisResult result = new AnalysisResult();
		
		return result;
	}
	
	/**
	 * 영상을 전달받은 주기마다 분석하여 분석된 결과 리스트를 반환합니다.
	 * @param time
	 * @return result
	 */
	public List<AnalysisResult> analyzeFilm(int time)
	{
		ArrayList list = new ArrayList<AnalysisResult>();
		AnalysisResult result = new AnalysisResult();
		
		
		return list;
	}

	@Override
	public void run() {
		this.NativeCall(gender);
	}
	native void NativeCall(GenderInfo gender);
	static{
		System.loadLibrary("genderr");
	}
}
