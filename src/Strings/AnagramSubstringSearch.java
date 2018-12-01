// https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

package Strings;

public class AnagramSubstringSearch {
    public void solution(String string, String pattern) {
        int MAX = 256;
        int[] countS = new int[MAX];
        int[] countP = new int[MAX];

        int n = string.length();
        int m = pattern.length();

        for (int i = 0; i < MAX; i++) {
            countS[string.charAt(i)]++;
            countP[pattern.charAt(i)]++;
        }

        for (int i = m; i < n; i++) {
            if (compare(countS, countP)) {
                System.out.println("Found at index " + (i - m));
            }

            countS[string.charAt(i)]++;
            countS[string.charAt(i-m)]--;
        }

        if (compare(countS, countP)) {
            System.out.println("Found at index " + (n-m));
        }
    }

    public boolean compare(int[] arrA, int[] arrB) {
        for (int i = 0; i < 256; i++) {
            if (arrA[i] != arrB[i])
                return false;
        }

        return true;
    }
}
