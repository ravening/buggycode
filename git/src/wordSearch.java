
public class wordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{
			{'N','Y','C'},
			{'C','E','A'},
			{'H','S','N'}
		};
		
		String word = "YES";
		int flag = 0;
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, i, j, 0)) {
					System.out.println("FOUND");
					flag = 1;
				}
			}
		}
		
		if (flag == 0) {
			System.out.println("Not found");
		}
	}
	
	public static boolean dfs(char[][] board, String word, int i, int j, int k) {
		if (board == null || word == null) {
			return false;
		}
		
		int m = board.length;
		int n = board[0].length;
		
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}
		
		char ch = word.charAt(k);
		
		if (board[i][j] == ch) {
			if (k == word.length() - 1) {
				return true;
			}
			
			char tmp = word.charAt(k);
			board[i][j] = '#';
			if (dfs(board, word, i-1, j, k+1) ||
				dfs(board, word, i, j-1, k+1) ||
				dfs(board,word, i+1, j, k+1) ||
				dfs(board, word, i, j+1, k+1) ) {
				return true;
			}
			board[i][j] = tmp;
		}
		return false;
	}
}
