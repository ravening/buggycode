
public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		
		System.out.println(lcs(str1, str2, str1.length(), str2.length()));
	}

	public static int lcs(String x, String y, int m, int n) {
		int[][] array = new int[m+1][n+1];
		
		for (int i =0; i < m; i++) {
			array[i][0] = 0;
		}
		
		for (int j = 0;j<n;j++) {
			array[0][j] = 0;
		}
		
		for (int i =1; i <= m ;i++) {
			for (int j =1; j <= n;j++) {
				
				
				if (x.charAt(i-1) == y.charAt(j-1)) {
					array[i][j] = array[i-1][j-1] + 1;
				} else {
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
				}
			}
		}
		return array[m][n];
	}
}
