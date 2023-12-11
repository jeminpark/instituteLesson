package controller;

import java.awt.Graphics;
import java.awt.Image;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CashPay extends Gui_MyUtil{

	private long time = System.currentTimeMillis();
	private SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분 ss초");
	
	ImageIcon cashImage = new ImageIcon(new ImageIcon(String.format("images/cashInsert.png")).getImage().getScaledInstance(485, 400, Image.SCALE_SMOOTH));
	
	public JButton backPage;
	
	private JLabel money;
	private JTextField moneyField;
	
	
	public CashPay() {
		setLayout(null);
		setBounds(0,0,500,500);
		
		setButton();
		setTextField();
	}


	private void setButton() {
		this.backPage = new JButton();
		this.backPage.setText("뒤로가기");
		this.backPage.setBounds(355, 410, 100,50);
	
		add(this.backPage);
		
	}


	private void setTextField() {
		this.money = new JLabel();
		this.money.setBounds(50, 410, 100,50);
		this.money.setText("금액: ");
		add(this.money);
		
		this.moneyField = new JTextField();
		this.moneyField.setBounds(80, 420, 150,30);
		add(this.moneyField);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(cashImage.getImage(), 0, 0, 485, 400,null);
	}
}
