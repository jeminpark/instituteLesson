package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	
	private static CategoryManager cm = CategoryManager.instance;
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> items = new ArrayList<>();
		
	private ItemManager() {		
		setItem();
	}
	
	//카테고리
	public void setItem() {
		Item temp = new Item("허니버터칩", 1500, cm.get(0).getCateName());
		this.items.add(temp);
		temp = new Item("쌀로만", 1200, cm.get(0).getCateName());
		this.items.add(temp);
		temp = new Item("쇠고기", 5900, cm.get(1).getCateName());
		this.items.add(temp);
		temp = new Item("돼지고기", 4800, cm.get(1).getCateName());
		this.items.add(temp);
		temp = new Item("양파", 2000, cm.get(2).getCateName());
		this.items.add(temp);
		temp = new Item("콜라", 1000, cm.get(3).getCateName());
		this.items.add(temp);
		temp = new Item("토마토", 1500, cm.get(2).getCateName());
		this.items.add(temp);
		
	}	
	
	public void printItemList(int cateId) {
		int n = 1;
		for(int i=0; i<this.items.size(); i++) {
			if(cm.get(cateId).getCateName().equals(this.items.get(i).getCateName())){
				System.out.print(n+") ");
				System.out.print(this.items.get(i)+"\n");				
				n++;
			}
		}
		System.out.println();
	}
	public Item getItem(int index) {
		return this.items.get(index);
	}
	public int getItemsSize() {
		return this.items.size();
	}
	
	public void printItemsAllData() {
		for(int i=0; i<this.items.size(); i++) {
			System.out.print(i+1+")");
			System.out.print(this.items.get(i)+"\n");
		}
	}
	
	
	
}
