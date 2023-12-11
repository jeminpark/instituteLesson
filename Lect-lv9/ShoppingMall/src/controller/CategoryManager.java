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
		Categorys temp = new Categorys("����", 0);
		this.cate.add(temp);
		temp = new Categorys("����", 1);
		this.cate.add(temp);
		temp = new Categorys("ä��", 2);
		this.cate.add(temp);
		temp = new Categorys("�����", 3);
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
