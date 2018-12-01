// given a start string and end string and set of words, find if
// start string can be converted to end string by replacing one character
// which exists in dictionary

// example : start: "cog"
//end: "bad"
//set: ["bag", "cag", "cat", "fag", "con", "rat", "sat", "fog"]

package Strings;

import java.util.Iterator;
import java.util.List;

public class StartToEndString {
    public boolean solution(List<String> set, String start, String end) {
        if (start.length() != end.length())
            return false;

        if (stringDiff(start, end) == 1)
            return true;

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String tmp = iterator.next();
            if (stringDiff(start, tmp) == 1) {
                iterator.remove();
                return solution(set, tmp, end);
            }
        }
        return false;
    }

    public int stringDiff(String start, String end) {
        int diff = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(1))
                diff++;
        }

        return diff;
    }
}
