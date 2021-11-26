package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Coffee;
import model.Tea;
import model.TotalReceipt;

class AdminPanel extends Gui_MyUtil{
	
	private JLabel total;
	private JButton coffeeBtn;
	private JButton teaBtn;
	protected JButton backPage;
	
	private TotalReceipt receipt = new TotalReceipt();
	
	private JTable coffeeTable = null;
	private JScrollPane coffeeJs = null;
	
	private JTable teaTable = null;
	private JScrollPane teaJs = null;
	
	private Vector<String> colName = null;

	private Vector<Vector<String>> coffeeInventory = new Vector<>();
	private Vector<Vector<String>> teaInventory = new Vector<>();
	
	private final int COFFEE = 0;
	private final int TEA = 1;
	
	private int state = 0;	
	
	
	public AdminPanel() {
		setLayout(null);
		setBounds(0,0,500,500);
		setBackground(new Color(152, 152, 52));
		
		setButtons();
		setText();
	
		passAccount();
		setInventory();		
	
		setCoffeeTable();
		setTeaTable();
	}



	private void passAccount() {
		// TODO Auto-generated method stub
		
	}



	private void setInventory() {
		Vector<String> coffeeTemp = new Vector<>();
				
//		String name[] = new String[OrderPanel.coffee.size()];
		
		int n = 0;
		for(int i=0; i<OrderPanel.coffee.size(); i++) {
			String name = OrderPanel.coffee.get(i).getName();
			
			int price = OrderPanel.coffee.get(i).getPrice();
			int stock = OrderPanel.coffee.get(i).getStock();
				
			coffeeTemp.add(name);
			coffeeTemp.add(price+"");
			coffeeTemp.add(stock+"");
			System.out.println(coffeeTemp.get(i));
		}
		
//		this.coffeeInventory.add(coffeeTemp);
			
			
		
			
		
		for(int i=0; i<coffeeInventory.size(); i++) {
			System.out.println(coffeeInventory.get(i).get(0));
		}
		
		
		
		Vector<String> teaTemp = new Vector<>();
		
		for(int i=0; i<OrderPanel.tea.size(); i++) {
			
			teaTemp.add(OrderPanel.tea.get(i).getName());
			teaTemp.add(OrderPanel.tea.get(i).getPrice()+"");
			teaTemp.add(OrderPanel.tea.get(i).getStock()+"");
			
			this.teaInventory.add(teaTemp);
		}
		
		
	}



	private void setText() {
		this.total = new JLabel();
		this.total.setText("총매출액: "+receipt.getTotal()+" 원");
		this.total.setBounds(50,10,240,100);
		this.total.setFont(new Font("",Font.BOLD, 25));
		add(this.total);
		
		
	}

	private void setButtons() {
		this.coffeeBtn = new JButton();
		this.coffeeBtn.setText("커피재고");
		this.coffeeBtn.setBounds(100,400,120,40);
		this.coffeeBtn.addActionListener(this);
		add(this.coffeeBtn);
		
		this.teaBtn = new JButton();
		this.teaBtn.setText("음료재고");
		this.teaBtn.setBounds(270,400,120,40);
		this.teaBtn.addActionListener(this);
		add(this.teaBtn);
		
		this.backPage = new JButton();
		this.backPage.setText("메인메뉴로");
		this.backPage.setBounds(350,20,100,30);
		add(this.backPage);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.coffeeBtn) {
				this.state = COFFEE;
			}
			else if(target == this.teaBtn) {
				this.state = TEA;
			}
			
			if(this.state == COFFEE) {
				this.coffeeJs.setVisible(true);
				this.teaJs.setVisible(false);
			}
			else if(this.state == TEA) {
				this.coffeeJs.setVisible(false);
				this.teaJs.setVisible(true);
			}
			this.coffeeTable.revalidate();
			this.teaTable.repaint();
		}
	}



	private void setTeaTable() {
		this.colName = new Vector<>();
		this.colName.add("제품명");
		this.colName.add("가격");
		this.colName.add("갯수");
		
		this.teaTable = new JTable(this.teaInventory, colName);
		this.teaTable.setBounds(30,100,420,270);
		
		this.teaJs = new JScrollPane(teaTable);
		this.teaJs.setBounds(30,100,420,270);
		add(teaJs);	
		
	}



	private void setCoffeeTable() {
		this.colName = new Vector<>();
		this.colName.add("제품명");
		this.colName.add("가격");
		this.colName.add("갯수");
		
		this.coffeeTable = new JTable(this.coffeeInventory, colName);
		this.coffeeTable.setBounds(30,100,420,270);
		
		this.coffeeJs = new JScrollPane(coffeeTable);
		this.coffeeJs.setBounds(30,100,420,270);
		add(coffeeJs);
		
		
		
		
	}
	
}
public class AdminFrame extends JFrame implements ActionListener{

	private AdminPanel panel = new AdminPanel();
	
	public AdminFrame() {
		setLayout(null);
		setTitle("admin");
		setBounds(600,200,500,500);
		
		add(this.panel);
		this.panel.backPage.addActionListener(this);
		setVisible(true);
		revalidate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.panel.backPage) {
				this.dispose();
			}
		}
		
	}
}

