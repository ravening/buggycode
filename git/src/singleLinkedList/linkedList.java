package singleLinkedList;

class ListNode {
	private int data;
	private ListNode next;
	
	public ListNode(int val) {
		this.data = val;
		this.next = null;
	}
	
	public int getdata() {
		return this.data;
	}
	
	public ListNode getnext() {
		return this.next;
	}
	
	public void setdata(int val) {
		this.data = val;
	}
	
	public void setnext(ListNode node) {
		this.next = node;
	}
}

public class linkedList {
	private ListNode head, tail;

	public linkedList() {
		head = tail = null;
	}
	
	public void insertFront(int val) {
		ListNode tmp = new ListNode(val);
		if (head == null) {
			head = tmp;
			tail = head;
		} else {
			tmp.setnext(head);
			head.setnext(tmp);
		}
	}
	
	public void insertRear(int val) {
		ListNode tmp = new ListNode(val);
		if (tail == null) {
			head = tmp;
			tail = head;
		} else {
			tail.setnext(tmp);
			tail = tmp;
		}
	}
	
	public void displayList() {
		if (head != null) {
			ListNode tmp = head;
			while (tmp != null) {
				System.out.println(tmp.getdata());
				
				tmp = tmp.getnext();
			}
		} else {
			System.out.println("List empty");
		}
	}
	
	public void deleteNode(int val) {
		ListNode next = head;
		ListNode cur = null;
		if (head != null) {
			while (next.getdata() != val) {
				cur = next;
				next = next.getnext();
			}
			cur.setnext(next.getnext());
		}
	}
	
	public void reverseListIteratively() {
		ListNode cur = head;
		ListNode next = head.getnext();
		ListNode prev = null;
		
		if (head != null || head.getnext() != null) {
		while (cur.getnext() != null) {
			cur.setnext(prev);
			System.out.println(cur.getdata());
			System.out.println(next.getdata());
			prev = cur;
			cur = next;
			next = next.getnext();
		}
		head = cur;
		}
	}
	
	public ListNode reverseOrder(ListNode node) {
		if (node == null || node.getnext() == null) {
			return node;
		}
		
		ListNode pre = node;
		ListNode cur = node.getnext();
		pre.setnext(null);
		while (cur != null) {
			ListNode tmp = cur.getnext();
			cur.setnext(pre);
			pre = cur;
			cur = tmp;
		}
		
		return pre;
	}
	
	public void reorderlist() {
		if (head == null || head.getnext() == null) {
			return;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.getnext() != null && fast.getnext().getnext() != null) {
			slow = slow.getnext();
			fast = fast.getnext().getnext();
		}
		slow.setnext(null);
		ListNode  second = slow.getnext();
		
		second = reverseOrder(second);
		//displayList();
		ListNode p1 = head;
		ListNode p2 = second;
		
		while (p2 != null) {
			ListNode temp1 = p1.getnext();
			ListNode temp2 = p2.getnext();
			
			p1.setnext(p2);
			p2.setnext(temp1);
			p1 = temp1;
			p2 = temp2;
		}
		
		tail = p2;
		displayList();
	}
	
	public void deleteItems(int val) {
		ListNode tmp = new ListNode(0);
		ListNode cur = tmp;
		tmp.setnext(head);
		
		while (tmp != null && tmp.getnext() != null) {
			if (tmp.getnext().getdata() == val) {
				tmp.setnext(tmp.getnext().getnext());
			} else {
				tmp = tmp.getnext();
			}
		}
		head = cur.getnext();
	}
	
	public void mergeSortedLists(ListNode head1, ListNode head2) {
		if (head1 == null) {
			head = head2 != null?head2:null;
		}
		
		if (head2 == null) {
			head = head1;
		}
		
		ListNode tmp = new ListNode(0);
		ListNode cur = tmp;
		
		while (head1 != null && head2 != null) {
			if (head1.getdata() < head2.getdata()) {
				tmp.setnext(head1);
				head1 = head1.getnext();
			} else {
				tmp.setnext(head2);
				head2 = (head2.getnext());
			}
			tmp = tmp.getnext();
		}
		head = cur.getnext();
	}
	
	public void removeDuplicate() {
		if (head == null || head.getnext() == null) {
			return;
		}
		
		ListNode cur = head;
		ListNode next = head.getnext();
		
		while (next != null) {
			if (cur.getdata() == next.getdata()) {
				next = next.getnext();
			} else {
				cur = cur.getnext();
				cur.setdata(next.getdata());
				next = next.getnext();
			}
		}
		cur.setnext(null);
	}
	
	public void removeAllDuplicate() {
		if (head == null || head.getnext() == null) {
			return;
		}
		
		ListNode cur = head;
		ListNode next = head.getnext();
		
		while (next != null) {
			if (cur.getdata() == next.getdata()) {
				next = next.getnext();
			} else {
					cur = cur.getnext();
					cur.setdata(next.getdata());
				next = next.getnext();
			}
		}
		cur.setnext(null);
	}
	
	public void removeParticularElement(int val) {
		if (head == null) {
			return;
		}
		
		ListNode cur = head;
		
		while (cur.getnext() != null) {
			if (cur.getnext().getdata() == val) {
				cur.setnext(cur.getnext().getnext());
			} else {
				cur = cur.getnext();
			}
		}
		
		if (head.getdata() == val) {
			head = head.getnext();
		}
	}
	
	public void swapPairs() {
		head = swapTwoPairs(head);
	}
	
	public ListNode swapTwoPairs(ListNode node) {
		if (node == null || node.getnext() == null) {
			return node;
		}
		
		ListNode next = swapTwoPairs(node.getnext().getnext());
		ListNode tmp = node.getnext();
		node.setnext(next);
		tmp.setnext(node);
		return tmp;
		
		
	}
}
