package models;

public class Cart {
	private String userId;
	private String itemName;
	private int price;

	
	public Cart(String userId, String itemName, int price) {
		this.userId = userId;
		this.itemName = itemName;
		this.price = price;
		
	}
	
	public String getUserId() {
		return this.userId;
	}
	public String getItemName() {
		return this.itemName;
	}
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		
		return this.userId+"/"+this.itemName+"/"+this.price+"/";
	}
		
	
}
