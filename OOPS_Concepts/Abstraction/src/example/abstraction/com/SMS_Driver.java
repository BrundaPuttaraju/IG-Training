package example.abstraction.com;

public class SMS_Driver {

	public static void main(String[] args) {
		
		Airtel air = new Airtel();
		Vodafone vf = new Vodafone();
		
		System.out.println("...Welcome to Airtel network...");
		
		air.establishConnectionWithYourTower();
		air.checkForDND();
		air.checkForTelecomRules();
		air.sendSMS();
		air.destroyConnectionWithYourTower();
		
		System.out.println("----------------------------");
		
		System.out.println("...Welcome to Vodafone network...");
		vf.establishConnectionWithYourTower();
		vf.checkForDND();
		vf.checkForTelecomRules();
		vf.sendSMS();
		vf.destroyConnectionWithYourTower();
		

	}

}
