package practice.optional.com;

import java.util.Optional;

public class OptionalDemo1 {

	public static void main(String[] args) {

		String value = "abc";

		if (value != null && value.contains("abc")) {

			System.out.println(value);
		}

		// filter() : If the value is present and that value matches with the given
		// predicate, then it returns Optional containing the result. Otherwise returns
		// empty Optional.
		// the above code can be written using Optional class as below :

		Optional<String> str = Optional.of(value);

		str.filter(s -> s.contains("abc")).ifPresent((s) -> System.out.println(s));

		// map() : If the value is present, applies given mapping function to it and if
		// the result is null, returns empty Optional. Otherwise returns Optional
		// containing the result.

		str.filter(s -> s.contains("abc")).map(String::toUpperCase).ifPresent((s) -> System.out.println(s));

	}

}
