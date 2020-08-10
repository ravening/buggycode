package git.src;

public class AtoI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1 2     3";
		atoI(str);
	}

	public static void atoI(String str) {
		char flag = '+';
		int i =0;
		str = str.replaceAll("\\s", "");
		double result = 0;
		int len = str.length() - 1;

		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}

		while (i <= len && (str.charAt(i) > '0' && str.charAt(i) < '9')) {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == '-') {
			result = -result;
		}
		System.out.println(result);
	}
}
