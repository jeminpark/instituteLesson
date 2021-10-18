package controller;

import models.Shop;

public class ShopManager {

	private static ItemManager im = ItemManager.instance;
	private static UserManager um = UserManager.instance;
	public static ShopManager instance = new ShopManager();
	
	private ShopManager() {}
	
	public void run() {
		
		um.setAdmin();
		System.out.println(Shop.getName());
		boolean isRun = true;
		while(isRun) {
			printMainMenu();		
			isRun = selectMenu();
		}
	}
	private void printMainMenu() {
		String input = Shop.scan.next();
		if(Shop.log == -1) {
			System.out.println("1.회원가입\n2.로그인\n3.종료");
		}
		else {
			System.out.printf("현재 %d님이 로그인중\n", Shop.log);
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
					Shop.log = um.login();
				}
				else if(sel == 3) {
					System.out.println("종료합니다.");
					return false;
				}
			}
			else {
				if(sel == 1) {
					shopMenu();
				}
				else if(sel == 2) {
					cartMenu();
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
			e.printStackTrace();
		}
		return true;
		
	}
	private void cartMenu() {
		String input = Shop.scan.next();
		System.out.println("1.내 장바구니\n2.삭제\n3.구입\n0.뒤로가기");
		int sel = Integer.parseInt(input);
		if(sel == 1) {
			
		}
		else if(sel == 2) {
			
		}
		else if(sel == 3) {
			
		}
		else if(sel == 0) {
			printMainMenu();
		}
	}
	private void shopMenu() {
		String input = Shop.scan.next();
		im.printCategory();
		System.out.println("카테고리 번호를 입력하세요. \n-1.종료하기");
		int cateId = Integer.parseInt(input);
		if(cateId == -1) {
			printMainMenu();
		}
		System.out.println("아이템 번호를 입력하세요.");
		im.printItemList();
		int itemId = Integer.parseInt(input);
		
	}
}
