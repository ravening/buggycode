// given a string and a pattern, check if all characters appear
// in string in the same position of the pattern

// if string is hello world and pattern in hlo then return false

package Strings;

import java.util.HashMap;

public class PositionOrdering {
    public boolean solution(String string, String pattern) {
        if (string == null)
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        int pos = 0;
        for (char ch : pattern.toCharArray()) {
            map.put(ch, pos);
            pos++;
        }

        int prev = 0;
        for (char ch : string.toCharArray()) {
            if (map.containsKey(ch)) {
                if (prev > map.get(ch)) {
                    return false;
                }

                prev = map.get(ch);
            }
        }

        return  true;
    }
}
