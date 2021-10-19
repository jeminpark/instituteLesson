package controller;

import java.util.ArrayList;

import models.Cart;
import models.Shop;
import models.User;

public class CartManager {

	private CategoryManager cm = CategoryManager.instance;
	private ItemManager im = ItemManager.instance;
	private UserManager um = UserManager.instance;
	public static CartManager instance = new CartManager();
	private ArrayList<Cart> jangList = new ArrayList<>();
	
	private CartManager() {};
	
	
	
	public void printCart() {
		int total = 0;
		int n = 1;
		
		String userId = um.getUser(Shop.log).getId();
		for(int i=0; i<this.jangList.size(); i++) {
			if(this.jangList.get(i).getUserId().equals(userId)) {
				System.out.print(n+")");
				System.out.print(this.jangList.get(i)+"\n");
				total += getCart(i).getPrice();
				n++;
			}
		}
		System.out.println("합: "+total);
		System.out.println();
	}
//	public void addCart(String userId, int cateId, int itemId) {
//		int n = 1;	
//		Cart temp;
//		for(int i=0; i<im.getItemsSize(); i++) {			
//				
//				if(cm.get(cateId).getCateName().equals(im.getItem(i).getCategory())) {
//					if(itemId == n) {
//						temp = new Cart(userId, im.getItem(itemId).getName(), im.getItem(itemId).getPrice());
//						this.jangList.add(temp);
//						System.out.println("장바구니 담기 완료");
//						
//					}
//					n++;
//				}
//			
//		}
//		
//	}
	public void addCart(String userId, int cateIdx, int itemIdx) {
			
		
		if(cm.get(cateIdx).getCateName().equals(im.getItem(itemIdx).getCateName())) {
			Cart temp = new Cart(userId, im.getItem(itemIdx).getName(), im.getItem(itemIdx).getPrice());
			this.jangList.add(temp);
			System.out.println(temp+"담기 완료");
		}
		
	}
	
//	public void removeCart(int log) {
//		printCart(Shop.log);
//		System.out.printf("삭제할 아이템을 고르세요. 0~%d", this.jangList.size()-1);
//		String input = Shop.scan.next();
//		int sel = Integer.parseInt(input);	
//				
//		if(sel >= 0 && sel < this.jangList.size()) {		
//				
//			if(um.getUser(log).getId().equals(this.getCart(sel).getUserId())) {
//				this.jangList.remove(this.getCart(sel));
//				
//			}	
//			
//			System.out.println("아이템 삭제 완료");		
//		}
//		else {
//			System.out.println("잘못누르셨습니다.");
//		}
//		
//	}
	public void removeCart() {
		printCart();
		System.out.print("삭제할 아이템번호: ");
		String input = Shop.scan.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Cart temp = this.jangList.get(index);
			this.jangList.remove(temp);
			System.out.println("아이템 삭제 완료");
		}
		else {
			System.out.println("번호를 다시 입력하세요.");
		}
	}
	public int findIndex(String input) {
		int index = -1;
		
		try {
			String userId = um.getUser(Shop.log).getId();
			int cnt = um.getUser(Shop.log).getMyItemCnt();
			int num = Integer.parseInt(input)-1;
			
			
			if(num >= 0 && num < cnt) {
				int tempCnt = 0;
				for(int i=0; i<this.jangList.size(); i++) {
					if(this.jangList.get(i).getUserId().equals(userId)) {
						index = i;
						if(tempCnt == num) {
							break;
						}
						tempCnt ++;
					}
				}
			}
		}
		catch(Exception e) {
			
		}
		return index;
		
	}
	
	public void goPay() {
		printCart();
		System.out.printf("구매확정할 아이템을 고르세요.", this.jangList.size()-1);
		String input = Shop.scan.next();
		int sel = Integer.parseInt(input);
		
		if(sel >= 0 && sel < this.jangList.size()) {
			if(um.getUser(Shop.log).getId().equals(this.getCart(sel).getUserId())) {
				
			}
		}
		
		
	}
	
	public Cart getCart(int index) {
		return this.jangList.get(index);
	}
	public int getCartsSize() {
		return this.jangList.size();
	}

	
}
