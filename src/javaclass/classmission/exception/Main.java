package javaclass.classmission.exception;

import java.util.Scanner;

/**
 * @author Chiao
 */
public class Main {
	public static void main(String[] args) {
		double[] score = new double[5];
		Scanner in = new Scanner(System.in);
		CheckScore check = new CheckScore();
		System.out.println("请输入该学生的五科成绩：");
		try {
			for (int i = 0; i < score.length; i++) {
				score[i] = in.nextDouble();
			}
			check.check(score);
		} catch (NonCorrectNumException e) {
			e.printStackTrace();
		}
	}
}
