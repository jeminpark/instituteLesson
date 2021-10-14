package models;

public class Cart {
	private String userId;
	private String itemName;
	
	public Cart(String userId, String itemName) {
		this.userId = userId;
		this.itemName = itemName;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public String getItemName() {
		return this.itemName;
	}
		
	public void print() {
		System.out.println(this.userId+"/"+"아이템: "+itemName);
	}
}
