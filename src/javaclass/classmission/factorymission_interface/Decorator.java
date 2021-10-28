package javaclass.classmission.factorymission_interface;


abstract class Decorator implements Operation {
	private Operation operation;


	public Decorator(Operation operation) {
		this.operation = operation;
	}

	@Override
	public double getResult(double x, double y) {
		return operation.getResult(x, y);
	}
}
