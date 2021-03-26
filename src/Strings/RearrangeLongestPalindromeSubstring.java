package src.Strings;

import java.util.LinkedHashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/rearrange-string-to-obtain-longest-palindromic-substring/?ref=rp
 */
public class RearrangeLongestPalindromeSubstring {
    public static void solution(String s) {
        if (s == null || s.isEmpty())
            return;

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();

        boolean f = true;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            s1.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue() / 2)));

            s2.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue() - (entry.getValue() + 1) / 2)));
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (f) {
                    s1.append(entry.getKey());
                    f = false;
                } else {
                    s3.append(entry.getKey());
                }
            }
        }

        String result = s1.toString() + s2.reverse().toString() + " " + s3.toString();
        System.out.println(result);
        System.out.println("Longest palindrome length is " + (s1.length() + s2.length()));
    }

    public static void main(String[] args) {
        solution("geeksforgeeks");
        solution("geeksforgeek");
        solution("engineering");
        solution("pqrstsuvwrqp");
    }
}
