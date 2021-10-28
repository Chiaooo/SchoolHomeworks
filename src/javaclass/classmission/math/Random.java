package javaclass.classmission.math;

/**
 * @author Chiao
 */
public class Random {
	public static void main(String[] args) {
		for (int i = 10; i >= 0; i--) {
			System.out.println((int) (30 + Math.random() * (70 - 30 + 1)));
		}
	}
}
