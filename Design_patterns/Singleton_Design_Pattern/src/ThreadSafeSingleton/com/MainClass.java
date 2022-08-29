package ThreadSafeSingleton.com;

public class MainClass {

	public static void main(String[] args) {
		
		ThreadSafeSingleton t1;
		ThreadSafeSingleton t2;
		
		t1 = ThreadSafeSingleton.getInstance();
		t2 = ThreadSafeSingleton.getInstance();
		
		t1.showMessage();
		t2.showMessage();
		
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
	}

}
