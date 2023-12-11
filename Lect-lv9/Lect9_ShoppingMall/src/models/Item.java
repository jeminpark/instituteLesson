package models;

public class Item {
	
	private String name;
	private int price;
	private String cateName;
	
	public Item(String name, int price, String cateName) {
		this.name = name;
		this.price = price;
		this.cateName = cateName;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String getCateName() {
		return this.cateName;
	}
	@Override
	public String toString() {
		
		return this.name+"/"+this.price+"/"+this.cateName+"\n";
	}
}
