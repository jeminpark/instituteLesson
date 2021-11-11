package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SnakeRect {
	private int x,y,w,h;
	private Color c;
	
	public SnakeRect(int x, int y, int w, int h, Color c) {
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public int getX() {
		return x;
	}

//	public void setX(int x) {
//		this.x = x;
//	}

	public int getY() {
		return y;
	}

//	public void setY(int y) {
//		this.y = y;
//	}

	public int getW() {
		return w;
	}

//	public void setW(int w) {
//		this.w = w;
//	}

	public int getH() {
		return h;
	}

//	public void setH(int h) {
//		this.h = h;
//	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
}
class SnakeResult extends JFrame{
	
	JLabel text = new JLabel();
	
	public SnakeResult(String str) {
		setLayout(null);
		setTitle("Game Over");
		setBounds(SnakeFrame.W/2 - SnakeFrame.SIZE/2+150, SnakeFrame.H/2 - SnakeFrame.SIZE/2+150, 300,300);
		
		this.text.setText(str);
		this.text.setBounds(0,0,300,300);
		this.text.setFont(new Font("",Font.BOLD, 24));
		this.text.setHorizontalAlignment(JLabel.CENTER);
		
		add(this.text);
		setVisible(true);
		revalidate();
	}
}
class SnakePanel extends JPanel implements ActionListener, KeyListener{
	
	private JLabel title = new JLabel();
	private JButton reset;
	private JButton[] btn;
	
	private final int SIZE = 10;	
	private SnakeRect[][] map;
	
	private ArrayList<SnakeRect> snake = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> snakeYx = new ArrayList<>();
	private ArrayList<SnakeRect> items = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> itemYx = new ArrayList<>();
	
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private int dir;
	private boolean death;
	
	public SnakePanel() {
		setLayout(null);
		setBounds(0,0, SnakeFrame.SIZE, SnakeFrame.SIZE);
		
		setFocusable(true);
		addKeyListener(this);
		
		setTitle();
		setMap();
		setSnake();
		setItem();
		setButton();
		
	}
	private void setTitle() {
		this.title.setBounds(SnakeFrame.SIZE/2 +130, SnakeFrame.SIZE/2 - 300, 150,150);
		this.title.setText("SNAKE");
		this.title.setFont(new Font("",Font.BOLD, 25));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		add(this.title);
		
	}
	private void setButton() {
		this.btn = new JButton[4];
		String[] text = {"←","↓","→","↑"};
		
		int x = SnakeFrame.SIZE-200;
		int y = SnakeFrame.SIZE-200-100;
		
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setText(text[i]);
			this.btn[i].setBounds(x,y,50,50);
			this.btn[i].addActionListener(this);
			
			add(this.btn[i]);
			
			x+= 50;
			if(i == this.btn.length -1 -1) {
				x -= 100;
				y -= 50;
			}
			
		}
		this.reset = new JButton();
		this.reset.setBounds(SnakeFrame.SIZE-200, y+110,150, 50);
		this.reset.setText("RESET");
		this.reset.addActionListener(this);

		add(this.reset);
	}
	private void setItem() {
		Random rand = new Random();
		
		int rNum = rand.nextInt(this.SIZE*this.SIZE/5)+5;
		
		for(int i=0; i<rNum; i++) {
			int rY = rand.nextInt(this.SIZE);
			int rX = rand.nextInt(this.SIZE);
			
			boolean check = false;
			for(int j=0; j<this.snakeYx.size(); j++) {
				if(rY== this.snakeYx.get(j).get(0) && rX == this.snakeYx.get(j).get(1)) {
					check = true;
				}
				if(check) {
					i--;
					break;
				}
			}
			if(check ) {
				continue;
				
			}
			for(int j=0; j<this.itemYx.size(); j++) {
				if(rY == this.itemYx.get(j).get(0) && rX == this.itemYx.get(j).get(1)) {
					check = true;
				}
				if(check) {
					i--;
					break;
				}
			}
			if(!check) {
				SnakeRect t = this.map[rY][rX];
				this.items.add(new SnakeRect(t.getX()+10, t.getY()+10, 20,20, Color.green));
				
				ArrayList<Integer> yx = new ArrayList<>();
				yx.add(rY);
				yx.add(rX);
				this.itemYx.add(yx);
				System.out.println("items: "+this.items.size());
			}
			
		}
		
	}

	private void setMap() {
		this.map = new SnakeRect[this.SIZE][this.SIZE];
		
		int x = (SnakeFrame.SIZE - 200)/2 - 40*this.SIZE/2; 
		int y = (SnakeFrame.SIZE - 200)/2 - 40*this.SIZE/2;
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				this.map[i][j] = new SnakeRect(x,y,40,40,Color.gray);
				
				x+= 40;
			}
			x = (SnakeFrame.SIZE -200)/2 - 40*this.SIZE/2;
			y+= 40;
		}
		
	}

	private void setSnake() {
		for(int i=0; i<4; i++) {
			SnakeRect t = this.map[0][i];
			
			Color c = Color.orange;
			
			if(i == 0) {
				c = Color.pink;
			}
			this.snake.add(new SnakeRect(t.getX(), t.getY(), t.getW(), t.getH(), c));
			
			ArrayList<Integer> yx = new ArrayList<>();
			yx.add(0);
			yx.add(i);
			this.snakeYx.add(yx);
			
		}
		
		
	}
	public void snakeMove() {
		int yy = this.snakeYx.get(0).get(0);
		int xx = this.snakeYx.get(0).get(1);
		
		if(this.dir == LEFT) {
			xx--;
		}
		else if(this.dir == DOWN) {
			yy++;
		}
		else if(this.dir == RIGHT) {
			xx++;
		}
		else if(this.dir == UP) {
			yy--;
		}
		if(xx < 0 || xx >= this.SIZE || yy < 0 || yy >= this.SIZE) {
			return;
		}
		for(int i=0; i<this.snakeYx.size(); i++) {
			if(this.snakeYx.get(i).get(0) == yy && this.snakeYx.get(i).get(1) == xx) {
				this.death = true;
				checkResult();
			}
		}
		
		boolean bigger = false;
		for(int i=0; i<this.itemYx.size(); i++) {
			
			if(yy == this.itemYx.get(i).get(0) && xx == this.itemYx.get(i).get(1)) {
				bigger = true;
				this.items.remove(i);
				this.itemYx.remove(i);
			}
		}
		if(!this.death) {
			SnakeRect tail = this.snake.get(this.snake.size()-1);
			ArrayList<Integer> tailYx = this.snakeYx.get(this.snakeYx.size()-1);
			
			for(int i = this.snake.size()-1; i>0; i--) {
				SnakeRect temp = this.snake.get(i-1);
				temp.setC(Color.orange);
				this.snake.set(i, temp);
				
				ArrayList<Integer> yx = this.snakeYx.get(i-1);
				this.snakeYx.set(i, yx);
			}
			SnakeRect t = this.map[yy][xx];
			this.snake.set(0, new SnakeRect(t.getX(), t.getY(), t.getW(), t.getH(), Color.pink));
			ArrayList<Integer> yx = new ArrayList<>();
			yx.add(yy);
			yx.add(xx);
			this.snakeYx.set(0, yx);
			
			if(bigger) {
				this.snake.add(tail);
				this.snakeYx.add(tailYx);
			}
			
		}
		if(this.items.size() == 0) {
			checkResult();
		}
	}
	public void checkResult() {
		if(this.items.size() == 0) {
			new SnakeResult("게임 성공");
		}
		else if(this.death) {
			new SnakeResult("게임 오버");
		}
		
	}
	public void resetGame() {
		
		this.death = false;
		
		this.snake = new ArrayList<>();
		this.snakeYx = new ArrayList<>();
		this.items = new ArrayList<>();
		this.itemYx = new ArrayList<>();
		
		setMap();
		setSnake();
		setItem();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//snake
		for(int i=0; i<this.snake.size(); i++) {
			SnakeRect r = this.snake.get(i);
			Color c = r.getC();
			if(this.death) {
				c = Color.red;
			}
			
			g.setColor(c);
			g.fillRect(r.getX(), r.getY(), r.getW(), r.getH());
		}
		//items
		for(int i=0; i<this.items.size(); i++) {
			SnakeRect r = this.items.get(i);
			
			g.setColor(r.getC());
			g.fillRoundRect(r.getX(), r.getY(), r.getW(), r.getH(), r.getW(), r.getH());
		}
		
		//map
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				SnakeRect r = this.map[i][j];
				
				g.setColor(r.getC());
				g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
				
			}
		}
		requestFocusInWindow();
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
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
		snakeMove();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.reset) {
				resetGame();
			}
			else {
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
				snakeMove();
			}
		}
		
	}
}
class SnakeFrame extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	public static final int SIZE = 700;
	
	private SnakePanel panel = new SnakePanel();
	
	public SnakeFrame() {
		setLayout(null);
		setTitle("snake");
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
		
	}
}
public class Gui_Snake {

	public static void main(String[] args) {
		SnakeFrame snake = new SnakeFrame();
	}
}
