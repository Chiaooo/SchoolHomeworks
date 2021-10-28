package javaclass.classmission.factorymission_abstract;

public abstract class Opertaion {

	private double x, y;

	public abstract double getResult();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
