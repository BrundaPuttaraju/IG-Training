package StaticBlockInitialization.com;

public class MainClass {

	public static void main(String[] args) {

		StaticBlockSingleton obj;
		StaticBlockSingleton obj1;

		obj = StaticBlockSingleton.getInstance();
		obj.showMessage();
		obj1 = StaticBlockSingleton.getInstance();
		obj1.showMessage();

		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());

	}

}
