package EagerInitializedSingleton.com;

public class MainClass {

	public static void main(String[] args) {
		
		EagerInitializedSingleton obj;
		EagerInitializedSingleton obj1;
		
		obj = EagerInitializedSingleton.getInstance();
		obj.checkSingleton();
		System.out.println(obj.hashCode());
		
		obj1 = EagerInitializedSingleton.getInstance();
		obj1.checkSingleton();
		System.out.println(obj1.hashCode());

	}

}
