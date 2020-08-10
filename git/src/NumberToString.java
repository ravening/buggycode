package git.src;/*
 * Program to display number in string format
 */
import java.util.HashMap;

public class NumberToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 12345;
		display(number);
	}

	public static void display(int number) {
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		int temp = 0;
		hash.put(0, "Zero");
		hash.put(1, "One");
		hash.put(2, "Two");
		hash.put(3, "Three");
		hash.put(4, "Four");
		hash.put(5, "Five");
		hash.put(6, "Six");
		hash.put(7, "Seven");
		hash.put(8, "Eight");
		hash.put(9, "Nine");

		// reverse the number
		while (number > 0) {
			temp = temp * 10 + (number % 10);
			number = number / 10;
		}

		// display the number
		while (temp > 0) {
			System.out.println(hash.get(temp % 10));
			temp = temp / 10;
		}
	}
}
