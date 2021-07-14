package src.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/?ref=rp
 */
public class ShortWordLadder {
    public int solution(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> visited = new HashMap<>();

        Queue<Entry> queue = new LinkedList<>();

        populateMap(start, map);

        for (String key : dict) {
            populateMap(key, map);
        }

        visited.put(start, 1);

        Entry entry = new Entry(start, 1);
        queue.add(entry);

        while (!queue.isEmpty()) {
            entry = queue.remove();
            String tmp = entry.word;

            System.out.println("word is " + tmp + " and distance is " + entry.distance);
            if (tmp.equals(end))
                return entry.distance;

            for (var i = 0; i < tmp.length(); i++) {
                String key = tmp.substring(0, i) + "*" + tmp.substring(i + 1);

                List<String> adjacent = map.get(key);
                for (String next : adjacent) {
                    if (!visited.containsKey(next)) {
                        Entry e = new Entry(next, entry.distance + 1);
                        queue.add(e);
                        visited.put(next, 1);
                    }
                }
            }
        }
        return 0;
    }

    private void populateMap(String start, Map<String, List<String>> map) {
        for (var i = 0; i < start.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(start, 0, i).append("*").append(start.substring(i + 1));
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }

            map.get(sb.toString()).add(start);
        }
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("poon");
        dict.add("plee");
        dict.add("same");
        dict.add("poie");
        dict.add("plie");
        dict.add("poin");
        dict.add("plea");

        ShortWordLadder shortWordLadder = new ShortWordLadder();
        System.out.println(shortWordLadder.solution("toon", "plea", dict));
    }


    /*
    https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs/
     */
    public int bidirectionalBfs(String start, String end, List<String> dictionary) {
        if (start.equals(end)) {
            return 1;
        }

        Queue<Entry> queue1 = new LinkedList<>();
        Queue<Entry> queue2 = new LinkedList<>();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        Entry entry1 = new Entry(start, 1);
        Entry entry2 = new Entry(end, 1);

        queue1.add(entry1);
        queue2.add(entry2);

        map1.put(start, 1);
        map2.put(end, 2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Entry tmp1 = queue1.remove();
            Entry tmp2 = queue2.remove();

            for (var i = 0; i < dictionary.size(); i++) {
                if (isAdjacent(tmp1.word, dictionary.get(i)) &&
                    !map1.containsKey(dictionary.get(i))) {
                    Entry e = new Entry(dictionary.get(i), tmp1.distance + 1);
                    if (e.word.equals(end))
                        return e.distance;

                    queue1.add(e);
                    map1.put(dictionary.get(i), tmp1.distance + 1);

                    if (map2.containsKey(tmp2.word)) {
                        return tmp1.distance + tmp2.distance - 1;
                    }
                }
            }

            for (var i = 0; i < dictionary.size(); i++) {
                if (isAdjacent(tmp2.word, dictionary.get(i)) &&
                        !map2.containsKey(dictionary.get(i))) {
                    Entry e = new Entry(dictionary.get(i), tmp2.distance + 1);

                    if (tmp2.word.equals(start))
                        return tmp2.distance;

                    queue2.add(e);
                    map2.put(dictionary.get(i), tmp2.distance + 1);

                    if (map1.containsKey(tmp2.word)) {
                        return tmp2.distance + tmp1.distance - 1;
                    }
                }
            }
        }

        return 0;
    }

    private boolean isAdjacent(String s, String t) {
        int count = 0;

        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                count++;
        }

        return count == 1;
    }
}

class Entry {
    String word;
    int distance;

    public Entry(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }
}
