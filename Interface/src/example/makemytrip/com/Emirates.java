package example.makemytrip.com;

public class Emirates implements FlightService {

	@Override
	public void getAllFlights() {

		System.out.println("Get flights in Emirates way");
	}

	@Override
	public void doBooking() {

		System.out.println("Do booking in Emirates way");

	}

}
