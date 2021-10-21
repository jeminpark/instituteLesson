package controller;

import models.Shop;

public class ShopManager {

	private CartManager ctm = CartManager.instance;
	private ItemManager im = ItemManager.instance;
	private CategoryManager cm = CategoryManager.instance;
	private UserManager um = UserManager.instance;
	public static ShopManager instance = new ShopManager();
	private ShopManager() {}
	
	public void run() {
		System.out.println(Shop.getName());
		
		boolean isRun = true;
		while(isRun) {
			printMainMenu();
			isRun = selectMenu();
		}
	}
	public void printMainMenu() {
		if(Shop.log == -1) {
			System.out.println("1.로그인\n2.회원가입\n3.종료");
			
		}
		else {
			System.out.println("1.쇼핑\n2.장바구니\n3.로그아웃\n4.회원탈퇴");
		}
		if(Shop.log == 0) {
			System.out.println("5.관리자모드");
		}
	}
	public boolean selectMenu() {
		int sel = Shop.scan.nextInt();
		
		if(Shop.log == -1) {
			
			if(sel == 1) {
				Shop.log = um.login();
			}
			else if(sel == 2) {
				um.addUser();
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
				Shop.log = -1;
			}
			else if(sel == 4) {
				um.deleteUser();
			}
		}
		if(Shop.log == 0 && sel == 5) {
			System.out.println("1.전체유저조회\n2.전체아이템조회\n3.전체카테고리조회\n4.전체장바구니조회\n5.매출액조회\n0.뒤로가기");
			if(sel == 1) {
				
			}
			else if(sel == 2) {
				
			}
			else if(sel == 3) {
				
			}
			else if(sel == 4) {
				
			}
			else if(sel == 5) {
				
			}
			else if(sel == 0) {
				printMainMenu();
			}
		}
		return true;
	}
	private void shopMenu() {
		cm.printCategory();
		System.out.print("카테고리 번호 입력: (0.종료하기)");
		int cateNum = Shop.scan.nextInt()-1;
		if(cateNum == -1) {
			printMainMenu();
		}
		else {
			int check = -1;
			for(int i=0; i<cm.getCategorySize(); i++) {
				if(cateNum == cm.getCate(i).getCateNum()) {
					check = i;
					
				}				
			}
			if(check == -1) {
				System.out.println("다시선택해주세요.");
			}
			else {
				buyItem(check);				
			}
		}
	}
	private void buyItem(int cateIndex) {
		im.printItemsList(cateIndex);
		System.out.println("아이템 번호 입력: (0.뒤로가기");
		int itemIndex = Shop.scan.nextInt()-1;
		if(itemIndex == -1) {
			shopMenu();
		}
		else {
			int check = -1;
			for(int i=0; i<im.getItemsSize(); i++) {
				if(cateIndex == im.getItem(i).getCateCode()) {
					if(itemIndex == im.getItem(i).getItemNum()) {
						check = i;
					}
				}
			}
			if(check == -1) {
				System.out.println("다시 선택해주세요.");
			}
			else {
				String userId = um.getUser(Shop.log).getId();					//장바구니에 사용자를검증할수있는 유저코드와 이름 
				int userCode = um.getUser(Shop.log).getUserCode();
				String itemName = im.getItem(check).getName();					//그리고 사용자가 고른 아이템이름과 가격을 넣고싶다.
				int itemPrice = im.getItem(check).getPrice();
				
				ctm.addCart(userId, userCode, itemName, itemPrice );
			}
		}
		
	}
	private void cartMenu() {
		ctm.printCart();
		System.out.println("1.구입\n2.삭제\n3.뒤로가기");
		selectCart();
	}
	private void selectCart() {
		int sel = Shop.scan.nextInt();
		if(sel == 1) {
			
		}
		else if(sel == 2) {
			ctm.removeCart();
		}
		else if(sel == 3) {
			printMainMenu();
		}
	}
}
