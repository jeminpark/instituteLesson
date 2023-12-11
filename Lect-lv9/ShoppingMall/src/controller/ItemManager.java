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
		Item temp = new Item("��Ϲ���Ĩ", 0, 0, "����", 1500);
		this.items.add(temp);
		temp = new Item("�ҷθ�����", 1, 0, "����", 1000);
		this.items.add(temp);
		temp = new Item("����", 2, 0, "����", 1200);
		this.items.add(temp);
		temp = new Item("����", 0, 1, "����", 7000);
		this.items.add(temp);
		temp = new Item("�������", 1, 1, "����", 5000);
		this.items.add(temp);
		temp = new Item("����", 3, 0, "����", 1300);
		this.items.add(temp);
		temp = new Item("����", 2, 1, "����", 7400);
		this.items.add(temp);
		temp = new Item("�丶��", 0, 2, "ä��", 2300);
		this.items.add(temp);
		temp = new Item("����", 1, 2, "ä��", 1800);
		this.items.add(temp);
		temp = new Item("�ݶ�", 0, 3, "�ݶ�", 1000);
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
