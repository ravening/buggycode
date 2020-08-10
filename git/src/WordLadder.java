package git.src;

import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	public static int ladder(String begin, String end, Set<String> wordDict) {
		LinkedList<wordNode> queue = new LinkedList<wordNode>();

		wordDict.add(end);
		queue.add(new wordNode(1, begin));

		while (!queue.isEmpty()) {
			wordNode tmp = queue.removeFirst();
			String word = tmp.word;
			if (word.equals(end)) {
				return tmp.length;
			}

			char[] arr = word.toCharArray();

			for (int i=0; i<arr.length;i++) {
				for (char ch = 'a'; ch <='z'; ch++) {
					char t = arr[i];
					arr[i] = ch;

					String newString = new String(arr);
					if (wordDict.contains(newString)) {
						queue.add(new wordNode(tmp.length + 1, newString));
						wordDict.remove(newString);
					}
					arr[i] = t;
				}
			}
		}
		return 0;
	}


}
class wordNode {
	public int length;
	public String word;

	public wordNode(int len, String tmp) {
		this.length = len;
		this.word = tmp;
	}
}
