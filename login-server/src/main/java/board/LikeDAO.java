package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;

public class LikeDAO {

	
	private LikeDAO() {}
	private static LikeDAO instance = new LikeDAO();
	public static LikeDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ArrayList<LikeDTO> liked = null;
	
	public ArrayList<LikeDTO> getLiked(){
		liked = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			String sql = "select * from likePanel";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int code = rs.getInt(1);
				int aNum = rs.getInt(2);
				String userId = rs.getString(3);
				int likes = rs.getInt(3);
				
				LikeDTO likeit = new LikeDTO(code, aNum, userId, likes);
				
				this.liked.add(likeit);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return liked;
	}
	
	public boolean addLike(LikeDTO likes) {
		try {
			conn = DBManager.getConnection();
			String sql = "insert likePanel(aNum, id, like) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, likes.getAnum());
			pstmt.setString(2, likes.getId());
			pstmt.setInt(3, likes.getLike());
			
			pstmt.executeUpdate();
			System.out.println("좋아요를 클릭하였다.");
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
}
