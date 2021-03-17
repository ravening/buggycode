package src.Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestNiceSubstring {
    Map<Character, Integer> charMaps = new HashMap<>();

    public String longestNiceSubstring(String s) {
        String longest = "";

        if (s.isEmpty())
            return "";

        for (var i = 0; i < s.length() - 1; i++) {
            for (var j = i; j <= s.length(); j++) {
                if (isNice(s.substring(i, j))) {
                    if (longest.length() < (j - i)) {
                        longest = s.substring(i, j);
                    }
                }
            }
        }

        return longest;
    }

    public boolean isNice(String s) {
        charMaps.clear();

        for (Character ch : s.toCharArray()) {
            charMaps.put(ch, charMaps.getOrDefault(ch, 0) + 1);
        }

        for (Character keys : charMaps.keySet()) {
            if (!(charMaps.containsKey(Character.toUpperCase(keys)) && charMaps.containsKey(Character.toLowerCase(keys)))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        String result = longestNiceSubstring.longestNiceSubstring(s);
        System.out.println(result);
    }
}
