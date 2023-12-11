package user;

import java.sql.Timestamp;

public class UserDTO_mine {

	private int code;
	private String id, pw, name, birth, gender, email, mobile;
	private Timestamp regDate;
	
	public UserDTO_mine(String id, String pw, String name, String birth, String gender, String email, String mobile) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
	}
	
	public UserDTO_mine(int code, String id, String pw, String name, String birth, String gender, String email, String mobile, Timestamp regDate) {
		
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

	public void setCode(int code) {
		this.code = code;
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
		// TODO Auto-generated method stub
		return String.format("%d) %s/%s %s %s %s %s %s (%s)", this.code, this.id, this.pw, this.name, this.birth, this.gender, this.email, this.mobile, this.regDate);
	}
	
	
}
