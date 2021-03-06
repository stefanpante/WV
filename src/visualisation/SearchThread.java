package visualisation;

import java.util.ArrayList;

import visualisation.guielements.SearchResultMenu;
import data.net.AcademicsSearcher;
import data.publication.Publication;
import data.publication.PublicationSearcher;



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
		PublicationSearcher searcher = new AcademicsSearcher();
		try {
			ArrayList<Publication> results = searcher.generalSearch(search, 10);
			if(results.size() > 0){
				gui.menuEnabled = true;
				gui.menu2 = new SearchResultMenu(results, gui);
				gui.menu2.setStartPositionY(44);
			}else{
				gui.showWarning("No results found for this query.");
			}
		} catch (Exception e) {
			gui.showWarning("Search could not be completed!");
			e.printStackTrace();
		}
		gui.stopSearchAnimation();
	}
	
}