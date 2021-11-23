package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Coffee;
import model.KioskRect;
import model.Tea;

public class OrderPanel extends Gui_MyUtil{

	public JButton backPage;
	
	public static Vector<Coffee> coffee = new Vector<>();
	public static Vector<Tea> tea = new Vector<>();
	public static Vector<Vector<String>> orderlist = new Vector<>();
	public static Vector<String> colName = new Vector<>();
	
	
	private KioskRect[] menu = null;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton[] coffeeMenu;
	private JButton[] teaMenu;
	private JButton pay;
	
	private JTable baguni;
	
	private final int COFFEE = 0;
	private final int TEA = 1;
	private int state;
	
	
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
		
		
	}

	private void setTable() {
		this.colName.add("음료이름");
		this.colName.add("가격");
		this.colName.add("갯수");
		this.colName.add("총액");
		
		int x = 30;
		int y = 600;
				
		
		this.baguni = new JTable(orderlist, colName);
//		this.baguni.setBorder(x,y);
//		
//		JScrollpane scroll = new JScrollPane(baguni);
//		scroll.set
		
		
		
	}
	private void setTea() {
		tea.add(new Tea(1,"허니레몬티",3500));
		tea.add(new Tea(2,"허니유자티",3500));
		tea.add(new Tea(3,"허니자몽티",3500));
		tea.add(new Tea(4,"얼그레이",2500));
		tea.add(new Tea(5,"국회차",2500));
		tea.add(new Tea(6,"민트초코티",2500));
		tea.add(new Tea(7,"캐모마일",2500));
		tea.add(new Tea(8,"페퍼민트",2500));
		tea.add(new Tea(9,"청포도에이드",3500));
		tea.add(new Tea(10,"보이차",2500));
		tea.add(new Tea(11,"루이보스",2500));
		tea.add(new Tea(12,"로즈힐",2500));
		tea.add(new Tea(13,"허비스커스",2500));
		tea.add(new Tea(14,"복숭아아이스티",3000));
		tea.add(new Tea(15,"블루레몬에이드",3500));
		tea.add(new Tea(16,"자몽에이드",3500));
		
		
		
		
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
		add(this.pay);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
	
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
		
			//커피메뉴액션이벤트		
			
			//커피메뉴를 클릭하면 커피메뉴버튼만 나오고 음료는 없어진다.
			//음료메뉴를 클릭하면 음료메뉴버튼만 나오고 커피는 없어진다.
			//커피메뉴버튼하고 인덱스는 아무상관이없는데 왜 자꾸 액션이 나오는거지			
			
			
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

			
			
		}
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
			order.add(cnt+"");								//임시벡터 order 2번인덱스에 갯수를 넣는다.
			
			orderlist.add(order);							//장바구니 2차원벡터에 집어넣으면 한개의 외부인덱스에 3개의 내부인덱스가 생기면서 저장이됨.
			
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
		}
		for(int i=0; i<orderlist.size(); i++) {
			System.out.println(orderlist.get(i).get(0)+"/"+orderlist.get(i).get(1)+"/"+orderlist.get(i).get(2));//장바구니리스트에 잘 추가되었나 확인용
			
		}
		System.out.println("==============================");
		
		
	}

	
}
