package models;

import controller.Bank;

public class BankManager {
	
	private FileManager fm = FileManager.instance;
	private AccountManager am = AccountManager.instance;
	private UserManager um = UserManager.instance;
	public static BankManager instance = new BankManager();

	private BankManager() {}
	
	public void run() {
		
		fm.load();
		System.out.println(Bank.getName());
		
		
		boolean isRun = true;
		while(isRun) {
			
			printMainMenu();
			isRun = selectMenu();
		}
		fm.save();
	}
	public void printMainMenu() {
		if(Bank.log == -1) {
			System.out.println("1.�α���\n2.ȸ������\n3.����");
		}
		else {
			System.out.println("1.�Ա�\n2.���\n3.��ü\n4.��ȸ\n5.���°���\n6.����öȸ\n7.�α׾ƿ�\n8.ȸ��Ż��\n");
		}
		if(Bank.log == 0) {
			System.out.println("9.�����ڸ��");
		}
	}
	public boolean selectMenu() {
		String input = Bank.scan.next();
		int sel = Integer.parseInt(input);
		if(Bank.log == -1) {
			if(sel == 1) {
				Bank.log = um.login();
			}
			else if(sel == 2) {
				um.addUser();
			}
			else if(sel == 3) {
				System.out.println("�����մϴ�.");
				return false;
			}
		}
		
		else {
			if(sel == 1) {
				am.inputCash();
			}
			else if(sel == 2) {
				am.withdraw();
			}
			else if(sel == 3) {
				am.sendMoney();
			}
			else if(sel == 4) {
				am.printAccs();
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
			else if(sel == 8) {
				um.deleteUser();
			}
			
		}
		if(Bank.log == 0 && sel == 9) {
			System.out.println("1.��ü������ȸ\n2.��ü������ȸ\n3.�ڷΰ���");
			selectAdmin();
		}
		
		return true;
	}
	private void selectAdmin() {
		int sel = Bank.scan.nextInt();
		if(sel == 1) {
			um.printAllUser();
		}
		else if(sel == 2) {
			am.printAllData();
		}
		else if(sel == 3) {
			printMainMenu();
		}
	}
}
