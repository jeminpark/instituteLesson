package controller;

import java.util.ArrayList;

import models.Item;

public class ItemManager {
	
	public static ItemManager instance = new ItemManager();
	
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<String>category = new ArrayList<>();
	private ItemManager() {}
	
	
	public void run() {
		
		boolean isRun = true;
		while(isRun) {
			printMenu();
			isRun = selectMenu();
		}
	}
	public void setItem() {
		
		
	}
	
	public void printMenu() {
		
	}
	public boolean selectMenu() {
		
		
		return true;
	}
}
