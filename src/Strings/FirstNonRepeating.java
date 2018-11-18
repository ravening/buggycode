// https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/

// find the first non repeating character in a stream of characters

package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FirstNonRepeating {
    public void solution(String string) {
        List<Character> list = new ArrayList<>();
        Boolean[] visited = new Boolean[256];
        Arrays.fill(visited, false);

        for (int i = 0; i < string.length(); i++) {
            if (!visited[string.charAt(i)]) {
                // already visited
                if (list.contains(string.charAt(i))) {
                    list.remove((Character)string.charAt(i));
                    visited[i] = true;
                } else {
                    list.add(string.charAt(i));
                }
            }
        }

        if (list.size() != 0) {
            System.out.println("First non repeating char is " + list.get(0));
        }
    }
}
