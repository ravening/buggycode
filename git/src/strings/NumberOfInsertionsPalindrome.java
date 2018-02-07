//given a string, find minimum number of insertions to make it palindrome
//find lcs of the string and its reverse. length of the string minus lcs
//length gives the minimum number of insertions.

public class NumberOfInsertionsPalindrome {
	public int solution(String str) {
		if (str == null || str.length() == 1) {
			return 0;
		}
		
		if (str.length() == 2 && str.charAt(0) == str.charAt(1)) {
			return 0;
		}
		
		String rev = new StringBuilder(str).reverse().toString();
		
		int length = str.length();
		
		int[][] LCS = new int[length+1][length+1];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i ==0 || j == 0) {
					LCS[i][j] = 0;
				} else if (str.charAt(i-1) == rev.charAt(j-1)) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		return length - LCS[length][length];
	}
}
