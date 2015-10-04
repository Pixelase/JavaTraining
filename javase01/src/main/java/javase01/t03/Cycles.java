package javase01.t03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cycles {

	private static double function(double x) {
		return Math.tan(2 * x) - 3;
	}

	public static Map<Double, Double> getResults(double lowerBound, double upperBound, double step) {
		Map<Double, Double> results = new LinkedHashMap<Double, Double>();
		
		for (double x = lowerBound; x <= upperBound; x += step) {
			results.put(x, function(x));
		}

		return results;
	}

	public static void printResults(Map<Double, Double> results) {
		System.out.println("-------------------------------------------");
		System.out.println("X\t\t|\t\tFunction(X)");
		System.out.println("===========================================");

		for (Entry<Double, Double> entry : results.entrySet()) {
			System.out.printf("%.2f\t\t|\t\t%f\n", entry.getKey(), entry.getValue());
		}
	}

	public static void main(String[] args) {
		double lowerBound = -12, upperBound = 12, step = 0.5;
		
		printResults(getResults(lowerBound, upperBound, step));

	}

}
