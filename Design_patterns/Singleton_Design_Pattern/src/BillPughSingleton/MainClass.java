package BillPughSingleton;

public class MainClass {

	public static void main(String[] args) {
		
		BillPughSingleton b1;
		BillPughSingleton b2;
		
		b1 = BillPughSingleton.getInstance();
		b2 = BillPughSingleton.getInstance();
		
		b1.showMessage();
		b2.showMessage();
		
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());

	}

}
