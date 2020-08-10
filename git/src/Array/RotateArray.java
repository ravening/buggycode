package git.src.Array;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8};
		int length = array.length;
		int order = 4;
		rotate(array, 0, order-1);
		rotate(array, order, length - 1);
		rotate(array, 0, length -1);
		for (int a : array)
			System.out.println(a);
	}

	public static void rotate(int[] array, int start, int end) {
		if (array == null && array.length == 1)
			return;

		while (start < end) {
			int tmp = array[start];
			array[start] = array[end];
			array[end] = tmp;
			start = start + 1;
			end = end - 1;
		}
	}

}
