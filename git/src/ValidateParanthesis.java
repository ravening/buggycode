package git.src;

import java.util.*;
public class ValidateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(1 + [2 * 3)]";
		validate(str);
	}

	public static void validate(String str) {
		HashMap<Character, Character> hash = new HashMap<Character, Character>();
		hash.put('(', ')');
		hash.put('[', ']');
		hash.put('{', '}');

		Stack s = new Stack();

		for (int i =0; i< str.length(); i++) {
			char cur = str.charAt(i);
			if (hash.keySet().contains(cur)) {
				s.push(cur);
			} else {
				if ( (hash.values().contains(cur))) {
					if (!s.isEmpty() && hash.get(s.peek()) == cur) {
						s.pop();
					}
				}
			}
		}

		if (!s.isEmpty()) {
			System.out.println("False");
		} else {
			System.out.println("True");
		}
	}

}
