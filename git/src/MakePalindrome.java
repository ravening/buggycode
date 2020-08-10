package git.src;

public class MakePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "test";
		makepalindrome(str);
	}

	public static void makepalindrome(String str) {
		if (isPalindrome(str)) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			sb.append(ch);
			sb.reverse();
			System.out.println(sb);
			if (isPalindrome(str + sb.toString())) {
				break;
			}
			sb.reverse();
		}
		System.out.println(str + sb.toString());
	}

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return s.equals(sb.reverse().toString());
	}
}
