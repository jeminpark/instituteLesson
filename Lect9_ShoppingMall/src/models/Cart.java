package models;

public class Cart {
	private String userId;
	private String itemName;
	
	
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
