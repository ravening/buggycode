package src.Strings;

/*
https://www.geeksforgeeks.org/minimum-removals-required-such-that-given-string-consists-only-of-a-pair-of-alternating-characters/
 */
public class MinimumReversalAlternateChar {
    public void solution(String s) {
        int length = 0;

        if (s == null || s.isEmpty())
            return;

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = (char) (i + 1); j <= 'z'; j++) {
                int newLength = findLength(s, i, j);

                length = Math.max(length, newLength);
            }
        }

        System.out.println(length);
    }

    public int findLength(String s, char i, char j) {
        char required = i;
        int length = 0;
        for (char ch : s.toCharArray()) {
            if (ch == required) {
                length++;

                required = required == i ? j : i;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        MinimumReversalAlternateChar solution = new MinimumReversalAlternateChar();
        solution.solution("adebbeeaebd");
    }
}
