package git.src;

public class ExcelColumns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 27;
		String name = "AB";
		toString(number);
		toNumber(name);
	}

	public static void toString(int number) {
		if (number <= 0) {
			System.out.println("Number should be greater than 0");
		}

		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int rem = number % 26;
			if (rem == 0) {
				sb.append("Z");
				number = (number - 1) / 26;
			} else {
				sb.append((char)('A' + (rem - 1)));
				number = number / 26;
			}
		}
		System.out.println(sb.reverse().toString());
	}

	public static void toNumber(String name) {
		int number = 0;
		for (int i = 0; i < name.length() ; i++) {
			number = number * 26 + (name.charAt(i) - ('A' - 1));
		}

		System.out.println(number);
	}
}
