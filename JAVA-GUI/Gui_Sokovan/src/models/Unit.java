package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Unit {

	//��ϰ� ����� ��ǥ x,y ũ��, �׸��� �ҷ��� ����
	//��, ��, ���, �׳ɹڽ�, ��ġ, ��ġ���÷����ڽ�
	//
	private int x,y,w,h;
	private int num;
	private String fileName;
	private ImageIcon image;
	
	private int state;
	
	public final int RUN = 0;
	public final int STOP = 1;
	public final int MOVE = 2;
	
	public Unit(int num, int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images/tile%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		
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
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = String.format("images/tile%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public int getState() {
		return this.state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
