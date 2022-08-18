package example.makemytrip.com;

public class InterfaceTest {

	private static FlightManager flightManager = new FlightManager();

	public static void main(String[] args) {

		loadVendors();

		System.out.println("Get all flights...");
		for (FlightService fs : flightManager.getListVendors()) {
			fs.getAllFlights();
		}

		System.out.println("Do booking.");
		for (FlightService fs : flightManager.getListVendors()) {
			fs.doBooking();
		}
	}

	private static void loadVendors() {

		flightManager.addVendor(new Emirates());
		flightManager.addVendor(new JetAirways());
		flightManager.addVendor(new AirIndia());
	}

}
