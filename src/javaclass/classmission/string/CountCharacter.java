package javaclass.classmission.string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Chiao
 */

public class CountCharacter {

	public static void countCharacter(String str) {
		while (str.length() > 0) {
			char c = str.charAt(0);
			String s = String.valueOf(c);
			String replaceStr = str.replaceAll(s, "");
			int count = str.length() - replaceStr.length();
			str = replaceStr;
			System.out.println(s + ":" + count);
		}

	}

	public static void countCharacterHash(String str) {
		HashMap<Character, Integer> hm = new HashMap<>();
		char[] c = str.toCharArray();

		for (char character : c) {
			if (hm.containsKey(character)) {
				Integer val = hm.get(character);
				val++;
				hm.put(character, val);
			} else {
				hm.put(character, 1);
			}
		}
		for (Character key : hm.keySet()) {
			Integer integer = hm.get(key);
			System.out.println(key + ":" + integer);
		}
	}

	public static void main(String[] args) {
		System.out.println("输入字符串：");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		/* *
		 * 该方法会导致PatternSyntaxException
		 * 	countCharacter(str);
		 * */
		countCharacterHash(str);
	}
}
