package git.src;

public class CompareVersions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "1.0";
		String str2 = "1";

		int value = compare(str1, str2);

		if (value == 0) {
			System.out.println("Strings are equal");
		} else if (value == -1) {
			System.out.println("Str1 is greater than str2");
		} else {
			System.out.println("Str2 is greater than str1");
		}
	}

	public static int compare(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return 0;
		}

		if (str1.length() == 1 && str2.length() == 0) {
			return 0;
		}

		String[] arr1 = str1.split("\\.");
		String[] arr2 = str2.split("\\.");

		int i =0;
		while (i < arr1.length || i < arr2.length) {
			if (i < arr1.length && i < arr2.length) {
				if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
					System.out.println("returning -1");
					return -1;
				} else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
					System.out.println("returning 1");
					return 1;
				} else {
					return 0;
				}
			} else if (i < arr1.length) {
				if (Integer.parseInt(arr1[i]) != 0) {
					System.out.println("returning 1");
					return 1;
				} else {
					System.out.println("returning 0");
					return 0;
				}
			} else if(i < arr2.length) {
				if (Integer.parseInt(arr2[i]) != 0) {
					System.out.println("returning -1");
					return -1;
				} else {
					System.out.println("returning 0");
					return 0;
				}
			}
			i++;
		}
		return 0;
	}
}
