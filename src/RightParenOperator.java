
public class RightParenOperator extends Operator{

	public RightParenOperator() {

		precedence = 2;
	}

	public int getPrecedence() {
		return precedence;
	}

	public double evaluate(double a, double b) {
		throw new UnsupportedOperationException();
	}
}