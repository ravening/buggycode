package binarySearchTree;
import java.util.*;
class node {
	public char val;
	public node left, right;
	
	public node(char x) {
		val = x;
		left = right = null;
	}
	
}

public class postfixEval {

	node t, t1, t2;
	Stack<node> stack = new Stack<node>();
	
	//utility function to check the character is operator or not
	public static boolean isOperator(char ch) {
		if (ch == '+' ||
			ch == '=' ||
			ch == '*' ||
			ch == '/' ||
			ch == '^') {
			return true;
		} else {
			return false;
		}
	}
	
	public node postfix(char[] postfix) {
		//base case if array length is 0
		//dont construct tree and return null
		if (postfix.length == 0) {
			return null;
		}
		
		for (int i =0; i< postfix.length ; i++) {
			//if the character is operand push it to stack
			if (!isOperator(postfix[i])) {
				stack.push(new node(postfix[i]));
			} else {
				//if the character is operator, create a node with value
				//of operator. pop the two top elements of the stack.
				//make the first popped element as the right child, second
				//popped elemednt as the left child of the operator and
				//push the operator onto the stack.
				t = new node(postfix[i]);
				t2 = stack.pop();
				t1 = stack.pop();
				
				t.left = t1;
				t.right = t2;
				
				stack.push(t);
			}
		}
		//once the infix tree is created return the root
		return stack.peek();
	}
	
	public  void inorder(node root) {
		if (root !=null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ab+ef*g*-";
		postfixEval et = new postfixEval();
		char[] postfix = str.toCharArray();
		
		node root = et.postfix(postfix);
		et.inorder(root);
	}

}
