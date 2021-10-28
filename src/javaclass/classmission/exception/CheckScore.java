package javaclass.classmission.exception;

/**
 * @author Chiao
 */
public class CheckScore {
	public void check(double[] num) throws NonCorrectNumException {
		double sum = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] < 0 || num[i] > 100) {
				throw new NonCorrectNumException("分数错误，应大于0并且小于100");
			} else {
				sum += num[i];
				System.out.println("第" + (i + 1) + "科目的成绩为：" + num[i]);
			}
		}
		System.out.println("平均成绩为：" + sum / 5);
	}
}
