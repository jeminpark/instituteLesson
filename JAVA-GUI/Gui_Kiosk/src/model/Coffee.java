package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Coffee {
	
	private int num;
	private String name;
	private int price;
	private int stock;
	
	private String fileName;
	private ImageIcon image;
	
	public Coffee(int num, String name, int price, int stock) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.fileName = String.format("images/coffee_sub%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	}

	
	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	@Override
	public String toString() {
		
		return this.num+"/"+this.name+"/"+this.price+"\n";
	}
	
	
}
