package StaticBlockInitialization.com;

public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {

	}

	/*
	 * Instance of class is created in the static block that provides option for
	 * exception handling It creates the instance even before it is being used.
	 */
	static {

		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {

			throw new RuntimeException("Exception occured in creating singleton instance");

		}
	}

	public void showMessage() {

		System.out.println("Singleton object created using static block ");
	}

	public static StaticBlockSingleton getInstance() {

		return instance;
	}
}
