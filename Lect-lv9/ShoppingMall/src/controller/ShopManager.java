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
			System.out.println("1.�α���\n2.ȸ������\n3.����");
			
		}
		else {
			System.out.println("1.����\n2.��ٱ���\n3.�α׾ƿ�\n4.ȸ��Ż��");
		}
		if(Shop.log == 0) {
			System.out.println("5.�����ڸ��");
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
				System.out.println("�����մϴ�.");
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
			System.out.println("1.��ü������ȸ\n2.��ü��������ȸ\n3.��üī�װ���ȸ\n4.��ü��ٱ�����ȸ\n5.�������ȸ\n0.�ڷΰ���");
			if(sel == 1) {
				um.printUser();
			}
			else if(sel == 2) {
				im.printItem();
			}
			else if(sel == 3) {
				cm.printCategory();
			}
			else if(sel == 4) {
				ctm.printAllCart();
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
		System.out.print("ī�װ� ��ȣ �Է�: (0.�����ϱ�)");
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
				System.out.println("�ٽü������ּ���.");
			}
			else {
				buyItem(check);				
			}
		}
	}
	private void buyItem(int cateIndex) {
		im.printItemsList(cateIndex);
		System.out.println("������ ��ȣ �Է�: (0.�ڷΰ���");
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
				System.out.println("�ٽ� �������ּ���.");
			}
			else {
				String userId = um.getUser(Shop.log).getId();					//��ٱ��Ͽ� ����ڸ������Ҽ��ִ� �����ڵ�� �̸� 
				int userCode = um.getUser(Shop.log).getUserCode();
				String itemName = im.getItem(check).getName();					//�׸��� ����ڰ� �� �������̸��� ������ �ְ�ʹ�.
				int itemPrice = im.getItem(check).getPrice();
				
				ctm.addCart(userId, userCode, itemName, itemPrice );
			}
		}
		
	}
	private void cartMenu() {
		ctm.printCart();
		System.out.println("1.����\n2.����\n3.�ڷΰ���");
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
