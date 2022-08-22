package DoubleCheckedLocking.com;

public class MainClass {

	public static void main(String[] args) {
		
		DoubleCheckedLocking d1;
		DoubleCheckedLocking d2;
		
		d1 = DoubleCheckedLocking.getInstance();
		d2 = DoubleCheckedLocking.getInstance();
		
		d1.showMessage();
		d2.showMessage();
		
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());

	}

}
