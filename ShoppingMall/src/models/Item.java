package models;

public class Item {

	private String itemName;
	private int itemNum;
	private int cateCode;
	private String cateName;
	private int price;
	
	public Item(String itemName, int itemNum, int cateCode, String cateName, int price) {
		this.itemName = itemName;
		this.itemNum = itemNum;
		this.cateCode = cateCode;
		this.cateName = cateName;
		this.price = price;
	}
	public String getName() {
		return this.itemName;
	}
	public int getItemNum() {
		return this.itemNum;
	}
	public int getPrice() {
		return this.price;
	}
	public int getCateCode() {
		return this.cateCode;
	}
	public String getCateName() {
		return this.cateName;
	}
	@Override
	public String toString() {
		
		return this.itemName+"/"+this.cateName+"/"+this.cateCode+"/"+this.itemNum+"/"+this.price+" ¿ø";
	}
}
