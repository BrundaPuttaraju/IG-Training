package example.singleInheritance.com;

public class Car extends Vehicle{
	
	private String model;
	private String color;


	public Car(String manufacturer, int year, String model, String color) {
		super(manufacturer, year);
		this.model = model;
		this.color = color;
	}
	
	public void carDetails() {  
	    printDetails();         //calling method from parent class
	    System.out.println("Model: " + model);
	    System.out.println("Color: " + color);
	  }

	

}
