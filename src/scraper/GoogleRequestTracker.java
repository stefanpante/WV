package scraper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class GoogleRequestTracker {
	private static final long MINIMUM_REQUEST_INTERVAL = 15000;
	private static final long MINIMUM_REQUEST_RANDOMIZE = 5000;
	private static long latestRequestTime = System.currentTimeMillis()-MINIMUM_REQUEST_INTERVAL;
	private static int userAgentCounter = 0;
	private static ArrayList<String> userAgents = new ArrayList<String>();
	
	public static long timeUntilNextRequest(){
		return System.currentTimeMillis()-latestRequestTime;
	}
	
	public static void waitUntilNextRequest() throws InterruptedException{
		long waitingTime = MINIMUM_REQUEST_INTERVAL-timeUntilNextRequest();
		if(waitingTime<0) waitingTime = 0;
		Thread.sleep(waitingTime+(int) Math.random()*MINIMUM_REQUEST_RANDOMIZE);
	}
	
	public static String waitAndGetUserAgent() throws InterruptedException, IOException{
		waitUntilNextRequest();
		if(userAgents.size() == 0){
			BufferedReader reader = new BufferedReader(new FileReader(new File("user_agent_strings.csv")));
			String s;
			while((s = reader.readLine()) != null) userAgents.add(s);
			reader.close();
		}
		if(userAgentCounter == userAgents.size()) userAgentCounter = 0;
		if(userAgentCounter == 0) shuffle();
		return userAgents.get(userAgentCounter++);
	}
	
	public static void requestFinished(){
		latestRequestTime = System.currentTimeMillis();
	}
	
	private static void shuffle(){
		Collections.shuffle(userAgents);
	}
	
}
