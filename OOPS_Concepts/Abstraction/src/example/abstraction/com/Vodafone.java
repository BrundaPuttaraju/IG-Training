package example.abstraction.com;

public class Vodafone extends SMS_Sender {

	@Override
	public void establishConnectionWithYourTower() {

		System.out.println("Connecting using Vodafone way");

	}

	@Override
	public void destroyConnectionWithYourTower() {

		System.out.println("Destroying connection using Vodafone way");

	}

}
