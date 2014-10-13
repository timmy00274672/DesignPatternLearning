package calculator;

import java.util.Scanner;

public class WorstCalculator {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Input A");
		double a = stdin.nextDouble();

		String c;
		do {
			System.out.println("Input operator(+-*/)");
			c = stdin.next();
			// check
			if (c.matches("[+-/|\\u002a]"))
				break;
		} while (true);

		System.out.println("Input B");
		double b = stdin.nextDouble();
		double d;
		// System.out.println(Integer.toHexString('*'));
		switch (c) {
		case "+":
			d = a + b;
			break;
		case "-":
			d = a - b;
			break;
		case "*":
			d = a * b;
			break;
		case "/":
			d = a / b;
			break;
		default:
			throw new RuntimeException();
		}
		System.out.println(d);

	}
}
