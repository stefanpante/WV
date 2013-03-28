package scraper;
//BRON: http://www.codeproject.com/Articles/162790/Fuzzy-String-Matching-with-Edit-Distance#

public class Levenshtein
{

    public static double compare(final String s1, final String s2)
    {
        double retval = 0.0;
        final int n = s1.length();
        final int m = s2.length();
        if (0 == n)
        {
            retval = m;
        }
        else if (0 == m)
        {
            retval = n;
        }
        else
        {
            retval = 1.0 - (Levenshtein.compare(s1, n, s2, m) / (Math.max(n, m)));
        }
        return retval;
    }

    private static double compare(final String s1, final int n, 
                           final String s2, final int m)
    {
        int matrix[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
        {
            matrix[i][0] = i;
        }
        for (int i = 0; i <= m; i++)
        {
            matrix[0][i] = i;
        }

        for (int i = 1; i <= n; i++)
        {
            int s1i = s1.codePointAt(i - 1);
            for (int j = 1; j <= m; j++)
            {
                int s2j = s2.codePointAt(j - 1);
                final int cost = s1i == s2j ? 0 : 1;
                matrix[i][j] = min3(matrix[i - 1][j] + 1, 
                                    matrix[i][j - 1] + 1, 
                                    matrix[i - 1][j - 1] + cost);
            }
        }
        return matrix[n][m];
    }

    private static int min3(final int a, final int b, final int c)
    {
        return Math.min(Math.min(a, b), c);
    }
    
    public static double substring_compare(String first, String second){
    	if(first.equals("") || second.equals("")) return 0;
    	double a = custom_compare(first, second);
    	double b = custom_compare(second, first);
    	return (a > b) ? a : b;
    }
    //NOG AANPASSEN: NIET ENKEL VOORAAN VERWIJDEREN OOK ACHTERAAN!!
    
    private static double custom_compare(String first, String second){
    	System.out.println("Levenshtein: comparing ["+first+"] and ["+second+"]");
    	double oldVal = Levenshtein.compare(first, second);
    	int firstIndex = first.indexOf(" ");
    	if(firstIndex < 0) {
    		System.out.println("Levenshtein: returning value "+oldVal);
    		return oldVal;
    	}
    	String newFirst = first.substring(firstIndex);
    	double newVal = Levenshtein.compare(newFirst, second);
    	if(newVal>oldVal) return custom_compare(newFirst, second);
    	else {
    		int lastIndex = first.lastIndexOf(" ");
    		if(lastIndex < 0) return oldVal;
        	newFirst = first.substring(0,lastIndex);
        	newVal = Levenshtein.compare(newFirst, second);
        	if(newVal>oldVal) return custom_compare(newFirst, second);
        	else {
        		System.out.println("Levenshtein: returning value "+oldVal);
        		return oldVal;
        	}
    	}
    }
}