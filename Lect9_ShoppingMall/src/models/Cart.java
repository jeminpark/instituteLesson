package models;

public class Cart {
	private String userId;
	private String itemName;
	private int itemCnt;
	
	public Cart(String userId, String itemName, int itemCnt) {
		this.userId = userId;
		this.itemName = itemName;
		this.itemCnt = itemCnt;
		
	}
	
	public String getUserId() {
		return this.userId;
	}
	public String getItemName() {
		return this.itemName;
	}
	public int getItemCnt() {
		return this.itemCnt;
	}
	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}
		
	public void print() {
		System.out.println(this.userId+"/"+this.itemCnt+"/"+this.itemName);
	}
}
