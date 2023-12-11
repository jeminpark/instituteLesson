package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Managers;

class PayPanel extends Gui_MyUtil{
	
		
	
	
	protected JButton cash;
	protected JButton card;
	
	private ImageIcon iceCup = new ImageIcon(new ImageIcon(String.format("images/main_info.png")).getImage().getScaledInstance(420, 70, Image.SCALE_SMOOTH));
	private ImageIcon cardImage = new ImageIcon(new ImageIcon(String.format("images/payCard.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
	private ImageIcon cashImage = new ImageIcon(new ImageIcon(String.format("images/payCash.png")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
	
	private int state = 0;
	
	private Vector<String> colName = new Vector<>();
	private JTable result = null;
	private JScrollPane js = null;
	
	public PayPanel() {
		setLayout(null);
		setBounds(0,0,500,500);
		setBackground(new Color(219,211,120));
		setButtons();
		
		setResultTable();
	}

	private void setResultTable() {
		this.colName.add("이름");
		this.colName.add("가격");
		this.colName.add("개수");
		
		
		
		this.result = new JTable(OrderPanel.orderlist, colName);
		this.result.setBounds(30,100,420,100);
		
		this.js = new JScrollPane(this.result);
		this.js.setBounds(30,100,420,100);
		add(js);
		
	}

	private void setButtons() {
		
		this.card = new JButton(cardImage);
		this.card.setBounds(30,210,200,200);
		this.card.addActionListener(this);
		add(this.card);
		
		this.cash = new JButton(cashImage);
		this.cash.setBounds(250, 210, 200,200);
		this.cash.addActionListener(this);
		add(this.cash);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(iceCup.getImage(), 30, 10, 420, 70,null);
	}
		
}
public class PayFrame extends JFrame implements ActionListener{
	
	public PayPanel panel = new PayPanel();
	public CardPay cardPanel = new CardPay();
	public CashPay cashPanel = new CashPay();

	public PayFrame() {
		setLayout(null);
		setTitle("결제창");
		setBounds(500,200,500,500);
		add(this.panel);
		setVisible(true);
		revalidate();
		
		this.panel.card.addActionListener(this);
		this.panel.cash.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.panel.card) {
				this.setContentPane(cardPanel);
				
				
				
			}
			else if(target == this.panel.cash) {
				this.setContentPane(cashPanel);
			}
			
		}
		
	}
	
}
