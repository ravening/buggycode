package singleLinkedList;

public class linkedListClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedList head = new linkedList();
		head.insertFront(1);
		head.insertRear(2);
		head.insertRear(2);
		head.insertRear(3);
		head.insertRear(4);
		head.insertRear(5);
		head.insertRear(5);
		head.insertRear(5);
		head.insertRear(6);
		
		//head.displayList();
		//head.deleteNode(2);
		//head.displayList();
		//head.reverseListIteratively();
		//head.deleteItems(1);
		//head.displayList();
		//head.reorderlist();
		//head.removeDuplicate();
		//head.removeAllDuplicate();
		//head.removeParticularElement(2);
		//head.removeParticularElement(1);
		head.swapPairs();
		head.displayList();
	}

}
