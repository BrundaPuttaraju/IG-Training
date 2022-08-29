package example.singleInheritance.com;

public class Vehicle {

	private String manufacturer;
	private int year;

	public Vehicle(String manufacturer, int year) {
		
		super();
		this.manufacturer = manufacturer;
		this.year = year;
	}

	public void printDetails() {
		
		System.out.println("Manufacturer: " + manufacturer);
		System.out.println("Year: " + year);

	}
}
