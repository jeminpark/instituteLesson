package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;

public class UserDao {
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private ArrayList<UserDto> users = null;
	
	public ArrayList<UserDto> getUsers(){
		
		users = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "select* from users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				
				UserDto user = new UserDto(code, id, pw, name);
				users.add(user);
				System.out.println(user.toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}
	public boolean checkLogin(String id, String pw) {
		
		ArrayList<UserDto> users = getUsers();
		for(UserDto user: users) {
			if(id.equals(user.getId()) && pw.equals(user.getPw())) {
				return true;
			}
		}
		return false;	
		
	}
}
