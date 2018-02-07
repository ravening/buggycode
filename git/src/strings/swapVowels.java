package Testing;

public class swapVowels {
	public static String reverseVowels(String string) {
		String vowels = "aeiouAEIOU";
		
		char[] ch = string.toCharArray();
		int i = 0;
		int j = string.length() -1;
		
		while (i < j) {
			if (!vowels.contains(String.valueOf(string.charAt(i)))) {
				i++;
				continue;
			}
			
			if (!vowels.contains(String.valueOf(string.charAt(j)))) {
				j--;
				continue;
			}
			
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
			i++;
			j--;
		}
		
		return new String(ch);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "what is my name";
		string = reverseVowels(string);
		System.out.println(string);
	}

}
