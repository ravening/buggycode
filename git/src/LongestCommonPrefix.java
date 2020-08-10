package git.src;

//Program to find the longest common prefix from the given strings
public class LongestCommonPrefix {
	public void solution(String[] strings) {
		if (strings == null || strings.length == 0) {
			return;
		}

		int curLen = 0;

		//stores length of longest common prefix
		int maxLen = 0;

		for (int i = 1; i < strings.length; i++) {
			//compare each string with first string and get the common prefix
			while (curLen < strings[0].length() && curLen < strings[i].length()
					&& strings[0].charAt(curLen) == strings[i].charAt(curLen)) {
				curLen++;
			}
			maxLen = Math.max(curLen, maxLen);
			curLen = 0;
		}

		//display the substring
		System.out.println(strings[0].substring(0, maxLen+1));
	}

}
