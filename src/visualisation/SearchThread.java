package visualisation;

import visualisation.guielements.SearchResultMenu;
import lucene.IndexSearcher;
import lucene.PublicationSearcher;
import lucene.SearchResult;
import data.AcademicsSearcher;

class SearchThread extends Thread{
	
	private String search;
	private GUI gui;

	public SearchThread(String search, GUI gui){
		this.search = search;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		gui.startSearchAnimation();
		PublicationSearcher searcher;
		if(Application.live) searcher = new AcademicsSearcher();
		else searcher = new IndexSearcher();
		try {
			SearchResult[] results = searcher.generalSearch(search, 10);
			if(results.length > 0){
				gui.menuEnabled = true;
				gui.menu2 = new SearchResultMenu(results, gui);
				gui.menu2.setStartPositionY(44);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gui.stopSearchAnimation();
	}
	
}