
public class longestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindromeString("42123"));
	}
	
	public static String longestPalindromeString(String s) {
		if (s == null) {
			return null;
		}
		
		if (s.length() == 1) {
			return s;
		}
		
		int i;
		String longest = s.substring(0,1);
		
		for (i=0;i<s.length(); i++) {
			String tmp = palindrome(s,i,i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			
			tmp = palindrome(s, i, i+1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}
	
	public static String palindrome (String s, int i, int j) {
		while (i >=0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
			i = i - 1;
			j = j+ 1;
		}
		
		return s.substring(i+1, j);
	}
}
