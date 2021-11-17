package basic;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Horse{
	
	private int num;
	private int x,y,w,h;
	private String fileName;
	private ImageIcon images;
	
	private int state;
	private int rank;
	private String record;
	
	public Horse(int num, int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images/horse%d.png", this.num);
		this.images = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ImageIcon getImages() {
		return images;
	}

	public void setImages(ImageIcon images) {
		this.images = images;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}
	
	
}
class HorsePanel extends Gui_MyUtil{
	
}
class HorseFrame extends JFrame{
	
	private HorsePanel panel = new HorsePanel();
	
	public HorseFrame() {
		setLayout(null);
		setTitle("horse");
		setBounds(600,200,700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
	}
}

public class Gui_Horse {

	public static void main(String[] args) {
		new HorseFrame();
	}
}
