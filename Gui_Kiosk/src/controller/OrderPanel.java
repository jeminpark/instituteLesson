package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;

import model.Coffee;
import model.KioskRect;
import model.Tea;

public class OrderPanel extends Gui_MyUtil{

	JButton backPage;
	
	public static Vector<Coffee> coffee = new Vector<>();
	public static Vector<Tea> tea = new Vector<>();
	
	private KioskRect[] menu = null;
	JButton coffeeButton;
	JButton teaButton;
	
	
	
	public OrderPanel() {
		setLayout(null);
		setBounds(0,0,700,800);
		setBackground(new Color(218,173,45));
		
		setButton();
		
		setCoffee();
		
	}
	private void setCoffee() {
		coffee.add(new Coffee(1,"아메리카노",1500));
		coffee.add(new Coffee(2,"스페셜아메리카노",2500));
		coffee.add(new Coffee(3,"헤이즐넛 아메리카노",2000));
		coffee.add(new Coffee(4,"유자아메리카노",2500));
		coffee.add(new Coffee(5,"카푸치노",2500));
		coffee.add(new Coffee(6,"카페라떼",2500));
		coffee.add(new Coffee(7,"헤이즐넛라떼",3000));
		coffee.add(new Coffee(8,"바닐라라떼",3000));
		coffee.add(new Coffee(9,"크리미라떼",3000));
		coffee.add(new Coffee(10,"헤이즐넛크리미라떼",3500));
		coffee.add(new Coffee(11,"카페모카",3500));
		coffee.add(new Coffee(12,"카라멜마키아또",3500));
		coffee.add(new Coffee(13,"에스프레소",1500));
		coffee.add(new Coffee(14,"더치커피",2500));
		coffee.add(new Coffee(15,"더치시나몬",3000));
		coffee.add(new Coffee(16,"더치코코넛라떼",3000));
		
		int x = 30;
		int y = 30;
		
		this.menu = new KioskRect[coffee.size()];
		for(int i=0; i<menu.length; i++) {
			this.menu[i] = new KioskRect(i+1, x,y,70,70);
			
			
			
			y+=70;
			
		}
	}
	private void setButton() {
		this.backPage = new JButton();
		this.backPage.setText("뒤로가기");
		this.backPage.setBounds(10,10,100,30);
		add(this.backPage);
		
		
		this.coffeeButton = new JButton();
		this.coffeeButton.setText("커피 메뉴");
		this.coffeeButton.setBounds(240,10,100,30);
		this.coffeeButton.addActionListener(this);
		add(this.coffeeButton);
		
		this.teaButton = new JButton();
		this.teaButton.setText("음료 메뉴");
		this.teaButton.setBounds(360,10,100,30);
		this.teaButton.addActionListener(this);
		add(this.teaButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.coffeeButton) {
				for(int i=0; i<coffee.size(); i++) {
					System.out.println(coffee.get(i));
				}
			}
			else if(target == this.teaButton) {
				
			}
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		for(int i=0; i<coffee.size(); i++) {
			g.drawImage(coffee.get(i).getImage().getImage(), 30, 200, null);
			
		}
		repaint();
	}
}
