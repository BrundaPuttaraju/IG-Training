package FunctionalInterface.com;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PracticeCode {

	public static void main(String[] args) {

		// Functional Interface
		// 1. Predicate - one argument and returns boolean result

		Predicate<String> p = (String s) -> s.length() > 5;
		boolean res = p.test("Java 8 functions");
		System.out.println(res);

		// 1. BiPredicate - two argument and returns boolean result

		BiPredicate<Integer, Integer> p1 = (n1, n2) -> {
			return n1 > n2;
		};

		boolean res1 = p1.test(45, 95);
		System.out.println(res1);

		// Function - both takes input and gives output

		Function<Integer, String> getmultiples = (t) -> t * 10 + " - data multiplied by 10";
		System.out.println(getmultiples.apply(2));

		// Supplier - only output
		
		Supplier<Double> randomNum = () -> Math.random();
		System.out.println(randomNum.get());
	}

}
