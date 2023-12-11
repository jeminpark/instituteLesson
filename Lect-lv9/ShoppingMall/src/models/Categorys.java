package models;

public class Categorys {

	private String cateName;
	private String userId;		//ī�װ��� ������ �ĺ��� ��ġ�� �ʿ��Ѱ�??
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
