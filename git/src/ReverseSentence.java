package git.src;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "My name is Rakesh venkatesh";
		reverse(string);
	}

	public static void reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		Pattern p = Pattern.compile("[a-zA-Z0-9]+");

		sb = sb.reverse();
		Matcher m = p.matcher(sb);

		while (m.find()) {
			reverseString(sb, m.start(),m.end() - 1);
		}
		System.out.println(sb);
	}
	public static void reverseString(StringBuilder sb, int i, int j) {
		while (i < j) {
			char tmp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, tmp);
			i = i +1;
			j = j -1 ;
		}
	}
}
