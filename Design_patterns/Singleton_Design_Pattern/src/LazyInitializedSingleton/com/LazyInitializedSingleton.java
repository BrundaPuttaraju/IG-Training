package LazyInitializedSingleton.com;

public class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {

	}

	/*
	 * creates the instance in the global access method. Works fine in single
	 * threaded environment but in multi-threaded environment it can cause issues If
	 * multiple threads are inside if loop at the same time. It will destroy the
	 * singleton pattern concept.
	 */

	public static LazyInitializedSingleton getInstance() {

		if (instance == null) {

			instance = new LazyInitializedSingleton();
		}

		return instance;
	}

	public void showMessage() {

		System.out.println("Singleton object is created using lazy instantiation");
	}

}
