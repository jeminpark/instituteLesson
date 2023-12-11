package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class OmokRect{
	private int x, y, w, h, owner;
	private Color c;
	public OmokRect(int x, int y, int w, int h, Color c) {
		
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
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
	
}
class ButtonReset extends JPanel{
	public JButton reset = new JButton();
	
	public ButtonReset() {
		setLayout(null);
		setBounds(10,10, 100, 30);
		
		setResetButton();
	}

	private void setResetButton() {
		this.reset.setText("RESET");
		this.reset.setFont(new Font("",Font.BOLD, 10));
		this.reset.setBounds(0,0,100,30);
		add(this.reset);
		
	}
	
}
class OmokResult extends JFrame{
	
	private JLabel text = new JLabel();
	
	public OmokResult(String str) {
		setLayout(null);
		setTitle("OmokResult");
		setBounds(OmokFrame.W/2-OmokFrame.SIZE/2+100, OmokFrame.H/2-OmokFrame.SIZE/2+100,300, 200);
		
		this.text.setBounds(0,0,200,200);
		this.text.setText(str);
		this.text.setFont(new Font("",Font.BOLD,30));
		this.text.setHorizontalAlignment(JLabel.CENTER);
		setVisible(true);
		add(this.text);
		
		
	}
}
class OmokGamePanel extends JPanel implements MouseListener, ActionListener{
	
	private final int SIZE = 10;
	private OmokRect[][] omokMap = null;
	private int turn = 1;
	private int win = 0;
	
	private Color p1 = Color.black;
	private Color p2 = Color.white;
	
	private JLabel title = new JLabel();
	private ButtonReset rb = new ButtonReset();
	
	public OmokGamePanel() {
		setLayout(null);
		setBounds(0,0, OmokFrame.SIZE, OmokFrame.SIZE);
		
		this.rb.reset.addActionListener(this);
		add(this.rb);
		this.rb.reset.setVisible(true);
		setTitle();
		setMap();
		addMouseListener(this);
		
	}

	private void setTitle() {
		this.title.setText("오 목");
		this.title.setBounds(300, 0 ,100,100);
		this.title.setFont(new Font("",Font.BOLD, 30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		add(this.title);
		
	}

	private void setMap() {
		this.omokMap = new OmokRect[SIZE][SIZE];
		
		int x = OmokFrame.SIZE/2 - 50*10/2;
		int y = OmokFrame.SIZE/2 - 50*10/2;
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				this.omokMap[i][j] = new OmokRect(x,y,50,50,Color.orange);
				
				x+= 50;
			}
			x = OmokFrame.SIZE/2 - 50*10/2;
			y+= 50;
		}
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//map그리기
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				OmokRect r = this.omokMap[i][j];
				
				g.drawRect(r.getX()-25, r.getY()-25, r.getW(), r.getH());
				
				if( i == SIZE-1) {
					g.drawRect(r.getX()-25, r.getY()-25+50, r.getW(), r.getH());
				}
				if( j == SIZE -1) {
					g.drawRect(r.getX()-25+50, r.getY()-25, r.getW(), r.getH());
				}
				if( i == SIZE -1 && j == SIZE -1) {
					g.drawRect(r.getX()-25+50, r.getY()-25+50, r.getW(), r.getH());
				}
			}
		}
		
		//stone 그리기
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				
				OmokRect r = this.omokMap[i][j];
				if(r.getOwner() != 0) {
					g.setColor(Color.black);
					g.drawRoundRect(r.getX()+5, r.getY()+5, r.getW()-10, r.getH()-10, r.getW(), r.getH());
					g.setColor(r.getC());
					g.fillRoundRect(r.getX()+5, r.getY()+5, r.getW()-10, r.getH()-10, r.getW(), r.getH());
				}
			}
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				OmokRect r = this.omokMap[i][j];
				
				if(x >= r.getX() && x < r.getX()+r.getW() && y >= r.getY() && y < r.getY()+r.getH()) {
					if(r.getOwner() == 0) {
						r.setOwner(this.turn);
						r.setC(this.turn == 1 ? this.p1 : this.p2);
						
						checkWin();
						this.turn = this.turn == 1? 2: 1;
					}
				}
			}
		}
		
	}

	private void checkWin() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win != 0) {
			System.out.printf("p%d win!\n", this.win);
			new OmokResult(String.format("p%d win", this.win));
		}
		
	}
	private int checkReverse() {
		for(int i=4; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE-4; j++) {
				OmokRect r = this.omokMap[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.omokMap[i-k][j+k].getOwner() == this.turn) {
							cnt++;
						}
					}
					if(cnt == 5) {
						return this.turn;
					}
				}
			}
		}
		return 0;
	}

	private int checkDia() {
		for(int i=0; i<this.SIZE-4; i++) {
			for(int j=0; j<this.SIZE-4; j++) {
				OmokRect r = this.omokMap[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.omokMap[i+k][j+k].getOwner() == this.turn) {
							cnt++;
						}
					}
					if(cnt == 5) {
						return this.turn;
					}
				}
			}
		}
		return 0;
	}

	private int checkVerti() {
		for(int i=0; i<this.SIZE-4; i++) {
			for(int j=0; j<this.SIZE; j++) {
				OmokRect r = this.omokMap[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.omokMap[i+k][j].getOwner() == this.turn) {
							cnt++;
						}
					}
					if(cnt == 5) {
						return this.turn;
					}
				}
			}
		}
		return 0;
	}

	private int checkHori() {
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE-4; j++) {
				OmokRect r = this.omokMap[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k= 0; k<5; k++) {
						if(this.omokMap[i][j+k].getOwner() == this.turn) {
							cnt++;
						}
					}
					if(cnt == 5) {
						return this.turn;
					}
				}
			}
		}
		return 0;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.rb.reset) {
				resetGame();
			}
		}
		
	}

	private void resetGame() {
		this.turn = 1;
		this.win = 0;
		setMap();
		
	}
	
}
class OmokFrame extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	public static final int SIZE = 700;
	
	private OmokGamePanel panel = new OmokGamePanel();
	
	public OmokFrame() {
		setLayout(null);
		setTitle("omok");
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		setVisible(true);
		revalidate();
	}
}
public class Gui_Omok2 {

	public static void main(String[] args) {
		OmokFrame omok = new OmokFrame();
	}
}
