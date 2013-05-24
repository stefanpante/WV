package scraper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class ProxyListGenerator implements Runnable {
	
	public static int PROXY_SPEED_CUTOFF = 10000;
	
	private static boolean started = false;
	
	public static ArrayList<IP> IPList = new ArrayList<IP>();
	
	public static ArrayList<String> CheckedIPList = new ArrayList<String>();
	
	public static Thread runningThread = null;
	
	public static long CHECK_NEW_PROXY_TIME = 10000;
	
	public static long lastLoad = System.currentTimeMillis()-CHECK_NEW_PROXY_TIME;
	public static long lastLoad2 = System.currentTimeMillis()-CHECK_NEW_PROXY_TIME;
	
	private static boolean stop = false;
	
	public static void main(String[] args) throws IOException{
		//long time = System.currentTimeMillis();
		//loadScholar("212.156.91.198",3128);
		//193.227.186.78:3128
		//61.166.55.153:11808

		//System.out.println("Total time: "+(System.currentTimeMillis()-time));
		//while(true) populateIPList();
		updateProxyFile();
	}
	
	public static void updateProxyFile(){
		BufferedReader br = null;
		PrintWriter out = null;
		//ArrayList<String> temp = new ArrayList<String>();
		try{
			br = new BufferedReader(new FileReader("GoogleProxyList.txt"));
			//first line
			//int skip = Integer.parseInt(line);
			//int i = 0;
			//while(i++<skip){
			//	out.println(br.readLine()); //COPY LINES UNTIL SKIP IS REACHED
			//}
			//out.flush();
			String line = null; 
			while ((line = br.readLine()) != null) {

				String[] firstSplit = line.split(" ");
				String[] split = firstSplit[0].split(":");
				System.out.println("Proxy: Testing ip "+line);
				long prevTime = System.currentTimeMillis();
				Boolean result = loadScholar(split[0], Integer.parseInt(split[1]));
				long speed = System.currentTimeMillis()-prevTime;
				if(result) {
					System.out.println("Proxy: writing to file");
				    out = new PrintWriter(new BufferedWriter(new FileWriter("proxy/"+firstSplit[0].replaceAll(":", "-"), true)));
					out.println(speed);
					out.close();
				}else{
					
				}
				System.out.println("Proxy: Elapsed time: "+(speed)/1000+" seconds");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static String loadProxyPage(){
		if(!stop){
			long waitTime = (lastLoad+CHECK_NEW_PROXY_TIME)-System.currentTimeMillis();
			waitTime = waitTime > 0 ? waitTime : 0;
			if(waitTime>0) System.out.println("Sleeping for "+waitTime/1000+" seconds");
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lastLoad = System.currentTimeMillis();
			/*while(IPList.size() >= 10){
				System.out.println("Proxy: 10 or more valid proxies found. Pausing one minute.");
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					System.out.println("Proxy: Couldn't go to sleep.");
					e.printStackTrace();
				}
			}*/
			System.out.println("Proxy: loading raw proxy data");
			try {
				return Scraper.loadURL("http://www.ip-adress.com/proxy_list/");
			} catch (Exception e) {
				System.out.println("Proxy: failed to load raw proxy data");
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}/*
	public static String loadProxyPage2(){
		if(!stop){
			long waitTime = (lastLoad2+CHECK_NEW_PROXY_TIME)-System.currentTimeMillis();
			waitTime = waitTime > 0 ? waitTime : 0;
			if(waitTime>0) System.out.println("Sleeping for "+waitTime/1000+" seconds");
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lastLoad2 = System.currentTimeMillis();
			/*while(IPList.size() >= 10){
				System.out.println("Proxy: 10 or more valid proxies found. Pausing one minute.");
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					System.out.println("Proxy: Couldn't go to sleep.");
					e.printStackTrace();
				}
			}*\/
			System.out.println("Proxy: loading raw proxy data");
			try {
				return Scraper.loadURL("http://www.ip-adress.com/proxy_list/");
			} catch (Exception e) {
				System.out.println("Proxy: failed to load raw proxy data");
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}*/
	
	
	public static ArrayList<String> parseProxyPage(String parseData){
		System.out.println("Proxy: parsing raw proxy data");
		String toFind = "/proxy_list/";
		String newData = parseData;
		String foundIP;
		String oldNewData = "";
		ArrayList<String> IPList = new ArrayList<String>();
		while(oldNewData.equals(newData) == false){
			oldNewData = newData;
			newData = StringOperations.extractFrom(newData, toFind);
			foundIP = StringOperations.extractBefore(newData, "\"");
			if(foundIP.indexOf('?')<0) IPList.add(foundIP);
		}
		return IPList;
	}
	/*
	public static ArrayList<String> parseProxyPage2(String parseData){
		System.out.println("Proxy: parsing raw proxy data");
		String toFind = "/proxy_list/";
		String newData = parseData;
		String foundIP;
		String oldNewData = "";
		ArrayList<String> IPList = new ArrayList<String>();
		while(oldNewData.equals(newData) == false){
			oldNewData = newData;
			newData = StringOperations.extractFrom(newData, toFind);
			foundIP = StringOperations.extractBefore(newData, "\"");
			if(foundIP.indexOf('?')<0) IPList.add(foundIP);
		}
		return IPList;
	}*/
	
	public static void generateIPList(ArrayList<String> IPList){
		for(String ip : IPList) {
			IP goodIP = testIP(ip);
			if(goodIP != null) {
			//	System.out.println("Adding ip "+goodIP.getIp()+":"+goodIP.getPort()+" with speed "+goodIP.getSpeed());
				ProxyListGenerator.IPList.add(goodIP);
				IPComparator comp = new IPComparator();
				String before = IPList.get(0);
				Collections.sort(ProxyListGenerator.IPList, comp);
				if(!IPList.get(0).equals(before)) System.out.println("Proxy: new fastest proxy found ->"+IPList.get(0));
				//System.out.println(ProxyListGenerator.IPList);
			}
		}
	}
	
	public static void populateIPList(){
		started = true;
		generateIPList(parseProxyPage(loadProxyPage()));
	}
	
	public static boolean hasStarted(){
		return started;
	}
	
	public static IP testIP(String ip){
		if(!stop){
			boolean checkIP = true;
			for(String s : CheckedIPList){
				if(s.equals(ip)) checkIP = false;
			}
			if(checkIP){
				CheckedIPList.add(ip);
				String[] split = ip.split(":");
				ip = split[0];
				int port = Integer.parseInt(split[1]);
				System.out.println("Proxy: Testing: "+ip+":"+port);
				long firstTime = System.currentTimeMillis();
				Boolean result = loadScholar(ip, port);
				long secondTime = System.currentTimeMillis();
				long time = secondTime-firstTime;
				if(result && time<PROXY_SPEED_CUTOFF) {
					try {
					    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("GoogleProxyList.txt", true)));
					    out.println(ip+":"+port);
					    out.close();
					} catch (IOException e) {
					    //oh noes!
					}
					System.out.println("Proxy: Accepting "+ip+":"+port);
					return new IP(ip, port, time);
				}
			}
		}
		return null;
	}
	
	public static boolean foundIP(){
		return IPList.size() > 0;
	}

	public void run() {
		populateIPList();
	}
	
	public static void stop(){
		System.out.println("Proxy: stopping.");
		stop = true;
	}
	
	public static String loadAcademics(String query, String ip, int port){
		try {
			query = query.replace(" ","%20");
			System.out.println("Proxy: polling academics to test ip and speed");
			//String result =  Scraper.loadURL("http://academic.research.microsoft.com/Search?query="+query, ip, port);
			String result = Scraper.loadURL("http://scholar.google.com/scholar?hl=en&q=Google&btnG=&as_sdt=1%2C5&as_sdtp=", ip, port);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			System.out.println("Proxy: failed to poll academics");
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "";
		}
	}
	public static Boolean loadScholar(String ip, int port){
		try {
			System.out.println("Proxy: polling scholar to test ip and speed");
			//String result =  Scraper.loadURL("http://academic.research.microsoft.com/Search?query="+query, ip, port);
			String result = Scraper.loadURL("http://scholar.google.com/", ip, port, 1500);
			//System.out.println(result);
			return !result.equals("");
		} catch (Exception e) {
			System.out.println("Proxy: failed to poll scholar");
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}
}
