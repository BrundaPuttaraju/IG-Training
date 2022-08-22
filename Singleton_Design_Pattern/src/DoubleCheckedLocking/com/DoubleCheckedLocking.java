package DoubleCheckedLocking.com;

public class DoubleCheckedLocking {

	private static DoubleCheckedLocking instance;

	private DoubleCheckedLocking() {

	}

	public static DoubleCheckedLocking getInstance() {

		if (instance == null) {
			synchronized (DoubleCheckedLocking.class) {
				if (instance == null) {
					instance = new DoubleCheckedLocking();
				}
			}
		}
		return instance;
	}

	public void showMessage() {

		System.out.println("Singleton object is created using Thread Safe double checked locking instantiation");
	}
}
