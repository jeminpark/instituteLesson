package models;

public class Account {
	
	public static int Max = 3;
	
	private int accNum;
	private int userCode;
	private int money;
	
	public Account(int accNum, int userCode) {
		this.accNum = accNum;
		this.userCode = userCode;
		this.money = 5000;
	}
	public Account(int accNum, int userCode, int money) {
		this.accNum = accNum;
		this.userCode = userCode;
		this.money = money;
	}
	
	public int getAccNum() {
		return this.accNum;
	}
	public int getUserCode() {
		return this.userCode;
		
	}
	public int getMoney() {
		return this.money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String toString() {
		return this.accNum +"("+this.userCode+") : "
		+this.money+" ¿ø";
	};
}
