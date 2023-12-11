package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class User_DAO {

	private User_DAO() {}
	private static User_DAO instance = new User_DAO();
	public static User_DAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<User_DTO> users = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/loginServer?serverTimezone=UTC";
			String user = "root";
			String password = "beCmingth3l3";
			
			conn = DriverManager.getConnection(url,user,password);
			
			if(conn != null) {
				
				System.out.println("DB 연동 성공");
			}
			else {
				System.out.println("연동 실패");
			}
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public ArrayList<User_DTO> getUsers(){
		users = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "select* from users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				String birth = rs.getString(5);
				String gender = rs.getString(6);
				String email = rs.getString(7);
				String mobile = rs.getString(8);
				Timestamp regDate = rs.getTimestamp(9);
				
				User_DTO user = new User_DTO(code, id, pw,name, birth, gender, email, mobile, regDate);
				users.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void addUser(User_DTO user) {
		
		
		if(checkDuplId(user.getId())) {
			
			try {
				conn = getConnection();
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
				
				pstmt.executeUpdate();
				
				System.out.println("회원가입 성공");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	public boolean checkDuplId(String id) {
		
		users = getUsers();
		
		for(User_DTO user : users) {
			if(id.equals(user.getId())) {
				return false;
			}
		}
		return true;
	}
	
	public String login(String id, String pw) {
		
		users = getUsers();
		
		for(User_DTO user : users) {
			if(id.equals(user.getId()) && pw.equals(user.getPw())) {
				return user.getId();
			}
		}
		
		return "";
	}
}
