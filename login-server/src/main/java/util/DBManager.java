package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	private DBManager() {}

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/loginServer?serverTimeZone=UTC";
			String id = "root";
			String pw = "beCmingth3l3";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			if(conn != null) {
				System.out.println("DB 연동 성공");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
