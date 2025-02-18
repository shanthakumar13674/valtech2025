package day2;

public class ArithmeticImpl implements Arithmetic {

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
		return a-b;
	}

	@Override
	public double mul(double a, double b) {
		return a*b;
	}

	@Override
	public double div(double a, double b) {
		return a/b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

}
