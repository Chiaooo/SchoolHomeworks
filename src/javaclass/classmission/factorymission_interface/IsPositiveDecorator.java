package javaclass.classmission.factorymission_interface;

public class IsPositiveDecorator extends Decorator {

	public IsPositiveDecorator(Operation operation) {
		super(operation);
	}

	@Override
	public double getResult(double x, double y) {
		if (x < 0 && y < 0) {
			x = -x;
			y = -y;
		} else if (y < 0) {
			y = -y;
		} else if (x < 0) {
			x = -x;
		}

		return super.getResult(x, y);
	}

}
