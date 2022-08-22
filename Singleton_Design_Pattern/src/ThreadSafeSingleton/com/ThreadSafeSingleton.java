package ThreadSafeSingleton.com;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {

	}

	/*
	 * thread safe singleton class is used to make global access method
	 * synchronized, so that only one thread can execute this method at a time. it
	 * reduces the performance because of cost associated with the synchronized
	 * method
	 */
	public static synchronized ThreadSafeSingleton getInstance() {

		if (instance == null) {

			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

	public void showMessage() {

		System.out.println("Singleton object is created using Thread Safe instantiation");
	}

}
