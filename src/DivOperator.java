public class DivOperator extends Operator{
	public DivOperator() {
		precedence = 4;
	}
	public int getPrecedence() {
		return precedence;
	}
	@Override
	public double evaluate(double a, double b) {
		return a/b;
	}
}