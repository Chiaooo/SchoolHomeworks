package javaclass.classmission.factorymission_interface;

public class Mul implements Operation {

	@Override
	public double getResult(double x, double y) {
		return x * y;
	}
}
