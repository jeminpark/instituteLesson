package controller;

public class Account {
	private static int MAX = 3;
	
	private int accCode;
	private int userCode;
	private String userName;
	private int money;
	
	public Account(int accCode, int userCode, String userName) {
		this.accCode = accCode;
		this.userCode = userCode;
		this.userName = userName;
		
	}
	public Account(int accCode, int userCode, String userName, int money) {
		this.accCode = accCode;
		this.userCode = userCode;
		this.userName = userName;
		this.money = money;
	}
	public int getAccCode() {
		return this.accCode;
	}
	public int getUserCode() {
		return this.userCode;
	}
	public String getUserName() {
		return this.userName;
	}
	public int getMoney() {
		return this.money+5000;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		
		return this.accCode+"/"+this.userCode+"/"+this.userName+"/"+this.money;
	}
	
}
