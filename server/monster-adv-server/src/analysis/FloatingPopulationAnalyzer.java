package analysis;
import java.net.Socket;
import java.util.ArrayList;

import advertisement.film.AdvOrder;
import analysis.action.AdvInfoSelectAction;
import analysis.action.AnalysisResultAddAction;
import bean.*;





public class FloatingPopulationAnalyzer {
	private FilmAnalyzer filmAnalyzer;
	private VideoReceiver videoReceiver;
	
	public FloatingPopulationAnalyzer() {		
	}
	public FloatingPopulationAnalyzer(FilmAnalyzer filmAnalyzer,VideoReceiver videoReceiver) {
		this.filmAnalyzer = filmAnalyzer;
		this.videoReceiver = videoReceiver;
	}
	
	
	public Socket connectCamera(String ip,int port)
	{
		return videoReceiver.connect(ip,port);
	}
	public void closeCamera()
	{
		videoReceiver.close();
	}
	public boolean isClosed()
	{
		return false;
	}
	public AdvResult broadcast()
	{
		return null;
	}

	public AnalysisResult analysisFilm(Film film)
	{
		
		return null;
	}
	public Film recvVideo()
	{
		return null;
	}
	/**
	 * 쓰레드로 정보를 받아와 분석하고 저장한다.
	 */
	public FilmAnalyzer getFilmAnalyzer() {
		return filmAnalyzer;
	}
	public void setFilmAnalyzer(FilmAnalyzer filmAnalyzer) {
		this.filmAnalyzer = filmAnalyzer;
	}
	public VideoReceiver getVideoReceiver() {
		return videoReceiver;
	}
	public void setVideoReceiver(VideoReceiver videoReceiver) {
		this.videoReceiver = videoReceiver;
	}
	
	public void go()
	{
		/*ArrayList<FilmAdvInfo> list = new ArrayList<>();
		AnalysisResult result = new AnalysisResult();
		result.setNumOfMr(100);
		result.setNumOfMs(10);
		
		
		
		AdvInfoSelectAction selection;
		selection = (AdvInfoSelectAction)injector.getObject(AdvInfoSelectAction.class);
		selection.select(list);*/
		
		FloatingPopulationDependencyInjector injector = new FloatingPopulationDependencyInjector();
		injector.start();
		
		GenderInfo gender = new GenderInfo();
		
		FilmAnalyzer fa = new FilmAnalyzer(gender);
		AdvSave save = new AdvSave(injector, gender);
		AdvOrder order = new AdvOrder(gender, injector);
		
		Thread t1 = new Thread(fa);
		Thread t2 = new Thread(save);
		Thread t3 = new Thread(order);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
