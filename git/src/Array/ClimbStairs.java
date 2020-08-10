package git.src.Array; /**
 *
 */

/**
 * @author rvenkatesh
 *
 * There are n steps and you can climb either 1 or 2 steps from each stair.
 * In how many distinct ways we can reach the top
 */
public class ClimbStairs {
	public static int numberofways(int n) {
		if (n < 3) {
			return n;
		}

		int[] steps = new int[n];
		steps[0] = 1;
		steps[1] = 2;

		for (int i = 2; i < n; i++) {
			steps[i] = steps[i-1] | steps[i-2];
		}

		return steps[n-1];
	}
}
