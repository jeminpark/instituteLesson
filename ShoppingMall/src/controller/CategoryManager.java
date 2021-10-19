package controller;

import java.util.ArrayList;

import models.Categorys;

public class CategoryManager {

	public static CategoryManager instance = new CategoryManager();
	private ArrayList<Categorys> cate = new ArrayList<>();
	
	private CategoryManager() {
		setCategory();
	}
	
	public void setCategory() {
		Categorys temp = new Categorys("과자", 0);
		this.cate.add(temp);
		temp = new Categorys("육류", 1);
		this.cate.add(temp);
		temp = new Categorys("채소", 2);
		this.cate.add(temp);
		temp = new Categorys("음료수", 3);
		this.cate.add(temp);
	}
	
	public void printCategory() {
		for(int i=0; i<this.cate.size(); i++) {
			System.out.print(i+1+")");
			System.out.print(this.cate.get(i)+"\n");
		}
		System.out.println();
		
	}
	public Categorys getCate(int index) {
		return this.cate.get(index);
	}
	public int getCategorySize() {
		return this.cate.size();
	}
}
