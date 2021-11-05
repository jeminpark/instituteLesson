package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ResultOmok extends JFrame{
	
	private JLabel text = new JLabel();
	
	public ResultOmok(String winText) {
		super("GAME OVER");
		setLayout(null);
		setBounds(OmokGame.width/2-300/2, OmokGame.height/2-200/2, 300,300 );
		
		this.text.setBounds(0,0,300,200);
		this.text.setText(winText);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		
		setVisible(true);
		revalidate();
		
	}

	
}


class OmokPanel extends JPanel implements ActionListener{
	private JLabel title = new JLabel();
	private JButton reset;
	
	private JButton omokMap[][];
	private int omok[][];
	private int turn = 1;
	private final int MAP_SIZE = 10;
	private int win = 0;
	
	public OmokPanel() {
		setLayout(null);
		setBounds(0,0, OmokGame.SIZE, OmokGame.SIZE);
		
		setResetButton();
		this.reset.setVisible(false);
		setTitle();
		setData();
		setMap();
		
	}
	private void setResetButton() {
		this.reset = new JButton();
		this.reset.setText("재시작");
		this.reset.setBounds(OmokGame.SIZE/2-50, 610, 100,30);
		this.reset.setBackground(new Color(178, 234, 112));
		this.reset.setFont(new Font("",Font.BOLD, 20));
		this.reset.addActionListener(this);
		add(this.reset);
		
	}
	private void setTitle() {
		this.title.setText("오 목");
		this.title.setBounds(OmokGame.SIZE/2-70,0,100,100);
		this.title.setFont(new Font("",Font.BOLD, 30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.CENTER);
		add(this.title);
		
	}
	private void setData() {
		this.omok = new int[MAP_SIZE][MAP_SIZE];
		
		for(int i=0; i<this.MAP_SIZE; i++) {
			for(int j=0; j<this.MAP_SIZE; j++) {
				
			}
		}
	}
	private void setMap() {
		this.omokMap = new JButton[MAP_SIZE][MAP_SIZE];
		
		int x = OmokGame.SIZE/2 - 50*10/2;
		int y = OmokGame.SIZE/2 - 50*10/2;
		
		for(int i=0; i<this.MAP_SIZE; i++) {
			for(int j=0; j<this.MAP_SIZE; j++) {
				this.omokMap[i][j] = new JButton();
				this.omokMap[i][j].setBounds(x,y,50,50);
				this.omokMap[i][j].setBackground(new Color(251,209,72));
				this.omokMap[i][j].addActionListener(this);
				add(this.omokMap[i][j]);
				
				x += 50+1;
				
			}
			x = OmokGame.SIZE/2 - 50*10/2;;
			y += 50+1;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton)e.getSource();
		
		if(target == this.reset) {
			resetGame();
		}
		else {
			
			for(int i=0; i<this.MAP_SIZE; i++) {
				for(int j=0; j<this.MAP_SIZE; j++) {
					
					if(target == this.omokMap[i][j] && this.omok[i][j] == 0) {
						
						if(this.turn == 1) {
							target.setBackground(Color.BLACK);
						}
						else if(this.turn == 2) {
							target.setBackground(Color.RED);
						}
						
						this.omok[i][j] = this.turn;
						
						checkWin();
						
						this.turn = this.turn == 1?2:1;
					}
				}
			}
		}
		
	}
	private void resetGame() {
		this.turn = 1;
		this.win = 0;
		this.omok = new int[MAP_SIZE][MAP_SIZE];
		
		for(int i=0; i<this.MAP_SIZE; i++) {
			for(int j=0; j<this.MAP_SIZE; j++) {
				this.omokMap[i][j].setBackground(new Color(251,209,72));
			}
		}
		this.reset.setVisible(false);
	}
	private void checkWin() {
		
		this.win = this.win == 0 ? checkGaro() : this.win;
		this.win = this.win == 0 ? checkSero() : this.win;
		this.win = this.win == 0 ? checkLeftCross() : this.win;
		this.win = this.win == 0 ? checkRightCross() : this.win;
		
		if(this.win != 0) {
			System.out.printf("p%d의 승리!\n", this.win);
			new ResultOmok(String.format("p%d의 승리\n",  this.win));
			this.reset.setVisible(true);
		}
	}
	
	private int checkGaro() {
		for(int i=0; i<this.MAP_SIZE; i++) {
		
			for(int j=0; j<this.MAP_SIZE-4; j++) {
				if(this.turn == this.omok[i][j]) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						
						if(this.omok[i][j+k] == this.turn) {
							cnt ++;					
							
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
	private int checkSero() {
		for(int i=0; i<this.MAP_SIZE-4; i++) {
			
			for(int j=0; j<this.MAP_SIZE; j++) {
				if(this.omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.omok[i+k][j] == this.turn) {
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
	private int checkLeftCross() {
		for(int i=0; i<this.MAP_SIZE-4; i++) {
			for(int j=0; j<this.MAP_SIZE-4; j++) {
				if(this.omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.omok[i+k][j+k] == this.turn) {
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
	private int checkRightCross() {
		for(int i=4; i<this.MAP_SIZE; i++) {
			for(int j=0; j<this.MAP_SIZE-4; j++) {
				if(this.omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.omok[i-k][j+k] == this.turn) {
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
}

class OmokGame extends JFrame{
	
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;
	public static final int SIZE = 700;
	
	private OmokPanel Omok = new OmokPanel();
	
	public OmokGame() {
		setLayout(null);
		setTitle("Omok");
		setBounds(dm.width/2-SIZE/2, dm.height/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.Omok);
		setVisible(true);
		revalidate();
		
		
		
	}
}
public class GUI_Omok {

	public static void main(String[] args) {
		OmokGame og = new OmokGame();
	}
}
