package clone.singleton.com;

public class Singleton_clone implements Cloneable {

	private static Singleton_clone object = new Singleton_clone();

	private static Singleton_clone getInstance() {

		return object;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Singleton_clone instance1 = Singleton_clone.getInstance();
		Singleton_clone instance2 = (Singleton_clone) instance1.clone();
		
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());

	}

}
