package controller;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
		setLayout(null);
		setTitle("MainPage");
		setBounds(560,200,700,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();
	}
}
