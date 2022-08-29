package LazyInitializedSingleton.com;

public class MainClass {

	public static void main(String[] args) {

		LazyInitializedSingleton obj;
		LazyInitializedSingleton obj1;

		obj = LazyInitializedSingleton.getInstance();
		obj1 = LazyInitializedSingleton.getInstance();

		obj.showMessage();
		obj1.showMessage();
		
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
	}

}
