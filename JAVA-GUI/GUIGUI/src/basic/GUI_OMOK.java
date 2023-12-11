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

class ResetButton extends JPanel{
	
	public JButton reset = new JButton();
	
	public ResetButton() {
		setLayout(null);
		setBounds(0,0, OmokGame.SIZE, OmokGame.SIZE);
		
		setResetButton();
	}
	private void setResetButton() {
		this.reset.setText("재시작");
		this.reset.setFont(new Font("", Font.PLAIN, 30));
		this.reset.setBounds(OmokGame.SIZE/2-150, OmokGame.SIZE/2 - 150, 300,300);
		add(this.reset);
	}
}

class Result extends JFrame{
	
	private JLabel text = new JLabel();
	
	public Result(String str) {
		setLayout(null);
		setTitle("Game Over");
		setBounds(OmokGame.dm.width/2-150, OmokGame.dm.height/2-100, 300, 200);
		
		this.text.setText(str);
		this.text.setBounds(0,0, 300, 200);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		
		add(this.text);
		
		setVisible(true);
		revalidate();
	}
}
class OmokPanel extends JPanel implements ActionListener {
	private JButton OmokMap[][];
	private final int SIZE = 10;
	private int Omok[][] = new int[SIZE][SIZE];
	private int turn = 1;
	private int win = 0;
	
	private JLabel title = new JLabel();
	private ResetButton rb = new ResetButton();
	
	
	public OmokPanel() {
		setLayout(null);
		setBounds(0,0, OmokGame.SIZE, OmokGame.SIZE);
		
		this.rb.reset.addActionListener(this);
		add(this.rb);
		this.rb.setVisible(false);
		
		
		setTitle();
		setGame();
//		setResetButton();
		
	}
	private void setTitle() {
		this.title.setText("오 목");
		this.title.setBounds(OmokGame.SIZE/2-50,0, 100,100);
		this.title.setFont(new Font("",Font.BOLD, 30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.CENTER);
		add(this.title);
	}
	private void setGame() {
		OmokMap = new JButton[this.SIZE][this.SIZE];
		
		int x = OmokGame.SIZE/2 - 50*10/2;
		int y = OmokGame.SIZE/2 - 50*10/2;
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				JButton bt = new JButton(); //변수를 바로 객체화해서 담기
				
				bt.setBounds(x,y,50,50);
				bt.setBackground(Color.orange);
				bt.addActionListener(this);
				
				this.OmokMap[i][j] = bt;
				add(this.OmokMap[i][j]);
				
				x += 50+1;
			}
			x = OmokGame.SIZE/2- 50*10/2;
			y += 50+1;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.rb.reset) {
				resetGame();
			}
			else {
				
				for(int i=0; i<this.SIZE; i++) {
					for(int j=0; j<this.SIZE; j++) {
						if(target == this.OmokMap[i][j] && this.Omok[i][j] == 0) {
							
							if(this.turn == 1) {
								target.setBackground(Color.black);
							}
							else {
								target.setBackground(Color.red);
							}
							
							this.Omok[i][j] = this.turn;
							checkWin();
							this.turn = this.turn == 1?2:1;
						}
					}
				}
				
			}
		}
		
		
	}
	private void resetGame() {
		this.Omok = new int[SIZE][SIZE];
		this.turn = 1;
		this.win = 0;
		
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE; j++) {
				this.OmokMap[i][j].setBackground(Color.orange);
			}
		}
		this.rb.setVisible(false);
	}
	private void checkWin() {
		this.win = this.win == 0? checkGaro() : this.win; // 삼항연산자 윈이 참조하는 윈이 0일때 체크가로의 숫자면 참 윈이면 거짓
		this.win = this.win == 0? checkSero() : this.win;
		this.win = this.win == 0? checkDia()  : this.win;
		this.win = this.win == 0? checkReverse() : this.win;
		
		if(this.win != 0) {
			this.rb.setVisible(true);
			new Result(String.format("p%d의 승리", this.win));
		}
		
	}
	private int checkGaro() {
		for(int i=0; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE-4; j++) {
				if(this.Omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.Omok[i][j+k] == this.turn) {
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
	private int checkSero() {
		for(int i=0; i<this.SIZE-4; i++) {
			for(int j=0; j<this.SIZE; j++) {
				if(this.Omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.Omok[i+k][j] == this.turn) {
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
				if(this.Omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.Omok[i+k][j+k] == this.turn) {
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
	private int checkReverse() {
		for(int i=4; i<this.SIZE; i++) {
			for(int j=0; j<this.SIZE-4; j++) {
				if(this.Omok[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.Omok[i-k][j+k] == this.turn) {
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
	
	private OmokPanel panel = new OmokPanel();
	
	public OmokGame() {
		setLayout(null);
		setTitle("omok");
		setBounds(dm.width/2 - SIZE/2, dm.height/2 - SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		setVisible(true);
		revalidate();
	}
}
 class GUI_OMOK {

	public static void main(String[] args) {
		OmokGame game = new OmokGame();
	}
}
