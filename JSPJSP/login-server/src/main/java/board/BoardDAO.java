package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import util.DBManager;

public class BoardDAO {

	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private int viewCnt = 0;
	private int likeCnt = 0;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs= null;
	
	private ArrayList<BoardDTO> board = null;
	
	public ArrayList<BoardDTO> getContent(){
		board = new ArrayList<>();
			
		try {
			conn = DBManager.getConnection();
			String sql = "select* from board ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String id = rs.getString(4);
				String password = rs.getString(5);
				int view = rs.getInt(6);
				int like = rs.getInt(7);
				Timestamp regDate = rs.getTimestamp(8);
				
				BoardDTO feed = new BoardDTO(code, title, content, id, password, view, like, regDate);
				board.add(feed);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public boolean addUpload(BoardDTO data) {
		
		
		try {
			conn = DBManager.getConnection();
			String sql = "insert board(title, content, id, password) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getTitle());
			pstmt.setString(2, data.getContent());
			pstmt.setString(3, data.getId());
			pstmt.setString(4, data.getPassword());
//			pstmt.setString(5, data.getView()+"");
//			pstmt.setString(6, data.getView()+"");
//			pstmt.setTimestamp(7, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			
			pstmt.executeUpdate();
			
			System.out.println("업로드 성공");
			
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void viewContent(int code) {
		System.out.println(code);
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			String getViewCountsql = "select view from board where code = ?";
			
			pstmt = conn.prepareStatement(getViewCountsql);
			pstmt.setInt(1, code);
			rs= pstmt.executeQuery();
			while(rs.next()) {//공백을 기준으로 반환
				count = rs.getInt(1);// 만들어놓은 변수 count 에 해당코드에서 sql문으로 호출한 칼럼 1번의 값저장
				count++;	// count변수 증가
			}
			
			String sql = "update board set view = ? where code = ?"; //업데이트 테이블명 set칼럼명 ? 다수일땐 콤마, where 코드명
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, code);
			pstmt.executeUpdate();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean setContent(int code, String title, String content, String password) {		
		
		
		
		try {
			conn = DBManager.getConnection();
			String selectSql = "select title, content, password from board where code = ?";
			
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			String sql = "update board set title = ? , content = ?, password = ? where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, password);
			pstmt.setInt(4, code);
			pstmt.executeUpdate();
			conn.close();
						
			System.out.println(code+" 번 글 수정완료");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}
	
	public boolean delContent(int code) {
		
		try {
			conn = DBManager.getConnection();
			String selectSql = "select * from board where code = ?";
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			String sql = "delete from board where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
			conn.close();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
