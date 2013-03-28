package scraper;
import java.util.ArrayList;


public class ProxyFinder {
	
	public static final long CHECK_PROXY_LIST_INTERVAL = 10000*6;
	public static final int SCHOLAR_TIMEOUT = 20000;
	
	public static long lastLoad_ipadressdotcom = System.currentTimeMillis()-CHECK_PROXY_LIST_INTERVAL;
	public static long lastLoad_hidemyassdotcom = System.currentTimeMillis()-CHECK_PROXY_LIST_INTERVAL;

	
	public static void main(String[] args){
		while(true) findProxies();
	}
	
	
	public static void findProxies(){
		ArrayList<String> IPList = parse_ipadressdotcom(load_ipadressdotcom());
		for(String result : IPList){
			String[] split = result.split(":");
			String ip = split[0];
			int port = Integer.parseInt(split[1]);
			if(!ProxyFileHandler.exists(ip, port)){
				ProxyFileHandler.create(ip, port);
				long speed = timeScholar(ip, port);
				if(speed >= 0) {
					System.out.println("ProxyFinder: found new proxy: "+ip+":"+port+" in "+speed/1000+" seconds");
					ProxyFileHandler.appendSpeed(ip, port, speed);
				}
				else {
					//LIJN HIERONDER NIET COMMENTEN!
					System.out.println("ProxyFinder: disabling proxy successful: "+ProxyFileHandler.disable(ip, port));
				}
			}
		}
	}
	
	public static void waitToLoadProxyList(int list){
		long waitTime = 0;
		if(list == 0) waitTime = (lastLoad_ipadressdotcom+CHECK_PROXY_LIST_INTERVAL)-System.currentTimeMillis();
		else if(list == 1) waitTime = (lastLoad_hidemyassdotcom+CHECK_PROXY_LIST_INTERVAL)-System.currentTimeMillis();
		waitTime = waitTime > 0 ? waitTime : 0;
		if(waitTime>0) System.out.println("ProxyFinder: Sleeping for "+waitTime/1000+" seconds");
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(list == 0) lastLoad_ipadressdotcom = System.currentTimeMillis();
		if(list == 1) lastLoad_hidemyassdotcom = System.currentTimeMillis();

	}
	
	public static String load_ipadressdotcom(){
		waitToLoadProxyList(0);
		System.out.println("ProxyFinder: loading raw proxy data (ip-adress)");
		try {
			return Scraper.loadURL("http://www.ip-adress.com/proxy_list/");
		} catch (Exception e) {
			System.out.println("ProxyFinder: failed to load raw proxy data (ip-adress)");
			e.printStackTrace();
			return "";
		}
	}
	
	public static ArrayList<String> parse_ipadressdotcom(String parseData){
		System.out.println("ProxyFinder: parsing raw proxy data (ip-adress)");
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
	
	public static String load_hidemyassdotcom(){
		waitToLoadProxyList(1);
		System.out.println("ProxyFinder: loading raw proxy data (hidemyass)");
		try {
			return Scraper.loadURL("http://www.hidemyass.com/proxy-list/search-238088");
		} catch (Exception e) {
			System.out.println("ProxyFinder: failed to load raw proxy data (hidemyass)");
			e.printStackTrace();
			return "";
		}
	}
	
	public static ArrayList<String> parse_hidemyassdotcom(String parseData){
		System.out.println("ProxyFinder: parsing raw proxy data (hidemyass)");
		ArrayList<String> IPList = new ArrayList<String>();
		try{
		boolean first = true;
		for(String ipHTML : parseData.split("<style>")){
			if(first) first = false;
			else{
				ArrayList<String> invisibleStyles = new ArrayList<String>();
				String styles = ipHTML.substring(0,ipHTML.indexOf("</style>"));
				String[] seperateStyles = styles.split(".");
				for(String seperate : seperateStyles){
					String styleID = seperate.substring(0,seperate.indexOf("{"));
					if(seperate.indexOf("display:none")>-1) invisibleStyles.add(styleID);
				}
			}
			//TODO: test invisible styles
			//TODO: invisible styles negeren, de rest niet
		}
		}catch(Exception e){
			System.out.println("ProxyFinder: couldn't parse hidemyass");
		}
		return IPList;
	}
	
	public static long timeScholar(String ip, int port){
		long currTime = System.currentTimeMillis();
		if(loadScholar(ip, port)){
			return System.currentTimeMillis()-currTime;
		}
		return -1;
	}
	
	public static Boolean loadScholar(String ip, int port){
		try {
			System.out.println("ProxyFinder: polling scholar to test ip and speed");
			String result = Scraper.loadURL("http://scholar.google.com/", ip, port, SCHOLAR_TIMEOUT);
			return !result.equals("");
		} catch (Exception e) {
			System.out.println("ProxyFinder: failed to poll scholar");
			return false;
		}
	}
}

