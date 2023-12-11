
package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class EndLabel extends JFrame{
	
	private JLabel text = new JLabel();
	
	public EndLabel(int ms) {
		setLayout(null);
		setTitle("게임성공");
		setBounds(500,500,300,200);
		
		this.text.setText(String.format("성적: %5d.%3d 소요", ms/1000, ms%1000));
		this.text.setBounds(0,0,300,200);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		
		setVisible(true);
	}
}


class One50 extends JPanel implements ActionListener, Runnable{
	Random rand = new Random();
	
	private JLabel title = new JLabel("1 to 50");
	private JLabel timer = new JLabel();
	
	private JButton printMap[][];
	private int front[][];
	private int back[][];
	private final int BOX = 5;
	private int gameNum = 1;
	private boolean timeRun;
	private int ms;
	
	private JButton reset = new JButton();
	
	public One50() {
		
		setLayout(null);
		setBounds(0,0, CGame.SIZE, CGame.SIZE);
		setBackground(new Color(237, 237, 237));	
		
		setTitle();
		setTimer();
		setData();
		setGame();
		setResetButton();
		
		
	}
	private void setResetButton() {
		this.reset.setText("다시 시작");
		this.reset.setBounds(500, 20, 100, 30);
		this.reset.setBackground(Color.cyan);
		this.reset.addActionListener(this);
		add(this.reset);
	}
	private void setTimer() {
		
		this.timer.setText("Ready");
		this.timer.setBounds(0,0,100,150);
		this.timer.setFont(new Font("",Font.BOLD, 20));
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.BOTTOM);
		add(this.timer);
		
	}
	private void setTitle() {
		this.title.setBounds(0,0, CGame.SIZE , 150);
		this.title.setFont(new Font("",Font.BOLD, 40));
		
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.TOP);
		
		add(this.title);
		
	}
	private void setData() {
		this.front = new int[BOX][BOX];
		this.back = new int[BOX][BOX];
		
		int n = 1;
		// 1~ 25 넣고 섞기
		for(int i=0; i<this.front.length; i++) {
			for(int j=0; j<this.front[i].length; j++) {
			
				this.front[i][j] = n;
				
				n++;
				if(i == n) {
					n*=5;
				}
				
			}
			
		}
				
		
		//26~50 넣고 섞기
		n = 26;
		for(int i=0; i<this.back.length; i++) {
			for(int j=0; j<this.back[i].length; j++) {
				
				this.back[i][j] = n;
		
				
				n++;
				if(i%5 == 5) {
					n++;
				}
				
			}
			
		}
		shuffle();
	}
	private void setGame() {
		this.printMap = new JButton[BOX][BOX];
			
		
		int x = CGame.SIZE/2 - 100*5/2;
		int y = CGame.SIZE/2 - 100*5/2;
		
		
		
		for(int i=0; i<this.printMap.length; i++) {
			for(int j=0; j<this.printMap[i].length; j++) {
				this.printMap[i][j] = new JButton();
				this.printMap[i][j].setBounds(x,y, 100, 100);
				this.printMap[i][j].setBackground(new Color(108, 74, 74));
				this.printMap[i][j].setForeground(Color.MAGENTA);
				this.printMap[i][j].addActionListener(this);
				this.printMap[i][j].setText(this.front[i][j]+"");
				this.printMap[i][j].setFont(new Font("",Font.BOLD,24));
				
				System.out.println(this.front[i][j]);
				add(this.printMap[i][j]);
				
				x+= 100+5;
				if(j%5 == 4) {
					x = CGame.SIZE/2 - 100*5/2;
					y += 100+5;
				}
			}
		}
	}
	public void shuffle() {
		for(int i=0; i<1000; i++) {
			int rIdx1 = rand.nextInt(this.front.length);
			int rIdx2 = rand.nextInt(this.front.length);
			
			int temp = this.front[0][0];
			this.front[0][0] = this.front[rIdx1][rIdx2];
			this.front[rIdx1][rIdx2] = temp;
			
			rIdx1 = rand.nextInt(this.back.length);
			rIdx2 = rand.nextInt(this.back.length);
			
			temp = this.back[0][0];
			this.back[0][0] = this.back[rIdx1][rIdx2];
			this.back[rIdx1][rIdx2] = temp;
							
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		
		if(target == this.reset) {
//			System.out.println("reset");
			resetGame();
		}
		else {
			
			for(int i=0; i<this.printMap.length; i++) {
				for(int j=0; j<this.printMap[i].length; j++) {
					
					if(target == this.printMap[i][j] && this.gameNum == this.front[i][j]) {
						
						if(!timeRun) {
							this.timeRun = true;
						}
						this.printMap[i][j].setText(this.back[i][j]+"");
						this.printMap[i][j].setBackground(new Color(221, 190, 190));
						this.gameNum ++;
					}
					else if(target == this.printMap[i][j] && this.gameNum == this.back[i][j]) {
//					this.front[i][j].
						this.gameNum ++;
						this.printMap[i][j].setBackground(null);				
						this.printMap[i][j].setText("");
						this.printMap[i][j].setVisible(false);
						
						
					}
					this.timeRun = checkWin();
					if(!timeRun) {
						new EndLabel(this.ms);
					}
					
				}
			}
		}
		
				
	}
	private void resetGame() {
		this.timeRun = false;
		
		this.ms = 0;
		this.timer.setText("START");
		this.gameNum = 1;
		setData();
		
		for(int i=0; i<this.printMap.length; i++) {
			for(int j=0; j<this.printMap[i].length; j++) {
				this.printMap[i][j].setText(this.front[i][j]+"");
				this.printMap[i][j].setBackground(new Color(108, 74, 74));
				this.printMap[i][j].setForeground(Color.MAGENTA);
				this.printMap[i][j].setVisible(true);
			}
		}
	}
	private boolean checkWin() {
		if(this.gameNum > 50) {
			return false;
			
		}
		else {
			return true;
		}
	}
	@Override
	public void run() {
		
		
		while(true) {
			if(timeRun) {
				this.ms++;
				this.timer.setText(String.format("%4d.%3d", this.ms/1000, this.ms%1000));			
			}
			
			
			
			try {
				Thread.sleep(1);
			}
			catch(Exception e) {
				
			}
		}
		
	}
	
}

class CGame extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;
	public static final int SIZE = 700;
	
//	private JLabel timer = new JLabel();
//	private JPanel bgd = new JPanel();
	
	private One50 game = new One50();
	
	public CGame() {
		setLayout(null);
		setTitle("1to50 ");
		setBounds(width/2 - SIZE/2, height/2- SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		
//		backgroundColor();
		
		add(this.game);		//그냥 객체상태를 add하면 시간초가 안불러짐. 반드시 변수에 객체를담고 add할것.
		
		setVisible(true);
		revalidate();
		
		game.run();
	}
	
	
//	public void backgroundColor() {
//		this.bgd.setBounds(0,0,SIZE, SIZE);
//		this.bgd.setBackground(new Color(237,237,237));
//		add(this.bgd);
//	}
	
	
}


public class GUI_1to50 {
	public static void main(String[] args) {
		CGame onefive = new CGame();
		
		
	}

}
