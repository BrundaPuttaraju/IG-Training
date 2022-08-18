package example.abstraction.com;

public abstract class SMS_Sender {

	abstract public void establishConnectionWithYourTower();

	public void sendSMS() {

		System.out.println("Sensding SMS to user's number...");
	}

	abstract public void destroyConnectionWithYourTower();

	public void checkForDND() {
		
		System.out.println("Checked for numbers present in DND");
	}

	public void checkForTelecomRules() {
		
		System.out.println("Checked for telecom rules");
	}
}
