package javaclass.classmission.homework16_arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chiao
 */
public class Main {
	public static void bingji() {
		List<String> list1 = new ArrayList<String>();
		list1.add("chen");
		list1.add("wang");
		list1.add("liu");
		list1.add("zhang");
		list1.add("jiao");
		List<String> list2 = new ArrayList<String>();
		list2.add("chen");
		list2.add("hu");
		list2.add("zhang");
		list2.add("jiao");

		list2.removeAll(list1);
		list1.addAll(list2);

		System.out.println(list1);
	}

	public static void jiaoji() {
		List<String> list1 = new ArrayList<String>();
		list1.add("chen");
		list1.add("wang");
		list1.add("liu");
		list1.add("jiao");
		list1.add("zhang");
		List<String> list2 = new ArrayList<String>();
		list2.add("chen");
		list2.add("hu");
		list2.add("zhang");
		list2.add("jiao");

		list1.retainAll(list2);

		System.out.println(list1);
	}

	public static void main(String[] args) {
		System.out.println("交集：");
		jiaoji();
		System.out.println("并集：");
		bingji();
	}
}
