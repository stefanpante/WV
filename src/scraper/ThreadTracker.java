package scraper;
import java.util.ArrayList;


public class ThreadTracker {
	private static ArrayList<Thread> runningScholarThreads = new ArrayList<Thread>();
	
	public static void addScholarThread(Thread t){
		runningScholarThreads.add(t);
	}
	
	public static void removeScholarThread(Thread t){
		runningScholarThreads.remove(t);
	}
	
	public static int amountOfScholarThreads(){
		return runningScholarThreads.size();
	}
	
	public static void waitForScholarThreads(){
		for(Thread t : runningScholarThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("ThreadTracker: Couldn't join a scholar thread");
				e.printStackTrace();
			}
		}
	}
}
