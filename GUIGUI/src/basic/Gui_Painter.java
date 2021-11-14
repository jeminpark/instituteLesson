package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

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
	private PaintRect rectEx;
	
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
	}
	private Color setColor() {
		Random rand = new Random();
		
		Color colorPack[] = {Color.green, Color.red, Color.blue, Color.gray};
		
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
		
		if(this.rect != null && this.rectEx != null) {
			
			g.setColor(rectEx.getC());
			g.drawRect(rectEx.getX(), rectEx.getY(), rectEx.getW(), rectEx.getH());
			
			for(int i=0; i<this.rect.size(); i++) {
				PaintRect r = this.rect.get(i);
				
				g.setColor(r.getC());
				g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
			}
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
		
		if(shift) {
			this.recW = this.recH;
		}
		
		this.recX = this.startX;
		this.recY = this.startY;
		if(x< startX) {
			this.recX = this.startX - this.recW;
		}
		if(y < this.startY) {
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
		
		
		this.rect.add(new PaintRect (recX, recY, recW, recH, setColor()));
		
		
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
