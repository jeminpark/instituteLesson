package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import util.DBManager;

public class UserDAO_mine {
	
	//1싱글톤 패턴만들기(다른곳에서 new를 할수없게)
	private UserDAO_mine() {}
	private static UserDAO_mine instance = new UserDAO_mine();
	public static UserDAO_mine getInstance() {
		return instance;
	}
	
	//2 데이터베이스 연동준비 전역변수, 멤버생성
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<UserDTO_mine> users = null;
	
	//3 데이터베이스 연동
	
//	public Connection getConnection() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			String url = "jdbc:mysql://localhost:3306/loginServer?serverTimezone=UTC";
//			String user = "root";
//			String password = "beCmingth3l3";
//			
//			conn = DriverManager.getConnection(url, user, password);
//			
//			if(conn != null) {
//				System.out.println("DB 연동 성공");
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	//4 연동된 DB에서 데이터 불러오기
	
	public ArrayList<UserDTO_mine> getUsers(){
		users = new ArrayList<UserDTO_mine>();
		
		try {
			conn = DBManager.getConnection(); //데이터베이스 연동
			String sql = "select* from users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {			//next() boolean 타입 첫번째 row를 읽고 값이 있으면 true 없으면 false
				int code = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				String birth = rs.getString(5);
				String gender = rs.getString(6);
				String email = rs.getString(7);
				String mobile = rs.getString(8);
				Timestamp regDate = rs.getTimestamp(9);
				
				UserDTO_mine user = new UserDTO_mine(code, id, pw, name, birth, gender, email, mobile, regDate);
				users.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	//5.CRUD 
	
	// Create
	
	public boolean addUser(UserDTO_mine user) {
		
		if(checkDuplId(user.getId())) {
			
			try {
				conn = DBManager.getConnection();
				String sql = "insert into users(id, pw, name, birth, gender, email, mobile, regDate) values (?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getBirth());
				pstmt.setString(5, user.getGender());
				pstmt.setString(6, user.getEmail());
				pstmt.setString(7, user.getMobile());
				pstmt.setTimestamp(8, new Timestamp(Calendar.getInstance().getTimeInMillis()));
				
				pstmt.executeUpdate(); //결과를 따로반환할 필요가없다.
				
				System.out.println("회원가입 성공");
				
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean checkDuplId(String id) {
		
		users = getUsers();
		
		for(UserDTO_mine user : users) {
			if(id.equals(user.getId())) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean login(String id, String pw) {
		
		users = getUsers();
		
		for(UserDTO_mine user : users) {
			if(id.equals(user.getId()) && pw.equals(user.getPw()) ) {
				return true;
			}
		}
		return false;
	}
	
	
	

}
