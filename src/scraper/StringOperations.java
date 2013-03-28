package scraper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.Normalizer;

public class StringOperations {
	
	public static void main(String[] args){
		System.out.println(removeNonLetters_whiteSpace("  Mod\"rn   Information  Retrieval    "));
	}
	
	public static String extractFrom(String string, String begin){
		return extractTextBetween(string, begin, "");
	}
	
	public static String extractBefore(String string, String end){
		return extractTextBetween(string,"",end);
	}
	
	public static String extractTextBetween(String string, String begin, String end){
		Pattern beginPattern = Pattern.compile(begin);
		Pattern endPattern = Pattern.compile(end);
		
		Matcher matcher = beginPattern.matcher(string);
		int beginIndex = -1;
		if(matcher.find()) beginIndex = matcher.end();
		
		matcher = endPattern.matcher(string);
		int endIndex = -1;
		while(matcher.find() && endIndex<beginIndex) endIndex = matcher.start();
		beginIndex = begin.length()>0 && beginIndex > -1 ? beginIndex : 0;
		endIndex = end.length()>0 && endIndex > -1 ? endIndex : string.length();
		return string.substring(beginIndex, endIndex);
	}
	
	public static String[] lineSplit(String data){
		return data.split("\r\n");
	}
	
	public static ArrayList<String> extractWords(String data){
		String[] wordsArr = data.split("([ \\n])");
		ArrayList<String> words = new ArrayList<String>();
		Collections.addAll(words, wordsArr); 
		Iterator<String> iter = words.iterator();
	    while (iter.hasNext()) {
	    	String next = iter.next();
	    	if(next.length() <= 1) iter.remove();
	    }
		return words;
	}
	
	public static int amountOfWords(String data){
		return extractWords(data).size();
	}
	
	public static int amountOfUppercaseWords(String data){
		ArrayList<String> words = extractWords(data);
		Iterator<String> iter = words.iterator();
	    while (iter.hasNext()) {
	    	String next = iter.next();
	    	if(!Character.isUpperCase(next.charAt(0))) iter.remove();
	    }
	    return words.size();
	}
	
	public static double getUppercaseFrequency(String data){
		double amountOfWords = (double) amountOfWords(data);
		double amountOfUppercaseWords = (double) amountOfUppercaseWords(data);
		if(amountOfWords == 0) return 0;
		return amountOfUppercaseWords/amountOfWords;
	}
	
	public static boolean isNumber(String string){
		string = string.replaceAll("[\\W\\s]", "");
		try{
			Double.parseDouble(string);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static int amountOfNumbers(String data){
		ArrayList<String> words = extractWords(data);
		Iterator<String> iter = words.iterator();
	    while (iter.hasNext()) {
	    	String next = iter.next();
	    	if(!isNumber(next)) iter.remove();
	    }
	    return words.size();
	}
	
	public static double getNumberFrequency(String data){
		double amountOfWords = (double) amountOfWords(data);
		double amountOfNumbers = (double) amountOfNumbers(data);
		if(amountOfWords == 0) return 0;
		return amountOfNumbers/amountOfWords;
	}
	
	public static double getAverageLineLength(String data){
		String[] lines = data.split("\n");
		int total = 0;
		for(String s : lines){
			total += s.length();
		}
		return total/lines.length;
	}
	
	public static String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public static String removeNonLetters(String str){
		str = str.replaceAll("\\P{Print}", "");
		return str.replaceAll("[^\\p{L}]", "");
	}
	
	public static String removeNonLetters_whiteSpace(String str){
		str = str.replaceAll("\\P{Print}", "");
		return str.replaceAll("[^\\p{L}]", " ");
	}
	
	//removes white space before and after words
	public static String removeWhiteSpace(String str){
		String regex = "[\\s]{2,}";
		String regex2 = "[\\s]$";
		String regex3 = "^[\\s]";
		str = str.replaceAll(regex, " ");
		str = str.replaceAll(regex2, "");		
		str = str.replaceAll(regex3, "");
		return str;
	}
	
	public static String removeHTMLTags(String str){
		String regex = "[<][^<>]*[>]";
		return str.replaceAll(regex, "");
	}
}
