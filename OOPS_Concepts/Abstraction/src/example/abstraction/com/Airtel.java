package example.abstraction.com;

public class Airtel extends SMS_Sender {

	@Override
	public void establishConnectionWithYourTower() {

		System.out.println("Connecting using Airtel way");
	}

	@Override
	public void destroyConnectionWithYourTower() {

		System.out.println("Destroying connection using Airtel way");
	}

}
