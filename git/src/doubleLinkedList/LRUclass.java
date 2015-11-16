package doubleLinkedList;

import java.util.HashMap;

public class LRUclass extends DLL {
	int capacity;

	LRUclass(int size) {
		super();
		this.capacity = size;
	}
	
	HashMap<Integer, Node> lru = new HashMap<Integer, Node>();
	public void insertInLRU(int val) {
		Node tmp = new Node(val);
		if (!lru.containsKey(val)) {
			if (this.capacity < 5) {
				lru.put(val, tmp);
				this.insertFront(val);
			}
		} else {
			
		}
	}
}
