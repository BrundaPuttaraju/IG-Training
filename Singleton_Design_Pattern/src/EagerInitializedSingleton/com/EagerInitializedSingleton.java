package EagerInitializedSingleton.com;

public class EagerInitializedSingleton {

	/*
	 * the instance of singleton class is created at the time of class loading but
	 * has a drawback that instance is created even though client application might
	 * not be using it
	 */
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	private EagerInitializedSingleton() {

	}

	public static EagerInitializedSingleton getInstance() {

		return instance;
	}

	public void checkSingleton() {

		System.out.println("Singleton object created using early instantiation");
	}
}
