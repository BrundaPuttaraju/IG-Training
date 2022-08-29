package practice.optional.com;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

		String email = "brunda@yahoo.com";
		String emailNull = null;

		// Optional.empty() : It creates an empty optional object.

		Optional<Object> emptyOptional = Optional.empty();
		System.out.println("Optional.empty() output : " + emptyOptional);

		// Optional.of() : It creates an Optional object with specified not null value.

		Optional<String> emailOptional = Optional.of(email);
		System.out.println("Optional.of() output : " + emailOptional);

		// Optional.ofNullable() : It creates an Optional object with specified value if
		// the value is not null. If the value is null, it returns an empty Optional.

		Optional<String> stringOptional = Optional.ofNullable(email);
		System.out.println("Optional.ofNullable() output when value is not null : " + stringOptional);

		Optional<String> stringOptional1 = Optional.ofNullable(emailNull);
		System.out.println("Optional.ofNullable() output when value is null : " + stringOptional1);

		// Extraction :
		// get() : This method returns the value present in the Optional object. If the
		// value is absent, throws NoSuchElementException.

		System.out.println("Using get() methhod : " + stringOptional.get());

		// when value is absent
		// System.out.println(stringOptional1.get());

		// orElse() : It Returns the value present in the Optional object. If the value
		// is absent, returns the supplied value.

		String dafaultOptional = stringOptional1.orElse("default@gmail.com");
		System.out.println(dafaultOptional);

		// isPresent() : Returns true if the value is present, otherwise returns false.

		if (stringOptional.isPresent()) {
			System.out.println(stringOptional.get());
		} else {

			System.out.println("No value present");
		}

		// ifPresent() : Performs the specified action if the value is present,
		// otherwise no action taken.

		Optional<String> gender = Optional.of("Female");
		Optional<String> empty = Optional.empty();

		gender.ifPresent((s) -> System.out.println("Value is present"));
		empty.ifPresent((s) -> System.out.println("No value is present"));

		// orElseGet() : Returns the value if the value is present, otherwise returns
		// result of specified supplier.

		String orElseGet = stringOptional1.orElseGet(() -> "default@123.com");
		System.out.println(orElseGet);

		// orElseThrow() : Returns the value if the value is present, otherwise throws
		// an exception created by the specified supplier.

		String optionalThrow = stringOptional1.orElseThrow(() -> new IllegalArgumentException("Email is not exist"));
		System.out.println(optionalThrow);

	}

}
