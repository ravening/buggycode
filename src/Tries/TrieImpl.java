// program to add and search a word in the trie

package Tries;

import javafx.util.Pair;

public class TrieImpl {
    class TrieNode {
        String word;
        boolean isLeaf;
        TrieNode[] children;

        public TrieNode(String word, boolean isLeaf, TrieNode[] children) {
            this.word = word;
            this.isLeaf = isLeaf;
            this.children = children;
        }

        public TrieNode() {
        }

    }

    private TrieNode root = new TrieNode();

    // program to add a word in the trie
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode head = root;
        for (char ch : chars) {
            if (head.children[ch - 'a'] == null) {
                head.children[ch - 'a'] = new TrieNode();
            }

            head = head.children[ch -'a'];
        }
        head.isLeaf = true;
        head.word = word;
    }

    public boolean searchWord(String word) {
        return match(word.toCharArray(), 0 , root);
    }

    public boolean match(char[] chars, int k, TrieNode head) {
        if (k == chars.length) {
            return (head.isLeaf == true && head.word.equals(new String(chars)));
        }

        if (chars[k] != '.') {
            if (head.children[chars[k] - 'a'] != null) {
                return match(chars, k+1, head.children[chars[k] - 'a']);
            }
        } else {
            // . can match any character. so iterate for all the children nodes
            for (int i = 0; i < 26; i++ ) {
                if (head.children[i] != null) {
                    if (match(chars, k+1, head.children[i])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
