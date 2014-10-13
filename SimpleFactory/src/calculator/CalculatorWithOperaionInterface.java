package calculator;

import java.util.Scanner;

public class CalculatorWithOperaionInterface {

	public static void main(String[] args) {
		double firstOprand, secondOperand;
		String operatorString;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Input A");
		firstOprand = stdin.nextDouble();

		do {
			System.out.println("Input operator(+-*/)");
			operatorString = stdin.next();
			// check
			if (operatorString.matches("[+-/|\\u002a]"))
				break;
		} while (true);

		System.out.println("Input B");
		secondOperand = stdin.nextDouble();

		System.out.println(DoubleOperation.getResult(operatorString,
				new double[] { firstOprand, secondOperand }));
	}

}

abstract class DoubleOperation {
	protected String opString;

	protected DoubleOperation(String opString) {
		this.opString = opString;
	}

	abstract double getResult(double[] operands);

	static final DoubleOperation ADD = new DoubleOperation("+") {

		@Override
		public double getResult(double[] operands) {
			double sum = 0;
			for (double d : operands) {
				sum += d;
			}
			return sum;
		}
	};
	static final DoubleOperation MINUS = new DoubleOperation("-") {

		@Override
		public double getResult(double[] operands) {
			if (operands.length != 2)
				throw new RuntimeException("should provide two operands");
			return operands[0] - operands[1];
		}
	};
	static final DoubleOperation TIMES = new DoubleOperation("*") {

		@Override
		public double getResult(double[] operands) {
			if (operands.length == 0)
				throw new RuntimeException(
						"should provide at least one operand");
			double sum = 1;
			for (double d : operands) {
				sum *= d;
			}
			return sum;
		}
	};
	static final DoubleOperation DIVIDES = new DoubleOperation("/") {

		@Override
		public double getResult(double[] operands) {
			if (operands.length != 2)
				throw new RuntimeException("should provide two operands");
			return operands[0] / operands[1];
		}
	};

	static double getResult(String opString, double[] operands) {
		DoubleOperation[] operations = { ADD, MINUS, TIMES, DIVIDES };
		for (DoubleOperation doubleOperation : operations) {
			if (doubleOperation.opString.equals(opString))
				return doubleOperation.getResult(operands);
		}
		throw new RuntimeException("UnSupported Operator");
	}
}
