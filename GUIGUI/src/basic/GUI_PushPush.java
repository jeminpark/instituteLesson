package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class PushNemo {
	private int x,y,w,h;
	private Color c;
	
	public PushNemo(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return this.w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return this.h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Color getC() {
		return this.c;
	}
	public void setC(Color c) {
		this.c = c;
	}
}

class PushPanel extends JPanel implements MouseListener{
	
	private PushNemo nemo1;
	private PushNemo nemo2;
	
	private String arrow = "ก็,ก้,กๆ,ก่";
	private JButton[] btn = null;
	private boolean isRun;
	
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private int dir =5;
	private boolean getColor;
	
	public PushPanel() {
		setLayout(null);
		setBounds(0,0,PushFrame.SIZE, PushFrame.SIZE);
		
		setNemo();
		setButton();
	}
	private void setNemo() {
		Random rand = new Random();
		
		int rX = rand.nextInt(PushFrame.SIZE-200);
		int rY = rand.nextInt(PushFrame.SIZE-200);
		
		this.nemo1 = new PushNemo(rX, rY, 100,100, Color.blue);
		
		while(true) {
			rX = rand.nextInt(PushFrame.SIZE - 200);
			rY = rand.nextInt(PushFrame.SIZE - 200);
			
			boolean check = false;
			
			if(this.nemo1.getX() == rX && this.nemo1.getX()-110 < rX && this.nemo1.getX()+110 > rX 
					&& this.nemo1.getY() == rY && this.nemo1.getY()-110 < rY && this.nemo1.getY()+110 > rY) {
				check = true;
			}
			if(!check) {
				this.nemo2 = new PushNemo(rX, rY, 100,100, Color.red);
				break;
			}
		}
		
	}
	private void setButton() {
		this.btn = new JButton[4];
		
		int x = PushFrame.SIZE/2+200 -50*4/2;
		int y = PushFrame.SIZE/2+300 -50*4/2;
		
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			String str[] = arrow.split(",");
			this.btn[i].setText(str[i]);
			this.btn[i].setFont(new Font("",Font.BOLD,10));
			this.btn[i].setBounds(x,y,50,50);		
			this.btn[i].addMouseListener(this);
			
			add(this.btn[i]);
			x+= 50;
			
			if(i == this.btn.length -1-1) {
				y-= 50;
				x-= 100;
			}
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(this.nemo1.getC());
		g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getW(), this.nemo1.getH());
		
		g.setColor(this.nemo2.getC());		
		g.drawRect(this.nemo2.getX(), this.nemo2.getY(), this.nemo2.getW(), this.nemo2.getH());
		
		if(isRun) {
			NemoMove();
			
			if(getColor) {
				g.setColor(Color.MAGENTA);
				g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getW(), this.nemo1.getH());
			}
		}
		repaint();
	}
	private void NemoMove() {
		if(this.dir == this.LEFT) {
			if(this.nemo2.getX()-1 > 0) {
				this.nemo2.setX(this.nemo2.getX()-1);
				if(this.nemo2.getX() == this.nemo1.getX()+100 && this.nemo2.getY()-100 < this.nemo1.getY() 
						&& this.nemo2.getY()+100 > this.nemo1.getY()) {
					if(this.nemo1.getX()-1>0) {
						this.nemo1.setX(this.nemo1.getX()-1);
//						System.out.println(this.nemo1.getX());
						this.getColor = true;
					}
					else if(this.nemo1.getX() == 1) {
						this.dir = 5;
					}
				}
				else {
					this.getColor = false;
				}
			}
		}
		else if(this.dir == this.DOWN) {
			if(this.nemo2.getY()+1 < 562) {
				this.nemo2.setY(this.nemo2.getY()+1);
				if(this.nemo2.getY() == this.nemo1.getY()-100 && this.nemo2.getX()-100 < this.nemo1.getX() 
						&& this.nemo2.getX()+100 > this.nemo1.getX()) {
					if(this.nemo1.getY()+1 <562) {
						this.nemo1.setY(this.nemo1.getY()+1);
//						System.out.println(this.nemo1.getY());
						this.getColor = true;
					}
					else if(this.nemo1.getY() == 561) {
						this.dir = 5;
					}
				}
				else {
					this.getColor = false;
				}
			}
		}
		else if(this.dir == this.RIGHT) {
			if(this.nemo2.getX()+1 < 584) {
				this.nemo2.setX(this.nemo2.getX()+1);
				if(this.nemo2.getX() == this.nemo1.getX()-100 && this.nemo2.getY() > this.nemo1.getY()-100 
						&& this.nemo2.getY() < this.nemo1.getY()+100) {
					if(this.nemo1.getX()+1 < 584) {
						this.nemo1.setX(this.nemo1.getX()+1);
//						System.out.println(this.nemo1.getX());
						
						this.getColor = true;
					}
					else if(this.nemo1.getX() == 583) {
						this.dir = 5;
					}
				}
				else {
					this.getColor = false;
				}
			}
		}
		else if(this.dir == this.UP) {
			if(this.nemo2.getY()-1 > 0) {
				this.nemo2.setY(this.nemo2.getY()-1);
				if(this.nemo2.getY() == this.nemo1.getY()+100 && this.nemo2.getX() > this.nemo1.getX()-100
						&& this.nemo2.getX() < this.nemo1.getX()+100){
					if(this.nemo1.getY()-1 > 0 ) {
						this.nemo1.setY(this.nemo1.getY()-1);
//						System.out.println(this.nemo1.getY());
					
						this.getColor = true;
					}
					else if(this.nemo1.getY() == 1) {
						this.dir = 5;
					}
				}
				else {
					this.getColor = false;
				}
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.isRun = true;
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton)e.getSource();
			
			if(target == this.btn[LEFT]) {
				this.dir = this.LEFT;
			}
			else if(target == this.btn[DOWN]) {
				this.dir = this.DOWN;
			}
			else if(target == this.btn[RIGHT]) {
				this.dir = this.RIGHT;
			}
			else if(target == this.btn[UP]) {
				this.dir = this.UP;
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.isRun = false;
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
class PushFrame extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	
	public static final int SIZE = 700;
	
	private PushPanel panel = new PushPanel();
	
	public PushFrame() {
		setLayout(null);
		setTitle("pushpush");
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
	}
}
public class GUI_PushPush {

	public static void main(String[] args) {
		PushFrame push = new PushFrame();
	}
}
