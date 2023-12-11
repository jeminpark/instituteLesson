package user;

public class UserDto {
	
	private int code;
	private String id, pw, name;

	public UserDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
		
	}
	public UserDto(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	//ResultSet 생성자
	public UserDto(int code, String id, String pw, String name) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d) %s %s %s", this.code, this.id, this.pw, this.name);
	}
	
	
}
