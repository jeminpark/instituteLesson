package controller;

import java.util.ArrayList;

import models.Receipt;
import models.Shop;

public class ReceiptManager {

	private UserManager um = UserManager.instance;
	public static ReceiptManager instance = new ReceiptManager();
	
	private ArrayList<Receipt> receipt = new ArrayList<>();
	
	private ReceiptManager() {}
	
	public void printAllRecipt() {
		for(int i=0; i<this.receipt.size(); i++) {
			System.out.print(this.receipt.get(i));
		}
	}
	public void printReceipt() {
		int userCode = um.getUser(Shop.log).getUserCode();
		
		int total = 0;
		int n = 1;
		System.out.println("-------- 영 수 증 ---------");
		for(int i=0; i<this.receipt.size(); i++) {
			if(userCode == this.receipt.get(i).getReceiptUserCode()) {
				System.out.println(n+") ");
				System.out.print(this.receipt.get(i).getReceiptItemName()+"/");
				System.out.print(this.receipt.get(i).getReceiptItemPrice()+" 원");
				total += this.receipt.get(i).getReceiptItemPrice();
			}
		}
		System.out.println(total + " 원");
	}
	public void payComplete(String userId, int userCode, String ItemName, int ItemPrice, int total, int itemCnt) {
		
		Receipt paid = new Receipt(userId, userCode, ItemName, ItemPrice, total);
		this.receipt.add(paid);
		
		for(Receipt rec : this.receipt) {
			rec.setReceiptItemCnt(itemCnt);
		}
		System.out.println("구매완료");
		printReceipt();
	}
	public Receipt getReceipt(int index) {
		return this.receipt.get(index);
	}
}
