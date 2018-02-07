import java.util.*;
public class posixNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "33+4*";
		evaluate(str);
	}
	
	public static void evaluate(String str) {
		Stack mystack = new Stack();
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 0 && ch <= 9) {
				mystack.push(ch);
			} else {
				Integer int2 = Integer.parseInt((String) (mystack.pop()));
				Integer int1 = Integer.parseInt((String) (mystack.pop()));
				switch (ch) {
				case '+':
					mystack.push(int1 + int2);
					break;
				case '-':
					mystack.push(int1 - int2);
					break;
				case '*':
					mystack.push(int1 * int2);
					break;
				case '/':
					mystack.push(int1 / int2);
					break;
				}
			}
		}
		
		int res = (int) mystack.pop();
		System.out.println(res);
	}

}
