package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class KioskManager extends Gui_MyUtil{

	public JButton takeOut;
	public JButton takeIn;
	
	
	
	private ImageIcon mainBanner = new ImageIcon(new ImageIcon(String.format("images/mainBanner.png")).getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH));
	private ImageIcon takeInImage = new ImageIcon(new ImageIcon(String.format("images/takeIn.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
	private ImageIcon takeOutImage = new ImageIcon(new ImageIcon(String.format("images/takeOut.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
	public KioskManager() {
		setLayout(null);
		setBounds(0,0, 700, 1000);
		setBackground(new Color(218,173,45));
		setButtons();
		
		
		
		
	}
	

	private void setButtons() {
		takeOut = new JButton(takeOutImage);
		takeIn = new JButton(takeInImage);
		
		this.takeIn.setBounds(170,600,150,150);
		this.takeIn.addActionListener(this);
		add(this.takeIn);
		
		this.takeOut.setBounds(370,600,150,150);
		this.takeOut.addActionListener(this);
		add(this.takeOut);
		
	}



	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(mainBanner.getImage(), 100, 100, 500, 200, null);
		
		repaint();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.takeIn) {
				
			}
			else if(target == this.takeOut) {
				
			}
		}
		
	}
}
