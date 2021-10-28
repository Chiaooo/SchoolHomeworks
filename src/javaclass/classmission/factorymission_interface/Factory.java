package javaclass.classmission.factorymission_interface;

public class Factory {
	public static Operation operation(char c) {
		Operation operation = null;

		switch (c) {
			case '+':
				operation = new Add();
				break;
			case '-':
				operation = new Sub();
				break;
			case '*':
				operation = new Mul();
				break;
			case '/':
				operation = new Div();
				break;
			default:
				break;
		}
		return operation;
	}
}
