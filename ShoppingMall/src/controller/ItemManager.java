package controller;

import java.util.ArrayList;

import models.Item;

public class ItemManager {

	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> items = new ArrayList<>();
	private ItemManager() {
		setItems();
	}
	
	public void setItems() {
		Item temp = new Item("허니버터칩", 0, 0, "과자", 1500);
		this.items.add(temp);
		temp = new Item("쌀로만강정", 1, 0, "과자", 1000);
		this.items.add(temp);
		temp = new Item("고래밥", 2, 0, "과자", 1200);
		this.items.add(temp);
		temp = new Item("쇠고기", 0, 1, "육류", 7000);
		this.items.add(temp);
		temp = new Item("돼지고기", 1, 1, "육류", 5000);
		this.items.add(temp);
		temp = new Item("나쵸", 3, 0, "과자", 1300);
		this.items.add(temp);
		temp = new Item("양고기", 2, 1, "육류", 7400);
		this.items.add(temp);
		temp = new Item("토마토", 0, 2, "채소", 2300);
		this.items.add(temp);
		temp = new Item("양파", 1, 2, "채소", 1800);
		this.items.add(temp);
		temp = new Item("콜라", 0, 3, "콜라", 1000);
		this.items.add(temp);		
	}
	public void printItemsList(int cateidx) {
		int n = 1;
		for(int i=0; i<this.items.size(); i++) {
			if(this.items.get(i).getCateCode() == cateidx) {
				System.out.print(n+")");
				System.out.print(this.items.get(i)+"\n");
				n++;
			}
			
		}
	}
	public Item getItem(int index) {
		return this.items.get(index);
	}
	public int getItemsSize() {
		return this.items.size();
	}
	public void printItem() {
		for(int i=0; i<this.items.size(); i++) {
			System.out.print(i+1+") ");
			System.out.print(this.items.get(i)+"\n");
		}
	}
}
