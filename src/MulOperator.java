public class MulOperator extends Operator{
	public MulOperator() {
		precedence = 4;
	}
	public int getPrecedence() {
		return precedence;
	}
	@Override
	public double evaluate(double a, double b) {
		return a*b;
	}
}