package controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;

import models.Unit;



public class GameManager extends MyUtil {
	
	Random rand = new Random();
	
	private JButton reset;
	private final int W = 8;
	private final int H = 9;

	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private int dir = 5;

	private int yx[][] ={ {1,1,2,2,2,2,2,1},
						  {2,2,2,1,1,1,2,1},
			              {2,5,3,4,1,1,2,1},
			              {2,2,2,1,4,5,2,1},
			              {2,5,2,2,4,1,2,1},
			              {2,1,2,1,5,1,2,2},
			              {2,4,1,6,4,4,5,2},
			              {2,1,1,1,5,1,1,2},
			              {2,2,2,2,2,2,2,2}};
	
	private Unit map[][];
	
	private int xx;
	private int yy;
	
	
//						  {1,1,2,2,2,2,2,1},
//						  {2,2,2,1,1,1,2,1},
//						  {2,5,3,4,1,1,2,1},
//						  {2,2,2,1,4,5,2,1},
//						  {2,5,2,2,4,1,2,1},
//						  {2,1,2,1,5,1,2,2},
//						  {2,4,1,6,4,4,5,2},
//						  {2,1,1,1,5,1,1,2},
//						  {2,2,2,2,2,2,2,2}
						  
	
	public GameManager() {
		setLayout(null);
		setBounds(0,0,700,700);
		
		
		setFocusable(true);
		addKeyListener(this);
		
		setMap();	
		setMarker();
		
		
		setButton();
	}	
	

	private void setMarker() {
		// TODO Auto-generated method stub
		
	}


	private void setButton() {
		this.reset = new JButton();
		this.reset.setText("reset");
		this.reset.setBounds(10,10,70,30);
		this.reset.addActionListener(this);
		add(this.reset);
		
	}

	private void playGame() {
	
		int idx1 = 0;
		int idx2 = 0;
		
		for(int i=0; i<this.map.length; i++) {
			
			for(int j=0; j<this.map[i].length; j++) {
				if(this.yx[i][j] == 3) {
						idx1 = i;
						idx2 = j;
				}
			}
		}
		
		if(this.dir == LEFT) {
			this.map[idx1][idx2].setX(this.map[idx1][idx2].getX()-50);
		}
		else if(this.dir == DOWN) {
			this.map[idx1][idx2].setY(this.map[idx1][idx2].getY()+50);
		}
		else if(this.dir == RIGHT) {
			this.map[idx1][idx2].setX(this.map[idx1][idx2].getX()+50);
		}
		else if(this.dir == UP) {
			this.map[idx1][idx2].setY(this.map[idx1][idx2].getY()-50);
		}
		
	}

	private void setMap() {
		this.map = new Unit[H][W];
		
		int x = 700/2-50*8/2 ;
		int y = 700/2-50*8/2 ;
		
		
		for(int i=0; i<this.H; i++) {		
			
			for(int j=0; j<this.W; j++) {
				this.map[i][j] = new Unit(this.yx[i][j], x,y,50,50);
				
			
				x+= 50;
				
			}
			x = 700/2-50*8/2 ;
			y+= 50;
		}
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
			
		
		//map
		for(int i=0; i<this.H; i++) {
			for(int j=0; j<this.W; j++) {
				Unit m = this.map[i][j];
				
				g.drawImage(m.getImage().getImage(), m.getX(), m.getY(), null);
			}
		}
//		playGame();
		requestFocusInWindow();
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.reset) {				
				resetGame();
			}
			
		}
		
	}
	private void resetGame() {
		setMap();
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		
		if(e.getKeyCode() == e.VK_LEFT) {
			this.dir = this.LEFT;
		}
		else if(e.getKeyCode() == e.VK_DOWN) {
			this.dir = this.DOWN;
		}
		else if(e.getKeyCode() == e.VK_RIGHT) {
			this.dir = this.RIGHT;
		}
		else if(e.getKeyCode() == e.VK_UP) {
			this.dir = this.UP;
		}
		playGame();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	}
	
}
