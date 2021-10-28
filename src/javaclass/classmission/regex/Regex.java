package javaclass.classmission.regex;

import java.util.Scanner;

/**
 * @author Chiao
 */
public class Regex {
	public static void checkRegex(String email) {
		/*
		 * ^ 起始位置
		 * \\w+ 任意字符 a-zA-Z0-9 _，出现一次或多次
		 * ([-+.]\\w+) - + .任意一个出现一次或多次
		 * ([-+.]\\w+)* 括号里面出现0次或多次
		 * @ @分隔
		 *\\. 字符'.'
		 * $结束
		 * */
		String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		if (email.matches(regex)) {
			System.out.println("格式正确");
		} else {
			System.out.println("格式错误");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入邮箱");
		String email = in.nextLine();
		checkRegex(email);
	}
}
