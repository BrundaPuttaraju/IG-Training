package BillPughSingleton;

public class BillPughSingleton {

	private BillPughSingleton() {

	}

	/*
	 * used to create Singleton class where too many threads try to get the instance
	 * using inner static helper class
	 */
	private static class SingletonHelper {

		private static final BillPughSingleton instance = new BillPughSingleton();

	}

	public static BillPughSingleton getInstance() {

		return SingletonHelper.instance;
	}

	public void showMessage() {

		System.out.println("Singleton object is created using BillPughSingleton instantiation");
	}

}
