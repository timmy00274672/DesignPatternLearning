package cash_registerv2;

import java.util.HashMap;
import java.util.Map;

public class CashStategy {
	public static interface CountMethod {
		double getSum(int number, double price);
	}

	private static Map<String, CountMethod> strategy;
	static {
		// Default operation
		strategy = new HashMap<>();
		strategy.put("NORMAL", new CountMethod() {
			@Override
			public double getSum(int number, double price) {
				return number * price;
			}
		});
	}

	public static String[] getSupportedStrategy() {
		return strategy.keySet().toArray(new String[] {});
	}

	public static CountMethod getStategy(String name) {
		return strategy.get(name);
	}
	
	public static void addStrategy(String key, CountMethod value){
		strategy.put(key, value);
	}
}
