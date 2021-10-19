package models;

public class PayItem {
	private String itemName;
	private int price;
 
	public PayItem(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	public int getPrice() {
		return this.price;
	}
	public void print() {
		System.out.println(this.itemName+"/"+this.price+" 원\n");
	}
	
 
}
