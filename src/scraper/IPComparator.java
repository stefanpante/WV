package scraper;
import java.util.Comparator;


public class IPComparator implements Comparator<IP>{

	@Override
	public int compare(IP arg0, IP arg1) {
		long speedDiff = arg0.getSpeed()-arg1.getSpeed();
		if(speedDiff > 0) return 1;
		else if(speedDiff == 0) return 0;
		return -1;
	}

}
