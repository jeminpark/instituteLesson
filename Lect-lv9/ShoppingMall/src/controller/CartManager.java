package controller;

import java.util.ArrayList;

import models.Cart;
import models.Shop;

public class CartManager {

	private ReceiptManager rm = ReceiptManager.instance;
	private ItemManager im = ItemManager.instance;
	private UserManager um = UserManager.instance;
	public static CartManager instance = new CartManager();
	private ArrayList<Cart> cartList = new ArrayList<>();
	
	private CartManager() {}
	
	public void printCart() {
		int userCode = um.getUser(Shop.log).getUserCode();
		
		int n = 1;
		int total = 0;
		for(int i=0; i<this.cartList.size(); i++) {
			if(userCode == this.cartList.get(i).getCartUserCode()) {
				System.out.print(n+") ");
				System.out.print(this.cartList.get(i)+"\n");
				n++;
				total += this.cartList.get(i).getCartItemPrice();
			}
			
		}
		System.out.println("합계: "+ total+" 원");
	}
	public void addCart(String userId, int userCode, String cartItemName, int cartItemPrice) {
		
		int cnt = um.getUser(Shop.log).getItemCnt();
	
		Cart cart = new Cart(userId, userCode, cartItemName, cartItemPrice);
		this.cartList.add(cart);
		um.getUser(Shop.log).setItemCnt(++cnt);
		System.out.println(cart+"담기 완료");
		
	}
	
	public void removeCart() {
		System.out.print("삭제할 아이템번호 입력: ");
		String input = Shop.scan.next();
		
		int index = findIndex(input);
		
		int cnt = um.getUser(Shop.log).getItemCnt();
		if(index != -1) {
			Cart temp = this.cartList.get(index);
			this.cartList.remove(temp);
			
			um.getUser(Shop.log).setItemCnt(--cnt);
			
		}
	}
	public int findIndex(String input) {
		int index = -1;
		
		try {
		
			int userCode = um.getUser(Shop.log).getUserCode();
			int cnt = um.getUser(Shop.log).getItemCnt();
			int num = Integer.parseInt(input)-1;
			
			if(num >= 0 && num < cnt) {
				int tempCnt = 0;
				for(int i=0; i<this.cartList.size(); i++) {
					if(userCode == this.cartList.get(i).getCartUserCode()) {
						index = i;
						if(tempCnt == num) {
							break;
						}
						tempCnt++;
					}
				}
				
			}
		}
		catch(Exception e) {
			
		}
		return index;
		
	}
	public void purchase() {
		printCart();
		
		int userCode = um.getUser(Shop.log).getUserCode();
		int total = 0;
		
		String ItemName = "";
		String userId = um.getUser(Shop.log).getId();
		int purchaseCnt = 0;
		
		
		int check = -1;
		for(int i=0; i<this.cartList.size(); i++) {
			if(userCode == this.cartList.get(i).getCartUserCode()) {
				total += this.cartList.get(i).getCartItemPrice();
				check = i;
				ItemName = this.
				purchaseCnt++;
			}
		}
		
		System.out.println("총 지불할금액: "+total+" 원");
		System.out.print("금액입력: ");
		int money = Shop.scan.nextInt();
		
		if(money > 0 && money >= total) {
			
			
			rm.payComplete(userId, userCode, );
		}
		
	}
	public void printAllCart() {
		for(int i=0; i<this.cartList.size(); i++) {
			System.out.print(i+1+") ");
			System.out.print(this.cartList.get(i)+"\n");
		}
	}
	
}
