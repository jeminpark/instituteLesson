package controll;

import models.Bank;

public class BankManager {
	
	private FileManager fm = FileManager.instance;
	private AccountManager am = AccountManager.instance;
	private UserManager um = UserManager.instance;

	public static BankManager instance = new BankManager();
	private BankManager() {}
	
	public void run() {
		
		fm.load();
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.getName()+"ATM");
			printMenu();
			isRun = selectMenu();
		}
		fm.save();
		
	}
	private void printMenu() {
		if(Bank.log == -1) {
			System.out.println("1.�α���\n2.ȸ������\n3.����");
		}
		else {
			System.out.println("1.�Ա�\n2.���\n3.��ü\n4.��ȸ\n5.���°���\n6.����öȸ\n7.�α׾ƿ�");
		}
		if(Bank.log == 0) {
			System.out.println("8.������");
		}
	}
	private boolean selectMenu() {
		String input = Bank.scan.next();
		try {
			int sel = Integer.parseInt(input);
			
			if(Bank.log == -1) {
				if(sel == 1) {
					Bank.log = um.login();
				}
				else if(sel == 2) {
					um.joinUser();
				}
				else if(sel == 3) {
					System.out.println("�����մϴ�");
					return false;
				}
			}
			else {
				if(sel == 1) {
					am.inputMoney();
				}
				else if(sel == 2) {
					am.outMoney();
				}
				else if(sel == 3) {
					am.withdraw();
				}
				else if(sel == 4) {
					am.printAcc();
				}
				else if(sel == 5) {
					am.createAcc();
				}
				else if(sel == 6) {
					am.deleteAcc();
				}
				else if(sel == 7) {
					Bank.log = -1;
				}
			}
			if(sel == 8 && Bank.log == 0) {
				System.out.println("1.��ü������ȸ\n2.��ü������ȸ\n3.�ڷΰ���");
				selectAdmin();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}
	private void selectAdmin() {
		String input = Bank.scan.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(sel == 1) {
				um.printAllData();
			}
			else if(sel == 2) {
				am.printAllData();
			}
			else if(sel == 3) {
				printMenu();
			}
		}
		catch(Exception e) {
			
		}
	}
}
