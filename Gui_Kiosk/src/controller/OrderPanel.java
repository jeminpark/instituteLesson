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
	
	//프레임창 끄기용

	
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
		this.showPrice.setText("총액: 0 원");
		this.showPrice.setBounds(50,855, 150,45);
		this.showPrice.setFont(new Font("",Font.PLAIN,20));
		add(this.showPrice);
	
		this.showCnt = new JLabel();
		this.showCnt.setText("주문 갯수: 0 개");
		this.showCnt.setBounds(250,855, 170, 45);
		this.showCnt.setFont(new Font("",Font.PLAIN,20));
		add(this.showCnt);
	}


	
	private void setTable() {
		this.colName.add("음료이름");
		this.colName.add("가격");
		this.colName.add("갯수");	
		
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
		tea.add(new Tea(1,"허니레몬티",3500,10));
		tea.add(new Tea(2,"허니유자티",3500,10));
		tea.add(new Tea(3,"허니자몽티",3500,1));
		tea.add(new Tea(4,"얼그레이",2500,10));
		tea.add(new Tea(5,"국회차",2500,0));
		tea.add(new Tea(6,"민트초코티",2500,10));
		tea.add(new Tea(7,"캐모마일",2500,10));
		tea.add(new Tea(8,"페퍼민트",2500,10));
		tea.add(new Tea(9,"청포도에이드",3500,10));
		tea.add(new Tea(10,"보이차",2500,10));
		tea.add(new Tea(11,"루이보스",2500,10));
		tea.add(new Tea(12,"로즈힐",2500,10));
		tea.add(new Tea(13,"허비스커스",2500,10));
		tea.add(new Tea(14,"복숭아아이스티",3000,10));
		tea.add(new Tea(15,"블루레몬에이드",3500,10));
		tea.add(new Tea(16,"자몽에이드",3500,10));	
		
		
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
		coffee.add(new Coffee(1,"아메리카노",1500,10));
		coffee.add(new Coffee(2,"스페셜아메리카노",2500,10));
		coffee.add(new Coffee(3,"헤이즐넛 아메리카노",2000,10));
		coffee.add(new Coffee(4,"유자아메리카노",2500,10));
		coffee.add(new Coffee(5,"카푸치노",2500,10));
		coffee.add(new Coffee(6,"카페라떼",2500,10));
		coffee.add(new Coffee(7,"헤이즐넛라떼",3000,1));
		coffee.add(new Coffee(8,"바닐라라떼",3000,0));
		coffee.add(new Coffee(9,"크리미라떼",3000,10));
		coffee.add(new Coffee(10,"헤이즐넛크리미라떼",3500,0));
		coffee.add(new Coffee(11,"카페모카",3500,10));
		coffee.add(new Coffee(12,"카라멜마키아또",3500,10));
		coffee.add(new Coffee(13,"에스프레소",1500,0));
		coffee.add(new Coffee(14,"더치커피",2500,10));
		coffee.add(new Coffee(15,"더치시나몬",3000,10));
		coffee.add(new Coffee(16,"더치코코넛라떼",3000,10));
		
	
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
		
		ImageIcon pay = new ImageIcon(new ImageIcon(String.format("images/payButton.png")).getImage().getScaledInstance(610,50,Image.SCALE_SMOOTH));
		this.pay = new JButton(pay);
		this.pay.setText("계산하기");
		this.pay.setBounds(50,900,600,50);
		this.pay.addActionListener(this);
		add(this.pay);
		
		this.resetOrder = new JButton();
		this.resetOrder.setText("<HTML><center>목록<br>초기화</center></HTML>");
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
					JOptionPane.showMessageDialog(null, "상품을 먼저 골라주세요.");
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
					
					String name = coffee.get(index).getName();				//어레이리스트 커피를 액션리스너 타겟이 눌린 커피메뉴의 인덱스번호 인자를 받아와서 해당 인덱스의 이름을 name변수에 저장.
					int price = coffee.get(index).getPrice();				//어레이리스트 커피의 인덱스를 액션리스너 타겟이 커피메뉴 인덱스를 클릭해서 이벤트가 일어난 인덱스로 인자를 받아와서 해당 인덱스의 가격을 price에 저장 
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
					String name = tea.get(index).getName();				//어레이리스트 커피를 액션리스너 타겟이 눌린 커피메뉴의 인덱스번호 인자를 받아와서 해당 인덱스의 이름을 name변수에 저장.
					int price = tea.get(index).getPrice();				//어레이리스트 커피의 인덱스를 액션리스너 타겟이 커피메뉴 인덱스를 클릭해서 이벤트가 일어난 인덱스로 인자를 받아와서 해당 인덱스의 가격을 price에 저장 
					int cnt = 1;
					setOrderlist(name,price,cnt);
					
				}
			}
			else if(this.state == PAY) {
				if(emptyCheck) {
					this.payframe = new PayFrame();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "상품을 먼저 골라주세요.");
					this.state = COFFEE;
				}
			
			}
						
			setTotal();	
			this.showPrice.setText("총액: "+this.totalPrice+" 원");
			this.showCnt.setText("주문 갯수: "+this.totalCnt+" 개");

			
			
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
	
		Vector<String> order = new Vector<>();					//2차원벡터에 커피이름, 가격, 갯수를 내부인덱스별로 집어넣기 위해 임시 벡터 order를 생성		
		boolean check = false;									
		//장바구니에 중복된 이름이 있나 없나 체크
		for(int i=0; i<orderlist.size(); i++) {				//장바구니 리스트를 반복문돌려
															//장바구니 안에 인자로 받아온 커피벡터의 인덱스 의 이름이 현재 집어넣을 커피벡터의 이름과 같다면
			if(orderlist.get(i).get(0).equals(name)) {		//검증장치를 켠다.
				check = true;
				
			}
		}
		//장바구니에 중복된 이름이없으면
		if(!check) {										
			
			//생성자를 이용한 초기화가아니라 2차원벡터에 외부인덱스 한곳의 내부인덱스에 커피이름, 가격, 갯수 집어넣기.
			order.add(name);								//임시벡터 order 0번인덱스에 이름을넣고
			order.add(price+"");							//임시벡터 order 1번인덱스에 가격을 넣고
			order.add(cnt+"");					//임시벡터 order 2번인덱스에 갯수를 넣는다.
						
			orderlist.add(order);							//장바구니 2차원벡터에 집어넣으면 한개의 외부인덱스에 3개의 내부인덱스가 생기면서 저장이됨.
			
			this.baguni.revalidate();
			this.baguni.repaint();
			this.emptyCheck = true;
		}
		//장바구니에 중복된 이름이 있으면
		else {
			
			int choosed = 0;								//장바구니의 해당제품이 등록된 인덱스를 찾기위해 변수를 하나선언
			for(int i=0; i<orderlist.size(); i++) {			//장바구니리스트를 반복문으로 돌린다.
				
				if(orderlist.get(i).get(0).equals(name)) { //만약 장바구니리스트의 외부인덱스 '중'에 0번인덱스(이름) 이 커피벡터의 인자로 받아온 인덱스의 이름과 같다면 
					choosed = i;							//인덱스를 인덱스 변수에 저장.
					
				}		
			}
			int num = Integer.parseInt(orderlist.get(choosed).get(2)); //장바구니 리스트에 저장된 제품의 갯수를 변수에 저장.
			orderlist.get(choosed).set(2, (num+1)+"");		//장바구니 리스트의 해당 인덱스의 제품의 갯수를 증가시켜준다.
			
			this.baguni.revalidate();
			this.baguni.repaint();
		}
		for(int i=0; i<orderlist.size(); i++) {
			System.out.println(orderlist.get(i).get(0)+"/"+orderlist.get(i).get(1)+"/"+orderlist.get(i).get(2));//장바구니리스트에 잘 추가되었나 확인용
			
		}
		System.out.println("==============================");
		
		
	}
	//테이블 수정
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		
		if(e.getSource() == this.baguni) {
			
		}
		
	}
	

	
}
