package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class PaintRect{
	private int x,y,w,h;
	private Color c;
	
	public PaintRect(int x, int y, int w, int h, Color c) {
		this.x =x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
}
class PaintPanel extends Gui_MyUtil{
	
	private ArrayList<PaintRect> rect = new ArrayList<>();
	private ArrayList<PaintRect> circles = new ArrayList<>();
	private ArrayList<PaintRect> triangle = new ArrayList<>();
	
	String[] btnText = {"ㅁ","ㅇ","ㅅ"};
	JButton[] btn = new JButton[3];
	
	
	private PaintRect rectEx = null;
	
	private final int RECTANGLE = 0;
	private final int CIRCLE = 1;
	private final int TRIANGLE = 2;
	
	private int type = -1;
	
	private int startX;
	private int startY;
	private int recX;
	private int recY;
	private int recW;
	private int recH;
	
	private boolean shift;
	
	public PaintPanel() {
		setLayout(null);
		setBounds(0,0,700,700);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		addKeyListener(this);
		setColor();
		setButton();
	}
	private void setButton() {
		int x = 30;
		int y = 50;
		
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			
			this.btn[i].setBounds(x,y,50,50);
			this.btn[i].setText(btnText[i]);
			this.btn[i].setFont(new Font("",Font.BOLD, 15));
			this.btn[i].addActionListener(this);
			
			add(this.btn[i]);
			
			y+=50+3;
		}
	}
	private Color setColor() {
		Random rand = new Random();
		
		Color colorPack[] = {Color.green, Color.red, Color.blue, Color.gray,Color.black, Color.orange};
		
		for(int i=0; i<1000; i++) {
			int rColor = rand.nextInt(colorPack.length);
			
			Color temp = colorPack[0];
			colorPack[0] = colorPack[rColor];
			colorPack[rColor] = temp;
			
		}
		
		return colorPack[0];
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if(this.rectEx != null) {
			
			g.setColor(rectEx.getC());
			
			if(this.type == RECTANGLE) {
				g.drawRect(rectEx.getX(), rectEx.getY(), rectEx.getW(), rectEx.getH());
				
			}
			else if(this.type == CIRCLE) {
				g.drawRoundRect(this.rectEx.getX(), this.rectEx.getY(), this.rectEx.getW(), this.rectEx.getH(), this.rectEx.getW(), this.rectEx.getH() );
			}
			else if(this.type == TRIANGLE) {
				int[] xx = new int[3];
				int[] yy = new int[3];
				
				xx[0] = this.rectEx.getX();
				yy[0] = this.rectEx.getY();
//				xx[1] = this.rectEx.getW()/2 + this.rectEx.getX();
//				yy[1] = this.rectEx.getH();
//				xx[2] = this.rectEx.getX() - this.rectEx.getW()/2;
//				yy[2] = this.rectEx.getH();
				
				//------------------------------------------------------	
				xx[1] = this.rectEx.getX() - this.rectEx.getW()/2;
				yy[1] = this.rectEx.getY() + this.rectEx.getH();
				xx[2] = this.rectEx.getX() + this.rectEx.getW()/2;
				yy[2] = this.rectEx.getY() + this.rectEx.getH();
				
				g.drawPolygon(xx,yy,3);
				
			}
			
		}
		for(int i=0; i<this.rect.size(); i++) {
			PaintRect r = this.rect.get(i);
			
			g.setColor(r.getC());
			g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
		}
		for(int i=0; i<this.circles.size(); i++) {
			PaintRect r = this.circles.get(i);
			
			g.setColor(r.getC());
			g.drawRoundRect(r.getX(), r.getY(), r.getW(), r.getH(), r.getW(), r.getH() );
			
		}
		for(int i=0; i<this.triangle.size(); i++) {
			PaintRect r = this.triangle.get(i);
			
			int[] xx = new int[3];
			int[] yy = new int[3];
			xx[0] = r.getX();
			yy[0] = r.getY();
			xx[1] = r.getW()/2 + r.getX();
			yy[1] = r.getH();
			xx[2] = r.getX() - r.getW()/2;
			yy[2] = r.getH();
			
			g.setColor(r.getC());
			g.drawPolygon(xx,yy, 3);
		}
		
		requestFocusInWindow();
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		super.mouseDragged(e);
		
		int x = e.getX();
		int y = e.getY();
		
		this.recW = Math.abs(x- this.startX);
		this.recH = Math.abs(y- this.startY);
		
		//수정된 삼각형연산자를 역삼각형 만들기위해 삼항연산자를 쓴다.
//		this.recW = this.type == TRIANGLE ? x-this.startX : Math.abs(x- this.startX);
//		this.recH = this.type == TRIANGLE ? y-this.startY : Math.abs(y- this.startY);
		
		if(shift) {
			this.recW = this.recH;
		}
		
		this.recX = this.startX;
		this.recY = this.startY;
		if(x< startX && this.type != TRIANGLE) {
			this.recX = this.startX - this.recW;
		}
		if(y < this.startY && this.type != TRIANGLE) {
			this.recY = this.startY - this.recH;
		}
//		for(PaintRect rect : this.rect) {
//			rect.setC(Color.red);
//		}
		this.rectEx = new PaintRect(recX, recY, recW, recH, Color.red);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		super.mousePressed(e);
		this.startX = e.getX();
		this.startY = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		super.mouseReleased(e);
		
		this.rectEx.setC(Color.red);
		
		if(this.type == RECTANGLE) {
			this.rect.add(new PaintRect (recX, recY, recW, recH, setColor()));
			this.rectEx = null;
			
		}
		else if(this.type == CIRCLE) {
			this.circles.add(new PaintRect (recX, recY, recW, recH, setColor()));
			this.rectEx = null;
		}
		else if(this.type == TRIANGLE) {
			this.triangle.add(new PaintRect (recX, recY, recW, recH, setColor()));
			this.rectEx = null;
		}
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		
		if(e.getSource() == this.btn[RECTANGLE]) {
			this.type = RECTANGLE;
		}
		else if(e.getSource() == this.btn[CIRCLE]) {
			this.type = CIRCLE;
		}
		else if(e.getSource() == this.btn[TRIANGLE]) {
			this.type = TRIANGLE;
		}
	}
	
}
class PaintFrame extends JFrame{
	
	private PaintPanel panel = new PaintPanel();
	
	public PaintFrame() {
		setLayout(null);
		setTitle("paint");
		setBounds(500,200,700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
		
		
	}
}
public class Gui_Painter {
	public static void main(String[] args) {
		PaintFrame paint = new PaintFrame();
	}
}
