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
	
	private int playerX;
	private int playerY;
	
	private int wallX;
	private int wallY;
	
	private int passX;
	private int passY;
	
	private final int WALL = 2;
	private final int PASS = 1;
	
	
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
	
		
		
		for(int i=0; i<this.map.length; i++) {
			
			for(int j=0; j<this.map[i].length; j++) {
				if(this.yx[i][j] == 3) {
						this.playerY = i;
						this.playerX = j;
				}
				
			}
		}
		Unit p = this.map[playerY][playerX];
		
		int x = this.playerY;
		int y = this.playerX;
		
	
		
		if(playerX-1 > 0 ) {
			for(int i=0; i<this.map.length; i++) {
				for(int j=0; j<this.map[i].length; j++) {
					
					if(this.yx[i][j] == WALL) {
						wallY = i;
						wallX = j;
						
					}
					if(this.yx[i][j] == PASS) {
						passY = i;
						passX = j;
						
					}
				}
			}
			
			if(this.yx[wallY][wallX] == this.yx[playerY][playerX]) {
				
				p.setState(p.STOP);
			}
			else if(this.yx[passY][passX] == this.yx[playerY][playerX]) {
				p.setState(p.RUN);
			}
		}
		
		
				
		if(this.dir == LEFT) {		
			
			
			if(p.getState() == p.RUN) {
				
				
				p.setX(p.getX()-50);
				
			}
			
			
		}
		else if(this.dir == DOWN) {
			
			
			if(p.getState() == p.RUN) {
				
				if(p.getX()-1 > 0 ) {
					p.setY(p.getY()+50);
					
				}
			}
			
		}
		else if(this.dir == RIGHT) {
			
			
			if(p.getState() == p.RUN) {
				p.setX(p.getX()+50);
			}
			
		}
		else if(this.dir == UP) {
		
			
			if(p.getState() == p.RUN) {
				p.setY(p.getY()-50);
			}
		}
		
	}
	
	
	

	private void setMap() {
		this.map = new Unit[H][W];
		
		int x = 700/2-50*8/2 ;
		int y = 700/2-50*9/2 ;
		
		
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
