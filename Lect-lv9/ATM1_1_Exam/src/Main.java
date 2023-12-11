import controller.Bank;
import models.BankManager;

public class Main {

	public static void main(String[] args) {
		
		Bank.setName("BANK ATM");
		BankManager.instance.run();
	}
}
