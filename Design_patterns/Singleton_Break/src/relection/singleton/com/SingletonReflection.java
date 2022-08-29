package relection.singleton.com;

import java.lang.reflect.Constructor;

public class SingletonReflection {

	public static SingletonReflection instance = new SingletonReflection();

	private SingletonReflection() {

	}

	public class Singleton {

		public static void main(String[] args) {

			SingletonReflection instance1 = SingletonReflection.instance;
			SingletonReflection instance2 = null;

			try {

				Constructor[] constructors = SingletonReflection.class.getDeclaredConstructors();

				for (Constructor constructor : constructors) {
					constructor.setAccessible(true);
					instance2 = (SingletonReflection) constructor.newInstance();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("instance1.hashCode():- " + instance1.hashCode());
			System.out.println("instance2.hashCode():- " + instance2.hashCode());

		}

	}
}
