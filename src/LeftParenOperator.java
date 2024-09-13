public class LeftParenOperator extends Operator{
	public LeftParenOperator() {
		precedence = 1;
	}
	public int getPrecedence() {
		return precedence;
	}
	public double evaluate(double a, double b) {
		throw new UnsupportedOperationException();
	}
}