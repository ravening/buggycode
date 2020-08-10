package git.src;

import javax.xml.stream.events.StartDocument;

//Given a value n, print the "*" in diamond form
public class DrawDiamond {
	public void solution(int n) {
		if (n < 2) {
			return;
		}

		int star =1;
		int reduce = 2;
		int space = (n-1)/2;

		for (int i = 0; i<n; i++) {
			System.out.println(result(space, " ") + result(star, "*") + result(space, " "));
			star += reduce;
			space = (n - star)/2;
			if (star == n) {
				reduce = -2;
			}
		}
	}

	public String result(int n, String string) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += string;
		}

		return result;
	}
}
