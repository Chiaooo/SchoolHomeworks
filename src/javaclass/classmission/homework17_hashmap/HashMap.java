package javaclass.classmission.homework17_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Chiao
 */
class HashMapTest {
	public static void hashed(String s) {
		int figure = 0;
		int capital = 0;
		int lowercase = 0;
		HashMap<String, StringBuffer> hm = new HashMap<>();
		StringBuffer stringNum = new StringBuffer();
		StringBuffer stringCap = new StringBuffer();
		StringBuffer stringLow = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch >= '0' && ch <= '9') {
				figure++;
				stringNum.append(ch).append(" ");
				hm.put("数字", stringNum);
			} else if (ch >= 'A' && ch <= 'Z') {
				capital++;
				stringCap.append(ch).append(" ");
				hm.put("大写字母", stringCap);
			} else if (ch >= 'a' && ch <= 'z') {
				lowercase++;
				stringLow.append(ch).append(" ");
				hm.put("小写字母", stringLow);
			}
		}
		Set<Map.Entry<String, StringBuffer>> set = hm.entrySet();
		for (Map.Entry<String, StringBuffer> me : set) {
			if ("数字".equals(me.getKey())) {
				System.out.println(me.getKey() + "共" + figure + "个," + "分别为：" + me.getValue());

			} else if ("大写字母".equals(me.getKey())) {
				System.out.println(me.getKey() + "共" + capital + "个," + "分别为：" + me.getValue());

			} else if ("小写字母".equals(me.getKey())) {
				System.out.println(me.getKey() + "共" + lowercase + "个," + "分别为：" + me.getValue());
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入字符串(大小写字母及数字)");
		String str = in.nextLine();
		hashed(str);
	}
}
