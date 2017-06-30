package singleLinkedList;
//Given a linked list, find the sum of last n node

public class SumOfNNodes {
	public int solution(ListNode head, int n) {
		if (n == 0) {
			return 0;
		}
		
		if (head == null) {
			return 0;
		}
		
		ListNode cur, tmp;
		cur = tmp = head;
		int sum = 0, temp = 0;
		
		while (cur != null && n > 0) {
			sum += cur.getdata();
			n--;
		}
		
		while (cur != null) {
			sum += cur.getdata();
			temp += tmp.getdata();
			
			cur = cur.getnext();
			tmp = tmp.getnext();
		}
		
		return (sum - temp);
	}
}
