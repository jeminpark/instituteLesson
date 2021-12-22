package user;

import java.sql.Timestamp;

public class User_DTO {

	private int code;
	private String id, pw;
	private Timestamp regDate;
	
	public User_DTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public User_DTO(int code, String id, String pw, Timestamp regDate) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.regDate = regDate;
	}

	public int getCode() {
		return code;
	}
	

	public String getId() {
		return id;
	}
	

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	@Override
	public String toString() {
		
		return String.format("%d) %s %s(%s)", this.code, this.id, this.pw, this.regDate);
	}


	
	
}
