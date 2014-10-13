package calculator;

import java.util.Scanner;

public class CalculatorUsingOperationClassAndEnum {

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

		System.out.println(Operation.getResult(operatorString, firstOprand, secondOperand));

	}

}

class Operation {
	static enum Operator {
		PLUS("+"), MINUS("-"), TIMES("*"), DIVIDES("/");

		private final String opString;

		private Operator(String opString) {
			this.opString = opString;
		}

		public String getOpString() {
			return opString;
		}
	}

	static double getResult(String opString, double operand1, double operand2) {
		for (Operator op : Operator.values()) {
			if (opString.equals(op.getOpString()))
				return getResult(op, operand1, operand2);
		}
		throw new RuntimeException();
	}

	static double getResult(Operator op, double operand1, double operand2) {
		switch (op) {
		case PLUS:
			return operand1 + operand2;
		case MINUS:
			return operand1 - operand2;
		case TIMES:
			return operand1 * operand2;
		case DIVIDES:
			return operand1 / operand2;
		default:
			throw new RuntimeException();
		}
	}

}
