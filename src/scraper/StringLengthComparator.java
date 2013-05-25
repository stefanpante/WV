package scraper;
import java.util.Comparator;

public class StringLengthComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		String sarg0 = (String) arg0;
		String sarg1 = (String) arg1;
		return sarg1.length()-sarg0.length();
	}

}