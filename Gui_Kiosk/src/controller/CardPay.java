package controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CardPay extends Gui_MyUtil {

	private ImageIcon cardImage = new ImageIcon(new ImageIcon(String.format("images/cardInsert.png")).getImage().getScaledInstance(480, 400, Image.SCALE_SMOOTH));
	
	
	
	public CardPay() {
		setLayout(null);
		setBounds(0,0,500,500);
				
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(cardImage.getImage(), 0, 0, 485, 500,null);
	}
	

	
	
	
}
