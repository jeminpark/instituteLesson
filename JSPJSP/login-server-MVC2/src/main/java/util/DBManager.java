package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	private DBManager() {};
	
	public static Connection getConnection() {
				
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://mydb.cgcwqypoauiv.ap-northeast-2.rds.amazonaws.com:3306/loginServer?serverTimeZone=UTC";
			String user = "admin";
			String password = "6FPfD7tGCZrWPV2k";
			
			conn = DriverManager.getConnection(url, user, password);
			
			if(conn != null) {
				System.out.println("loginServer@aws-rds Database 연동성공!");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("연동실패");
		}
		
		return conn;
	}
	
	
}
