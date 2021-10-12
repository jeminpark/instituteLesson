package controller;

import models.Shop;

public class ShopManager {

	private static ItemManager im = ItemManager.instance;
	private static UserManager um = UserManager.instance;
	public static ShopManager instance = new ShopManager();
	private ShopManager() {}
	
	public void run() {
		
		System.out.println(Shop.getName());
		boolean isRun = true;
		while(isRun) {
			printMenu();		
			isRun = selectMenu();
		}
	}
	private void printMenu() {
		
		if(Shop.log == -1) {
			System.out.println("1.회원가입\n2.로그인\n3.종료");
		}
		else {
			System.out.println("1.쇼핑\n2.장바구니\n3.로그아웃\n4.회원탈퇴");
		}
		if(Shop.log == 0) {
			System.out.println("5.관리자모드");
		}
			
			
	}
	
	private boolean selectMenu() {
		String input = Shop.scan.next();
		try {
			int sel = Integer.parseInt(input);
			
			if(Shop.log == -1) {
				if(sel == 1) {
					um.joinUser();
				}
				else if(sel == 2) {
					um.login();
				}
				else if(sel == 3) {
					System.out.println("종료합니다.");
					return false;
				}
			}
			else {
				if(sel == 1) {
					im.run();
				}
				else if(sel == 2) {
					
				}
				else if(sel == 3) {
					Shop.log= -1;
				}
				else if(sel == 4) {
					
				}
			}
			if(sel == 5 && Shop.log == 0) {
				
			}
		}
		catch(Exception e) {
			
		}
		return true;
		
	}
}
