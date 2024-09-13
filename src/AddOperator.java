public class AddOperator extends Operator{
	public AddOperator() {
		precedence = 3;
	}
	@Override
	public int getPrecedence() {
		return precedence;
	}
	@Override
	public double evaluate(double a, double b) {
		return a + b;
	}
}