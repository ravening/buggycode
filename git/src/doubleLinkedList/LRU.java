package doubleLinkedList;

public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUclass lru = new LRUclass(5);
		lru.insertFront(1);
		lru.insertRear(2);
		lru.insertRear(3);
		lru.insertRear(4);
		lru.insertRear(5);
		lru.displayList();
		
	}

}
