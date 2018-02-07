/*
 * Given a number display the number of permutations which can be
 * generated from it
 * 
 * Eg: 26. Output = 2
 * 		2, 6 => BF
 * 		26 = > Z
 * 
 * 123 => 3
 * 1,2,3 => ABC
 * 12, 3 = >LC
 * 1,23 = > AW
 */
public class numberOfPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 1123;
		System.out.println(displayPermutations(number));
	}

	public static int displayPermutations(int num) {	
		if (num <= 10) {
			return 1;
		}
		
		int lasttwo = num % 100;
		if (lasttwo <= 26) {
			return displayPermutations(num / 100) + displayPermutations(num / 10);
		} else {
			return displayPermutations(num / 10);
		}
	}
}
