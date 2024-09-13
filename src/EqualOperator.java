public class EqualOperator extends Operator{

	public EqualOperator() {
		precedence = 0;
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public double evaluate(double a, double b) {

		throw new UnsupportedOperationException();
	}

}