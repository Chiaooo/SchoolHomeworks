package javaclass.classmission.factorymission_abstract;

public class OperationFactory {

	public static Opertaion createOperation(char c) {
		Opertaion opertaion = null;
		switch (c) {
			case '+':
				opertaion = new Add();
				break;
			case '-':
				opertaion = new Sub();
				break;
			case '*':
				opertaion = new Mul();
				break;
			case '/':
				opertaion = new Div();
				break;
		}
		return opertaion;
	}
}
