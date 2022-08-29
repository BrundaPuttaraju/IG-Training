package serializable.singleton.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Singleton_Serializable implements Serializable {
	public static Singleton_Serializable instance = new Singleton_Serializable();

	private Singleton_Serializable() {
		// private constructor
	}

	public class Singleton {

		public static void main(String[] args) {
			try {
				Singleton_Serializable instance1 = Singleton_Serializable.instance;
				ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
				out.writeObject(instance1);
				out.close();

				// deserialize from file to object
				ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));

				Singleton_Serializable instance2 = (Singleton_Serializable) in.readObject();
				in.close();

				System.out.println("instance1 hashCode:- " + instance1.hashCode());
				System.out.println("instance2 hashCode:- " + instance2.hashCode());
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
