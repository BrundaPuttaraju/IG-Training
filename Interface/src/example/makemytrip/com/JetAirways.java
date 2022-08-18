package example.makemytrip.com;

public class JetAirways implements FlightService {

	@Override
	public void getAllFlights() {

		System.out.println("Get flights in JetAirways way");

	}

	@Override
	public void doBooking() {

		System.out.println("Do booking in JetAirways way");

	}

}
