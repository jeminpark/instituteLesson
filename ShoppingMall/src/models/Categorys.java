package models;

public class Categorys {

	private String cateName;
	private String userId;		//카테고리에 유저를 식별할 장치가 필요한가??
	private int userCode;
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
	@Override
	public String toString() {
		
		return this.cateName+"/"+this.cateNum;
	}
}
