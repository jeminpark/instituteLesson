package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.Coffee;
import model.KioskRect;
import model.Tea;

public class OrderPanel extends Gui_MyUtil{

	public JButton backPage;
	
	public static Vector<Coffee> coffee = new Vector<>();
	public static Vector<Tea> tea = new Vector<>();
	public static Vector<Vector<String>> orderlist = new Vector<>();
	private Vector<String> colName = new Vector<>();
	
	
	private PayFrame payframe = null;
	
	private KioskRect[] menu = null;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton[] coffeeMenu;
	private JButton[] teaMenu;
	private JButton pay;
	
	private JTable baguni = null;
	private JScrollPane js = null;
	
	private final int COFFEE = 0;
	private final int TEA = 1;
	private final int PAY = 2;
	private int state;
	
	private int totalPrice;
	private int totalCnt;
	
	private JLabel showPrice;
	private JLabel showCnt;
	
	private JButton resetOrder;
	private JButton tablevalidate;
	
	private boolean emptyCheck;
	
	//������â �����

	
	public OrderPanel() {
		setLayout(null);
		setBounds(0,0,700,1000);
		setBackground(new Color(218,173,45));
		
		setButton();
		
		setCoffee();
		setCoffeeMenu();
		
		setTea();
		setTeaMenu();
		
		setTable();
		
		setShowTotal();	
		
	}



