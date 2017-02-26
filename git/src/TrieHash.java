package Trie;

import java.util.HashMap;

class TrieHashNode {
	char c;
	boolean isLeaf;
	HashMap<Character, TrieHashNode> children = new HashMap<Character, TrieHashNode>();
	
	public TrieHashNode() {}
	public TrieHashNode(char x) {
		this.c = x;
	}
}

public class TrieHash {
	private TrieHashNode root = null;
	
	public TrieHash() {
		root = new TrieHashNode();
	}
	
	public void insert(String str) {
		HashMap<Character, TrieHashNode> child = root.children;
		TrieHashNode tmp = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (child.containsKey(c)) {
				tmp = child.get(c);
				child = tmp.children;
			} else {
				tmp = new TrieHashNode(c);
				child.put(c, tmp);
				child = tmp.children;
			}
		}
		tmp.isLeaf = true;
	}
	
	public TrieHashNode searchNode(String str) {
		TrieHashNode tmp = null;
		HashMap<Character, TrieHashNode> child = root.children;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (child.containsKey(c)) {
				tmp = child.get(c);
				child = tmp.children;
			} else {
				return null;
			}
		}
		
		if (tmp.isLeaf == false) {
			return null;
		}
		return tmp;
	}
	
	public boolean search(String str) {
		TrieHashNode tmp = searchNode(str);
		
		if (tmp.isLeaf == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void delete(String str) {
		TrieHashNode tmp = searchNode(str);
		
		if (tmp.isLeaf == true) {
			tmp.isLeaf = false;
		}
	}
}
