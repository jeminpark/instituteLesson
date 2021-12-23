package user;

import java.sql.Timestamp;

public class User_DTO {

	private int code;
	private String id, pw, name, birth, gender, email, mobile;
	
	private Timestamp regDate;
	
	public User_DTO(String id, String pw, String name, String birth, String gender, String email, String mobile) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
	}
	
	

	public User_DTO(int code, String id, String pw, String name, String birth, String gender, String email, String mobile, Timestamp regDate) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
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
	
	public String getName() {
		return name;
	}	

	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getGender() {
		return gender;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		
		return String.format("%d) %s %s %s %s %s %s %s (%s)", this.code, this.id, this.pw, this.name, this.birth, this.gender, this.email, this.mobile, this.regDate);
	}


	
	
}