	private void setShowTotal() {
		this.showPrice = new JLabel();		
		this.showPrice.setText("�Ѿ�: 0 ��");
		this.showPrice.setBounds(50,855, 150,45);
		this.showPrice.setFont(new Font("",Font.PLAIN,20));
		add(this.showPrice);
	
		this.showCnt = new JLabel();
		this.showCnt.setText("�ֹ� ����: 0 ��");
		this.showCnt.setBounds(250,855, 170, 45);
		this.showCnt.setFont(new Font("",Font.PLAIN,20));
		add(this.showCnt);
	}


	
	private void setTable() {
		this.colName.add("�����̸�");
		this.colName.add("����");
		this.colName.add("����");	
		
		this.baguni = new JTable(orderlist, colName);
		this.baguni.setBounds(50,660,500,190);
		this.baguni.setBorder(new LineBorder(Color.black));
		this.baguni.setGridColor(Color.black);
		this.baguni.addMouseListener(this);
			
		this.js = new JScrollPane(baguni);
		this.js.setBounds(50,660,500,190);
		add(this.js);
		
		this.baguni.revalidate();
		this.baguni.repaint();
		
		
	}
	private void setTea() {
		tea.add(new Tea(1,"��Ϸ���Ƽ",3500,10));
		tea.add(new Tea(2,"�������Ƽ",3500,10));
		tea.add(new Tea(3,"����ڸ�Ƽ",3500,1));
		tea.add(new Tea(4,"��׷���",2500,10));
		tea.add(new Tea(5,"��ȸ��",2500,0));
		tea.add(new Tea(6,"��Ʈ����Ƽ",2500,10));
		tea.add(new Tea(7,"ĳ����",2500,10));
		tea.add(new Tea(8,"���۹�Ʈ",2500,10));
		tea.add(new Tea(9,"û�������̵�",3500,10));
		tea.add(new Tea(10,"������",2500,10));
		tea.add(new Tea(11,"���̺���",2500,10));
		tea.add(new Tea(12,"������",2500,10));
		tea.add(new Tea(13,"���Ŀ��",2500,10));
		tea.add(new Tea(14,"�����ƾ��̽�Ƽ",3000,10));
		tea.add(new Tea(15,"��緹���̵�",3500,10));
		tea.add(new Tea(16,"�ڸ����̵�",3500,10));	
		
		
	}
	private void setTeaMenu() {
		this.teaMenu = new JButton[16];
		
		int x = 50;
		int y = 50;
		
		for(int i=0; i<this.teaMenu.length; i++) {
			if(i!=0 && i%4 == 0) {
				x = 50;
				y+= 150;
				
			}
			ImageIcon menu = new ImageIcon(tea.get(i).getImage().getImage());
			this.teaMenu[i] = new JButton(menu);
			this.teaMenu[i].setBounds(x,y,150,150);
			this.teaMenu[i].addActionListener(this);
			this.teaMenu[i].setVisible(false);
			add(this.teaMenu[i]);
			x+=150;
			
			
		}
		
		
	}
	private void setCoffeeMenu() {
		this.coffeeMenu = new JButton[16];
		
		int x = 50;
		int y = 50;
		
		for(int i=0; i<this.coffeeMenu.length; i++) {
			if(i!= 0 && i%4 == 0) {
				x = 50;
				y+= 150;
			}
			ImageIcon menu = new ImageIcon(coffee.get(i).getImage().getImage());
			this.coffeeMenu[i] = new JButton(menu);
			
			this.coffeeMenu[i].setBounds(x,y,150,150);
			this.coffeeMenu[i].addActionListener(this);
			add(this.coffeeMenu[i]);
			x+=150;
		}
		
	}
	private void setCoffee() {
		coffee.add(new Coffee(1,"�Ƹ޸�ī��",1500,10));
		coffee.add(new Coffee(2,"����ȾƸ޸�ī��",2500,10));
		coffee.add(new Coffee(3,"������� �Ƹ޸�ī��",2000,10));
		coffee.add(new Coffee(4,"���ھƸ޸�ī��",2500,10));
		coffee.add(new Coffee(5,"īǪġ��",2500,10));
		coffee.add(new Coffee(6,"ī���",2500,10));
		coffee.add(new Coffee(7,"������Ӷ�",3000,1));
		coffee.add(new Coffee(8,"�ٴҶ��",3000,0));
		coffee.add(new Coffee(9,"ũ���̶�",3000,10));
		coffee.add(new Coffee(10,"�������ũ���̶�",3500,0));
		coffee.add(new Coffee(11,"ī���ī",3500,10));
		coffee.add(new Coffee(12,"ī��ḶŰ�ƶ�",3500,10));
		coffee.add(new Coffee(13,"����������",1500,0));
		coffee.add(new Coffee(14,"��ġĿ��",2500,10));
		coffee.add(new Coffee(15,"��ġ�ó���",3000,10));
		coffee.add(new Coffee(16,"��ġ���ڳӶ�",3000,10));
		
	
	}
	private void setButton() {
		this.backPage = new JButton();
		this.backPage.setText("�ڷΰ���");
		this.backPage.setBounds(10,10,100,30);
		add(this.backPage);
		
		
		this.coffeeButton = new JButton();
		this.coffeeButton.setText("Ŀ�� �޴�");
		this.coffeeButton.setBounds(240,10,100,30);
		this.coffeeButton.addActionListener(this);
		add(this.coffeeButton);
		
		this.teaButton = new JButton();
		this.teaButton.setText("���� �޴�");
		this.teaButton.setBounds(360,10,100,30);
		this.teaButton.addActionListener(this);
		add(this.teaButton);
		
		ImageIcon pay = new ImageIcon(new ImageIcon(String.format("images/payButton.png")).getImage().getScaledInstance(610,50,Image.SCALE_SMOOTH));
		this.pay = new JButton(pay);
		this.pay.setText("����ϱ�");
		this.pay.setBounds(50,900,600,50);
		this.pay.addActionListener(this);
		add(this.pay);
		
		this.resetOrder = new JButton();
		this.resetOrder.setText("<HTML><center>���<br>�ʱ�ȭ</center></HTML>");
		this.resetOrder.setBounds(560, 660, 90,70);
		this.resetOrder.addActionListener(this);
		
		
		add(this.resetOrder);
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
	
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();		
			
			if(target == this.coffeeButton) {			
					
				for(int i=0; i<this.coffeeMenu.length; i++) {
					this.coffeeMenu[i].setVisible(true);
					this.teaMenu[i].setVisible(false);
				}			
				this.state = COFFEE;		
				
			}
			else if(target == this.teaButton) {			
				for(int i=0; i<this.coffeeMenu.length; i++) {
					this.coffeeMenu[i].setVisible(false);
					this.teaMenu[i].setVisible(true);
				}				
				this.state = TEA;	
			}
			else if(target == this.resetOrder) {
				
				if(emptyCheck) {
					setResetOrder();
					this.state = COFFEE;
					
				}
				else {
					JOptionPane.showMessageDialog(null, "��ǰ�� ���� ����ּ���.");
				}
			}
			else if(target == this.pay) {
				this.state = PAY;
				
			}		
			
			
			//
			int index = -1;
			if(this.state == COFFEE) {
				for(int i=0; i<this.coffeeMenu.length; i++) {
					if(target == this.coffeeMenu[i]) {
						index = i;
						
					}
				}
				if(index != -1) {
					
					String name = coffee.get(index).getName();				//��̸���Ʈ Ŀ�Ǹ� �׼Ǹ����� Ÿ���� ���� Ŀ�Ǹ޴��� �ε�����ȣ ���ڸ� �޾ƿͼ� �ش� �ε����� �̸��� name������ ����.
					int price = coffee.get(index).getPrice();				//��̸���Ʈ Ŀ���� �ε����� �׼Ǹ����� Ÿ���� Ŀ�Ǹ޴� �ε����� Ŭ���ؼ� �̺�Ʈ�� �Ͼ �ε����� ���ڸ� �޾ƿͼ� �ش� �ε����� ������ price�� ���� 
					int cnt = 1;
					
					setOrderlist(name, price, cnt);
				}
			}
			else if(this.state == TEA) {
				for(int i=0; i<this.teaMenu.length; i++) {
					if(target == this.teaMenu[i]) {
						index = i;
					}
				}
				if(index != -1) {
					String name = tea.get(index).getName();				//��̸���Ʈ Ŀ�Ǹ� �׼Ǹ����� Ÿ���� ���� Ŀ�Ǹ޴��� �ε�����ȣ ���ڸ� �޾ƿͼ� �ش� �ε����� �̸��� name������ ����.
					int price = tea.get(index).getPrice();				//��̸���Ʈ Ŀ���� �ε����� �׼Ǹ����� Ÿ���� Ŀ�Ǹ޴� �ε����� Ŭ���ؼ� �̺�Ʈ�� �Ͼ �ε����� ���ڸ� �޾ƿͼ� �ش� �ε����� ������ price�� ���� 
					int cnt = 1;
					setOrderlist(name,price,cnt);
					
				}
			}
			else if(this.state == PAY) {
				if(emptyCheck) {
					this.payframe = new PayFrame();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "��ǰ�� ���� ����ּ���.");
					this.state = COFFEE;
				}
			
			}
						
