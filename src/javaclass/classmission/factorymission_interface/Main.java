package javaclass.classmission.factorymission_interface;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		System.out.print("输入x:");
		double x = in.nextDouble();
		System.out.print("输入y:");
		double y = in.nextDouble();
		System.out.print("输入操作符:");
		char c = in.next().charAt(0);

		Operation operation = Factory.operation(c);

		System.out.println("没有进行正负数判断之前:" + "x" + c + "y=" + operation.getResult(x, y));
		operation = new IsPositiveDecorator(operation);
		System.out.println("进行正负数判断之后:" + "x" + c + "y=" + operation.getResult(x, y));
	}
}
