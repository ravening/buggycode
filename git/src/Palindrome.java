package git.src;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "red rum sirrtt is murder";
		if (isPalindrome(str)) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	public static boolean isPalindrome(String str) {
		if (str == null || str.length() ==0) {
			return false;
		}

		if (str.length() == 1) {
			return true;
		}
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		for (int i =0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() -i -1)) {
				return false;
			}
		}
		return true;
	}

}
