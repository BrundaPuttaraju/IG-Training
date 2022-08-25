package FunctionalInterface.com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentsList {

	public static void main(String[] args) {

		List<Student> listOfStudents = new ArrayList<Student>();

		listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));

		listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));

		listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));

		listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));

		listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));

		listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));

		listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));

		listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));

		listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));

		listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

		/*
		 * Predicate - Predicate represents an operation which takes an argument T and
		 * returns a boolean. BiPredicate - Represents a predicate of two arguments
		 */

		Predicate<Student> mathematicsPredicate = (Student student) -> student.getSpecialization()
				.equals("Mathematics");

		List<Student> mathematicsStudents = new ArrayList<Student>();

		for (Student student : listOfStudents) {
			if (mathematicsPredicate.test(student)) {
				mathematicsStudents.add(student);
			}
		}

		System.out.println(mathematicsStudents);

		/*
		 * Consumer - Consumer represents an operation which takes an argument and
		 * returns nothing. BiConsumer - accepts two arguments and returns nothing.
		 */
		Consumer<Student> viewPerc = (Student s1) -> {
			System.out.println(s1.getName() + " : " + s1.getPercentage());
		};

		for (Student stud : listOfStudents) {

			viewPerc.accept(stud);

		}

		/*
		 * Function - Function represents an operation which takes an argument of type T
		 * and returns a result of type R. BiFunction - takes two arguments and produces
		 * a result. UnaryOperator - same as Function but argument and result should be
		 * of same type. BinaryOperator - same as BiFunction but argument and result
		 * should be of same type.
		 */

		Function<Student, String> fun1 = (Student s2) -> s2.getName();

		List<String> studNames = new ArrayList<String>();

		for (Student st : listOfStudents) {

			studNames.add(fun1.apply(st));
		}

		System.out.println(studNames);

		/*
		 * Supplier - Supplier represents an operation which takes no argument and
		 * returns the results of type R.
		 */

		Supplier<Student> studSupplier = () -> new Student(111111, "New Student", 92.9, "Java");

		listOfStudents.add(studSupplier.get());
	}
}