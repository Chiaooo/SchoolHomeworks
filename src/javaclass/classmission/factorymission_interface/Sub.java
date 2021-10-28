package javaclass.classmission.factorymission_interface;

public class Sub implements Operation {
	@Override
	public double getResult(double x, double y) {
		return x - y;
	}
}
