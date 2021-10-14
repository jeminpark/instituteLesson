package controller;

import java.util.ArrayList;

import models.Cart;
import models.Shop;
import models.User;

public class CartManager {

	private static CategoryManager cm = CategoryManager.instance;
	private static ItemManager im = ItemManager.instance;
	private static UserManager um = UserManager.instance;
	public static CartManager instance = new CartManager();
	private ArrayList<Cart> jangList = new ArrayList<>();
	
	private CartManager() {};
	
	
	public void printCart(int log) {
		for(Cart cart : this.jangList) {
			if(um.getUser(log).getId().equals(cart.getUserId())) {
				cart.print();
			}
		}
	}
	public void addCart(String userId, int cateId, int itemId) {
		int n = 0;
		int cnt = this.jangList.size();
		Cart temp;
		for(int i=0; i<im.getItemsSize(); i++) {
			if(cm.get(cateId).getCateName().equals(im.getItem(i).getCategory())) {
				if(itemId == n) {
					temp = new Cart(userId, im.getItem(i).getName(), cnt);
					this.jangList.add(temp);
					System.out.println("장바구니 담기 완료");
					
				}
				n++;
			}
		}
		System.out.println("cnt"+cnt);
	}
	public void removeCart(int log) {
		printCart(Shop.log);
		System.out.printf("삭제할 아이템을 고르세요. 0~%d", this.jangList.size()-1);
		String input = Shop.scan.next();
		int sel = Integer.parseInt(input);
		
		
		int cnt = this.jangList.size();
		if(sel >= 0 && sel < this.jangList.size()) {
			
			for(int i=0; i<this.jangList.size(); i++) {
//				if(sel) {
//					
//				}
			}
		
			
			System.out.println("아이템 삭제 완료");
			
			
		}
		else {
			System.out.println("잘못누르셨습니다.");
		}
		
	}
	
	public Cart getCart(int index) {
		return this.jangList.get(index);
	}

	
}
