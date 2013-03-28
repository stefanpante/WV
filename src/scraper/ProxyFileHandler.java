package scraper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;


public class ProxyFileHandler {
	
	public static void main(String[] args){
		System.out.println(disable("61.156.217.166",8000));
	}
	
	public static final long PROXY_UNLOCK_TIME = 60000;
	
	public static Boolean create(String ip, int port){
		try {
			new FileWriter("proxy/"+ip+"-"+port, true);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean exists(String ip, int port){
		return isEnabled(ip, port) || isDisabled(ip,port) || isLocked(ip, port);
	}
	
	public static Boolean isEnabled(String ip, int port){
		return !isDisabled(ip,port) && !isLocked(ip,port) && (new File("proxy/"+ip+"-"+port)).exists();
	}
	
	public static Boolean isDisabled(String ip, int port){
		return (new File("proxy/-"+ip+"-"+port)).exists();
	}
	
	public static Boolean isLocked(String ip, int port){
		return (new File("proxy/--"+ip+"-"+port)).exists();		
	}
	
	
	public static Boolean disable(String ip, int port){
		File file = new File("proxy/-"+ip+"-"+port);
		if(file.exists()) return true;
		try {
			return file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean enable(String ip, int port){
		if(isEnabled(ip,port)) return true;
		if(isLocked(ip,port)) return false;
		File file = new File("proxy/-"+ip+"-"+port);
		if(file.exists()) return file.delete();
		return true;
	}
	
	public static Boolean lock(String ip, int port){
		if(isEnabled(ip,port)){
			File file = new File("proxy/-"+ip+"-"+port);
			File file2 = new File("--proxy/"+ip+"-"+port);
			if(file2.exists()) return false;
			Boolean ret = file.renameTo(file2);
			//NA PROXY UNLOCK TIME WORDT DE PROXY WEER VRIJGEGEVEN
			Timer timer = new Timer();
			class UnlockTimer extends TimerTask  {
			     String ip;
			     int port;
			     public UnlockTimer(String ip, int port) {
			         this.ip = ip;
			         this.port = port;
			     }
			     @Override
			     public void run() {
			    	 ProxyFileHandler.unlock(ip,port);
			     }
			}
			UnlockTimer task = new UnlockTimer(ip,port);
			timer.schedule(task, PROXY_UNLOCK_TIME);
			return ret;
		}
		return false;
	}
	
	public static Boolean unlock(String ip, int port){
		if(isLocked(ip,port)){
			File file = new File("--proxy/-"+ip+"-"+port);
			File file2 = new File("proxy/"+ip+"-"+port);
			if(file2.exists()) return false;
			return file.renameTo(file2);
		}
		return false;
	}
	
	public static Boolean appendSpeed(String ip, int port, long speed){
		PrintWriter out;
		try {
			if(isDisabled(ip,port)) out = new PrintWriter(new BufferedWriter(new FileWriter("-proxy/"+ip+"-"+port, true)));
			else if(isLocked(ip,port)) out = new PrintWriter(new BufferedWriter(new FileWriter("--proxy/"+ip+"-"+port, true)));
			else out = new PrintWriter(new BufferedWriter(new FileWriter("proxy/"+ip+"-"+port, true)));
			out.println(speed);
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static long averageSpeed(String ip, int port){
		if(!exists(ip,port)) return -1;
		BufferedReader br = null;
		try {
			if(isEnabled(ip, port)) br = new BufferedReader(new FileReader("proxy/"+ip+"-"+port));
			else if(isDisabled(ip, port)) br = new BufferedReader(new FileReader("-proxy/"+ip+"-"+port));
			else if(isLocked(ip, port)) br = new BufferedReader(new FileReader("--proxy/"+ip+"-"+port));
			String line; 
			long speed = 0;
			int i = 0;
			while ((line = br.readLine()) != null) {
				speed += Long.parseLong(line);
				i++;
			}
			br.close();
			return i > 0 ? speed/i : -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} 
	}

}
