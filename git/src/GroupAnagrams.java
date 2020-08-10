package git.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupanagram(String[] str) {
		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for (String string : str) {
			char[] ch = new char[26];
			for (int i = 0; i < string.length(); i++) {
				ch[string.charAt(i) - 'a']++;
			}

			String nString = new String(ch);

			if (map.containsKey(nString)) {
				map.get(nString).add(string);
			} else {
				ArrayList<String> array = new ArrayList<>();
				array.add(string);
				map.put(nString, array);
			}
		}

		result.addAll(map.values());

		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = { "god", "dog", "cat", "act", "odg" };
		List<List<String>> list = groupanagram(strings);

		for (List<String> newList : list) {
			if (!newList.isEmpty()) {
				for (int i = 0; i < newList.size(); i++) {
					System.out.println(newList.get(i) + " ");
				}
			}
			System.out.println("\n");
		}
	}

}
