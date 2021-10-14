package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	
	private static CategoryManager cm = CategoryManager.instance;
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> items = new ArrayList<>();
	
	private ArrayList<Cart> jangList = new ArrayList<>();
	
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
		
	}
	public void printJang(User u) {
		for(int i=0; i<this.jangList.size(); i++) {
			if(u.getId().equals(jangList.get(i).getUserId())){
				this.jangList.get(i).print();
			}
		}
	}
	
	public void printItemList() {
		for(int i=0; i<this.items.size(); i++) {
			System.out.print(i+1+") ");
			this.items.get(i).getName();
		}
	}
	public void printItemList(int cartId) {
		
	}
	
	
	
	
}
