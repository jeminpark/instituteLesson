package model;

public class OrderList {

	private String name;
	
	private int price;
	
	private int cnt;
	
	public OrderList(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return this.cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+"/"+this.price+"/"+this.cnt;
	}
}
