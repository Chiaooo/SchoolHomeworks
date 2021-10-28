package javaclass.classmission.factorymission_interface;

public class Add implements Operation {

	@Override
	public double getResult(double x, double y) {
		return x + y;
	}
}
