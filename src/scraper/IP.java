package scraper;

public class IP {
	private String ip;
	private int port;
	private long speed;
	
	
	public IP(String ip, int port, long speed){
		this.ip = ip;
		this.port = port;
		this.speed = speed;
	}
	
	public String getIp() {
		return ip;
	}
	public int getPort() {
		return port;
	}
	@Override
	public String toString() {
		return "IP [ip=" + ip + ", port=" + port + ", speed=" + speed + "]";
	}

	public long getSpeed() {
		return speed;
	}
	
}
