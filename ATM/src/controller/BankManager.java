package controller;

import models.Bank;

public class BankManager {
	
	private UserManager um = UserManager.instance;

	public static BankManager instance = new BankManager();
	private BankManager() {}
	
	public void run() {
		//실행 시작
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.getName()+ "ATM");
			printMenu();
			selectMenu();
		}
	}
	public void printMenu() {
		um.printUser();
		if(Bank.log == -1) {
			System.out.println("1.로그인\n2.회원가입\n3.종료");
			
		}
		else {
			System.out.println("1.회원탈퇴\n2.계좌관리\n3.뱅킹관리\n4.파일관리\n5.관리자모드\n6.로그아웃");
		}
	}
	public void selectMenu() {
		String input = Bank.scan.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(Bank.log == -1) {
				if(sel == 1) {
					Bank.log = um.login();
				}
				else if(sel == 2) {
					um.joinUser();
					//회원가입 메소드호출
				}
				else if(sel == 3) {
					System.out.println("종료합니다.");
					
					
				}
			}
			else {
				if(sel == 1) {
					um.removeUser(Bank.log);
					Bank.log = -1;				
				}
				else if(sel == 2) {
					System.out.println("1.계좌생성\n2.계좌철회\n");
					if(sel == 1) {
						um.addAccount(Bank.log);
					}
						
					else if(sel == 2) {
						
					}
					
				}
				else if(sel == 3) {
					
				}
				else if(sel == 4) {
					
				}
				else if(sel == 5) {
					
				}
				else if(sel == 6) {
					System.out.println("로그아웃합니다.");
					Bank.log = -1;
				}
			}
		}
		catch(Exception e) {
			
		}
				
		
	}
}
