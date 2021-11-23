package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener{

	private KioskManager km = new KioskManager();
	
	
	private OrderPanel order = new OrderPanel();
	
	
	//키오스크 매니저를 패널로 쓰는데 벡터를 프레임에개설? 
	public MainFrame() {
		setLayout(null);
		setTitle("MainPage");
		setBounds(560,100,700,1000);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.km);
		//지금프레임에 패널만 교체하기위해 액션리스너 입히기
		this.km.takeIn.addActionListener(this);
		this.km.takeOut.addActionListener(this);
		this.order.backPage.addActionListener(this);
		
		setVisible(true);
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton ) {
			//버튼을 누르면 패널이 교체됨.
			JButton target = (JButton) e.getSource();
			
			if(this.km.takeIn == target) {
				this.setContentPane(this.order);
			}
			else if(this.km.takeOut == target) {
				this.setContentPane(this.order);
			}
			else if(this.order.backPage == target) {
				this.setContentPane(km);
			}			
		}
		
	}
}
