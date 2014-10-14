package cash_register;

import java.util.HashMap;
import java.util.Map;

public class CashStategy {
	public static interface CountMethod {
		double getSum(int number, double price);
	}
	private static Map<String, CountMethod> strategy;
	static{
		strategy = new HashMap<>();
		strategy.put("NORMAL", new CountMethod() {
			@Override
			public double getSum(int number, double price) {
				return number * price;
			}
		});
		
		strategy.put("HALF", new CountMethod() {
			@Override
			public double getSum(int number, double price) {
				return 0.5 * number * price;
			}
		});
	}
	
	public static Map<String, CountMethod> getStrategy(){
		return strategy;
	}
}
