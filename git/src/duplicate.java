import java.util.HashSet;
import java.util.Set;

public class duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,3};
		if (containsDuplicate(nums)) {
			System.out.println("TRUE");
		} else {
			System.out.println("False");
		}
	}
	
	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}

}
