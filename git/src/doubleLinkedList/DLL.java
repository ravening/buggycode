package doubleLinkedList;

class Node {
	int val;
	Node next;
	Node prev;
	
	Node(int x) {
		this.val = x;
		this.next = this.prev = null;
	}
}

public class DLL {
	Node head,tail;
	
	DLL() {
		head = tail = null;
	}
	
	public void insertFront(int val) {
		Node tmp = new Node(val);
		
		if (head == null) {
			head = tail = tmp;
		} else {
			tmp.next = head;
			head.prev = tmp;
			head = tmp;
		}
	}
	
	public void insertRear(int val) {
		Node tmp = new Node(val);
		
		if (tail == null) {
			tail = tmp;
			head = tmp;
		} else {
			tail.next = tmp;
			tmp.prev = tail;
			tail = tmp;
		}
	}
	
	public void removeFront() {
		if (head == null) {
			return;
		}
		if (head.next == null) {
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
	}
	
	public void removeRear() {
		if (tail == null) {
			return;
		}
		
		if (tail.prev == null) {
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
	}
	
	public boolean isEmpty() {
		return (head == null);
	}

	public void displayList() {
		if (head == null) {
			return;
		}
		
		Node tmp = head;
		
		while (tmp != null) {
			System.out.print(tmp.val + "<->");
			tmp = tmp.next;
		}
	}
}
