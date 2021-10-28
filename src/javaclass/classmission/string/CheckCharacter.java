package javaclass.classmission.string;

import java.util.Scanner;

/**
 * @author Chiao
 */
public class CheckCharacter {
	public static String check(String s) {
		StringBuilder newString = new StringBuilder();
		StringBuilder reverseString = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				reverseString.append(s.charAt(i));
				newString.append(s.charAt(i));
			}
		}
		int count = 0;
		for (int i = 0; i < newString.length(); i++) {
			if (reverseString.reverse().charAt(i) == newString.charAt(i)) {
				count++;
			}
		}
		if (count == newString.length()) {
			return newString + " 是回文串";
		} else {
			return newString + " 不是回文串";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String s = in.nextLine();
		System.out.println(check(s));
	}
}
