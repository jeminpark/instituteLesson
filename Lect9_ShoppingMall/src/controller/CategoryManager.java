package controller;

import java.util.ArrayList;


import models.Categorys;

public class CategoryManager {

	
	public static CategoryManager instance = new CategoryManager();
	private ArrayList<Categorys> category = new ArrayList<>(); 
	
	private CategoryManager() {
		setCategory();
	}
	
	public void setCategory() {
		Categorys temp = new Categorys("과자", categoryIndex());
		this.category.add(temp);
		temp = new Categorys("육류", categoryIndex());
		this.category.add(temp);
		temp = new Categorys("채소", categoryIndex());
		this.category.add(temp);
		temp = new Categorys("음료수", categoryIndex());
		this.category.add(temp);
	}
	public int categoryIndex() {
		return this.category.size();
	}
	public void addCategory() {
		
	}
	public void printCategory() {
		int n = 1;
		for(int i=0; i<this.category.size(); i++) {
			System.out.print(n+") ");
			System.out.print(this.category.get(i)+"\n");
			n++;
		}
		System.out.println();
	}
	public Categorys get(int index) {
		return this.category.get(index);
	}
	
}
