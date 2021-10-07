package models;

public class User {

	private int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	
	// 보유계좌의 객체주소 배열
	
	private int[] Account;
	
	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public int getUserCode() {
		return this.userCode;
	}	
	public int[] getAccount() {
		this.Account = new int[this.accCnt];
		return this.Account;
	}
	public void setAccount(int[] Account) {
		this.Account = Account;
	}
	@Override
	public String toString() {
		String str = "";
		str += this.userCode+""+"/";
		str += this.id+"/";
		str += this.name;
		return str;
	}
	
}
