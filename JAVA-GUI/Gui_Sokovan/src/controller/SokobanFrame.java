package controller;

import javax.swing.JFrame;

public class SokobanFrame extends JFrame{
	
	private GameManager panel = new GameManager();
	
	public SokobanFrame() {
		setLayout(null);
		setTitle("sokoban");
		setBounds(600,200,700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
	}
}
