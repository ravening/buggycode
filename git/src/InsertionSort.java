/**
 * 
 */

/**
 * @author rvenkatesh
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {4, 10, 1, 7, 3 , 5, 9, 12, 2};
		insertionSort(array);
	}
	
	public static void insertionSort(int[] array) {
		if (array.length == 1) {
			System.out.println(array);
		}
		int j=0;
		// first element is already sorted. start from the second element
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			for (j = i-1; j >=0 && temp < array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
		for (int i=0; i < array.length; i++) 
			System.out.println(array[i]);
	}

}
