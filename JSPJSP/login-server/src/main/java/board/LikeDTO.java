package board;

public class LikeDTO {

	private int code, aNum, like;
	private String id;
	
	public LikeDTO(int code, int aNum, String id, int like) {
		this.code = code;
		this.aNum = aNum;
		this.id = id;
		this.like = like;
	}

	public int getCode() {
		return code;
	}
	
	public int getAnum() {
		return aNum;
	}
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getId() {
		return id;
	}
	
	
}
