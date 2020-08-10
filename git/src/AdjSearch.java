package git.src;

public class AdjSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,5,6,7,6,5,6,7,8,9,10,11,12,11,10,9,8,7};

		index(array, 7);
	}

	public static void index(int[] array, int target) {
		if (array == null) {
			return;
		}

		int i = 0;

		while (i < array.length && target != array[i]) {
			if (array[i] != target) {
				int delta = target - array[i];
				delta = Math.abs(delta);
				i = i + delta;
			} else {
				break;
			}
		}

		if (i < array.length) {
			System.out.println(i);
		} else {
			System.out.println("NOt found");
		}
	}

}
