package git.src.strings;

import java.util.*;
public class longestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = longest("ababbbbcabcd");
		System.out.println(i);
	}

	public static int longest(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
//		int length = 0;
//		int right = 0, left = right -1, answer = 0;
//		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//		while (right != str.length()) {
//			char ch = str.charAt(right);
//			Integer prev = map.put(ch, right);
//			System.out.println(prev);
//			if (prev != null) {
//				left = Math.max(left, prev);
//			}
//			answer= Math.max(answer, right - left);
//			right++;
//
//		}
//		return answer;

		Set<Character> set = new HashSet<Character>();
		int length = 0; int answer = 0;

		for (int i=0; i< str.length(); i++) {
			if (set.add(str.charAt(i))) {
				length++;
			} else {
				answer = Math.max(answer, length);
				length = 1;
				set.clear();
				set.add(str.charAt(i));

			}
		}
		return answer;
	}
}
