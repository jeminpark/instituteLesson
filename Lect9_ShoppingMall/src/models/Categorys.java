package models;

public class Categorys {
	private String cateName;
	private int cateNum;
	
	public Categorys(String cateName, int cateNum) {
		this.cateName = cateName;
		this.cateNum = cateNum;
	}
	public String getCateName() {
		return this.cateName;
	}
	public int getCateNum() {
		return this.cateNum;
	}
	
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public void setCateName(int cateNum) {
		this.cateNum = cateNum;
	}
	@Override
	public String toString() {
		return this.cateNum+")"+this.cateName;
	}
	
	
}
