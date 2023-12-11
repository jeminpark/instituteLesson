package basic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Horse{
	
	public final int RUN = 0;
	public final int GOAL = 1;
	
	private int num;
	private int x,y,w,h;
	
	private String fileName;
	private ImageIcon image;
	
	private int state;
	private int rank;
	
	private String record;
	
	public Horse(int num, int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images/horse%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getRecord() {
		return this.record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	
	
}
class HorsePanel extends Gui_MyUtil{
	
	Random rand = new Random();
	
	private final int SIZE = 5;
	private Horse[] horses;
	private JButton start;
	private JLabel timer;
	
	private int startX = 30;
	private int startY = 100;
	
	private int endX = 1000-120-30;
	
	private int ms;
	private boolean isRun;
	private int rank;
	
	public HorsePanel() {
		setLayout(null);
		setBounds(0,0,1000,600);
		
		setButton();
		setTimer();
		setHorse();
	}

	private void setButton() {
		this.start = new JButton();
		this.start.setBounds(10,10,100,50);
		this.start.setText("Start");
		this.start.addActionListener(this);
		add(this.start);
		
	}

	private void setTimer() {
		this.timer = new JLabel();
		this.timer.setText("Ready");
		this.timer.setBounds(110,20,100,30);
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.CENTER);
		add(this.timer);
		
	}

	private void setHorse() {
		this.horses = new Horse[SIZE];
		
		int x = startX;
		int y = startY;		
		
		for(int i=0; i<this.horses.length; i++) {
			this.horses[i] = new Horse(i+1, x,y,120,80);
			y+= 90;			
		}
		this.rank = 1;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		for(int i=0; i<this.horses.length; i++) {
			Horse h = this.horses[i];
			
			g.drawImage(h.getImage().getImage(), h.getX(), h.getY(),null);
			g.drawLine(this.startX, h.getY()+h.getH(), 1000-30, h.getY()+h.getH() );
			
			if(h.getState() == h.GOAL) {
				g.setFont(new Font("",Font.BOLD, 20));
				g.drawString(h.getRank()+" µî", this.endX-100, h.getY()+h.getH()/2);
				g.setFont(new Font("",Font.PLAIN, 10));
				g.drawString(h.getRecord(), this.endX-50, h.getY()+h.getH()/2);
			}
		}
		if(isRun) {
			try {
				Thread.sleep(50);
				horseMove();
			}
			catch(Exception e) {
				
			}
		}
		repaint();
	}

	private void horseMove() {
		boolean goal = false;
		
		for(int i=0; i<this.SIZE; i++) {
			Horse h = this.horses[i];
			int moved = rand.nextInt(10)*3;
			
			int xx = h.getX()+moved;
			
			if(h.getState() == h.RUN) {
				if(xx >= this.endX && !goal) {
					
					xx = endX;
					h.setState(h.GOAL);
					h.setRecord(String.format("%d.%03d", this.ms/1000, this.ms%1000));
					h.setRank(this.rank);
					this.rank++;
					goal = !goal;
				}
				else if(xx >= this.endX && goal) {
					i--;
					continue;
				}
				h.setX(xx);
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.start) {
				this.isRun = !this.isRun;
				this.start.setText(this.isRun ? "reset" : "start");
				
				if(!isRun) {
					resetGame(); 
				}
	 		}
		}
	}

	private void resetGame() {
		setHorse();
		this.ms = 0;
		this.rank = 1;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			if(isRun) {
				this.ms++;
				this.timer.setText(String.format("%3d.%03d",this.ms/1000, this.ms%1000));
				
			}
			try {
				Thread.sleep(1);
			}
			catch(Exception e) {
				
			}
		}
	}
}
class HorseFrame extends JFrame{
	
	private HorsePanel panel = new HorsePanel();
	
	public HorseFrame() {
		setLayout(null);
		setTitle("horse");
		setBounds(600,200,1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
		
		this.panel.run();
	}

}

public class Gui_Horse {

	public static void main(String[] args) {
		new HorseFrame();
	}
}
