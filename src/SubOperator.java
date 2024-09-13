public class SubOperator extends Operator{
	private int precedence;
	public SubOperator() {
		precedence = 3;
	}
	@Override
	public int getPrecedence() {
		return precedence;
	}
	@Override
	public double evaluate(double a, double b) {
		return a - b;
	}
}