import controll.BankManager;
import models.Bank;

public class Main {
	public static void main(String[] args) {	
	
		Bank.setName("HANA");
		BankManager.instance.run();
		
	}
}
