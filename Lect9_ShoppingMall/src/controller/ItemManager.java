package controller;

import java.util.ArrayList;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<String> category = new ArrayList<>();
	private ArrayList<Cart> jangList = new ArrayList<>();
	
	private ItemManager() {
		setItem();
	}
	
	//카테고리
	public void setItem() {
		this.category.add("과자");
		this.category.add("생선");
		this.category.add("육류");
		this.category.add("음료수");
		Item temp = new Item("새우깡",1000, this.category.get(0));
		this.items.add(temp);
		temp = new Item("고등어",2000, this.category.get(1));
		this.items.add(temp);
		temp = new Item("칸쵸",3600, this.category.get(0));
		this.items.add(temp);
		temp = new Item("소고기",6500,this.category.get(2));
		this.items.add(temp);
		temp = new Item("콜라", 1500, this.category.get(3));
		this.items.add(temp);
		temp = new Item("새우", 1800, this.category.get(1));
		this.items.add(temp);
		
	}
	public void printJang(User u) {
		for(int i=0; i<this.jangList.size(); i++) {
			if(u.getId().equals(jangList.get(i).getUserId())){
				this.jangList.get(i).print();
			}
		}
	}
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println(i+1+") "+category.get(i));
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
