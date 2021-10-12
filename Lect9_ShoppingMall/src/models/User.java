package models;

public class User {

	private int userCode;
	private String id;
	private String pw;
	private String name;
	
	
	public User (int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public int getUserCode() {
		return this.userCode;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		
		return this.userCode+ ") "+this.id+"/"+this.pw+"/"+this.name;
	}
}
