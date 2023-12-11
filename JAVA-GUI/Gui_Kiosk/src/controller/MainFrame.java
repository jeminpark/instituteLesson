package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Managers;

public class MainFrame extends JFrame implements ActionListener{

	private AdminFrame admin = null;
	private KioskManager km = new KioskManager();
	
	
	private OrderPanel order = new OrderPanel();
	
	private Vector<Managers> manager;
	//Ű����ũ �Ŵ����� �гη� ���µ� ���͸� �����ӿ�����? 
	public MainFrame() {
		setLayout(null);
		setTitle("MainPage");
		setBounds(560,50,700,1000);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.km);
		//���������ӿ� �гθ� ��ü�ϱ����� �׼Ǹ����� ������
		this.km.takeIn.addActionListener(this);
		this.km.takeOut.addActionListener(this);
		this.order.backPage.addActionListener(this);
		this.km.admin.addActionListener(this);
		
		setVisible(true);
		revalidate();
		
		setAdmin();
	}

	private void setAdmin() {
		this.manager = new Vector<>();
		this.manager.add(new Managers("qwer","1111"));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton ) {
			//��ư�� ������ �г��� ��ü��.
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
			else if(this.km.admin == target) {
				this.admin = new AdminFrame();
			}
		}
		
	}
}
