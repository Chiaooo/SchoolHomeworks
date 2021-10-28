package javaclass.classmission.birthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Chiao
 */
public class CalculateBirthday {
	public static String calculate(String birthday) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = sdf.parse(birthday);
		Date date = new Date();
		long secondNow = date.getTime();
		long secondBirth = birthdayDate.getTime();
		long result = secondNow - secondBirth;
		if (result < 0) {
			return "日期错误";
		} else {
			return "距离出生已经:" + (result / 1000 / 60 / 60 / 24) + "天";
		}
	}

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		System.out.println("输入出生日期:");
		String birthday = in.nextLine();
		try {
			System.out.println(calculate(birthday));
		} catch (Exception e) {
			System.err.println("错误：格式为xxxx-xx-xx");
		}
	}
}