			setTotal();	
			this.showPrice.setText("�Ѿ�: "+this.totalPrice+" ��");
			this.showCnt.setText("�ֹ� ����: "+this.totalCnt+" ��");

			
			
		}
	}
	private void setResetOrder() {
		orderlist.clear();

		DefaultTableModel reset = (DefaultTableModel) this.baguni.getModel();
		reset.setNumRows(0);	
	
		this.baguni.revalidate();
		this.baguni.repaint();
		
		this.emptyCheck = false;
		
		
	}



	private void setTotal() {
		
		int totalTemp = 0;
		for(int i=0; i<orderlist.size(); i++) {
			int price = Integer.parseInt(orderlist.get(i).get(1));
			int cnt = Integer.parseInt(orderlist.get(i).get(2));
			totalTemp += price* cnt;
		}
		this.totalPrice = totalTemp;
		
		int tempCnt = 0;
		for(int i=0; i<orderlist.size(); i++) {
			int cnt = Integer.parseInt(orderlist.get(i).get(2));
			
			tempCnt += cnt;
		}
		this.totalCnt = tempCnt;
		
		
	}
	
	private void setOrderlist(String name, int price, int cnt) {
	
		Vector<String> order = new Vector<>();					//2�������Ϳ� Ŀ���̸�, ����, ������ �����ε������� ����ֱ� ���� �ӽ� ���� order�� ����		
		boolean check = false;									
		//��ٱ��Ͽ� �ߺ��� �̸��� �ֳ� ���� üũ
		for(int i=0; i<orderlist.size(); i++) {				//��ٱ��� ����Ʈ�� �ݺ�������
															//��ٱ��� �ȿ� ���ڷ� �޾ƿ� Ŀ�Ǻ����� �ε��� �� �̸��� ���� ������� Ŀ�Ǻ����� �̸��� ���ٸ�
			if(orderlist.get(i).get(0).equals(name)) {		//������ġ�� �Ҵ�.
				check = true;
				
			}
		}
		//��ٱ��Ͽ� �ߺ��� �̸��̾�����
		if(!check) {										
			
			//�����ڸ� �̿��� �ʱ�ȭ���ƴ϶� 2�������Ϳ� �ܺ��ε��� �Ѱ��� �����ε����� Ŀ���̸�, ����, ���� ����ֱ�.
			order.add(name);								//�ӽú��� order 0���ε����� �̸����ְ�
			order.add(price+"");							//�ӽú��� order 1���ε����� ������ �ְ�
			order.add(cnt+"");					//�ӽú��� order 2���ε����� ������ �ִ´�.
						
			orderlist.add(order);							//��ٱ��� 2�������Ϳ� ��������� �Ѱ��� �ܺ��ε����� 3���� �����ε����� ����鼭 �����̵�.
			
			this.baguni.revalidate();
			this.baguni.repaint();
			this.emptyCheck = true;
		}
		//��ٱ��Ͽ� �ߺ��� �̸��� ������
		else {
			
			int choosed = 0;								//��ٱ����� �ش���ǰ�� ��ϵ� �ε����� ã������ ������ �ϳ�����
			for(int i=0; i<orderlist.size(); i++) {			//��ٱ��ϸ���Ʈ�� �ݺ������� ������.
				
				if(orderlist.get(i).get(0).equals(name)) { //���� ��ٱ��ϸ���Ʈ�� �ܺ��ε��� '��'�� 0���ε���(�̸�) �� Ŀ�Ǻ����� ���ڷ� �޾ƿ� �ε����� �̸��� ���ٸ� 
					choosed = i;							//�ε����� �ε��� ������ ����.
					
				}		
			}
			int num = Integer.parseInt(orderlist.get(choosed).get(2)); //��ٱ��� ����Ʈ�� ����� ��ǰ�� ������ ������ ����.
			orderlist.get(choosed).set(2, (num+1)+"");		//��ٱ��� ����Ʈ�� �ش� �ε����� ��ǰ�� ������ ���������ش�.
			
			this.baguni.revalidate();
			this.baguni.repaint();
		}
		for(int i=0; i<orderlist.size(); i++) {
			System.out.println(orderlist.get(i).get(0)+"/"+orderlist.get(i).get(1)+"/"+orderlist.get(i).get(2));//��ٱ��ϸ���Ʈ�� �� �߰��Ǿ��� Ȯ�ο�
			
		}
		System.out.println("==============================");
		
		
	}
	//���̺� ����
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		
		if(e.getSource() == this.baguni) {
			
		}
		
	}
	

	
}
