package basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class LoginAccFrame extends JFrame{
	
	
	
	public LoginAccFrame() {
		setLayout(null);
		setTitle("로그인");
		setBounds(600,200,500,500);
		setVisible(true);
		revalidate();
	}
	
}
class JoinAccPanel extends Gui_MyUtil{
	JLabel id;
	JLabel pw;
	JLabel name;
	
	JTextField idField;
	JTextField pwField;
	JTextField nameField;
	
	JButton login;
	
	public JoinAccPanel() {
		setLayout(null);
		setBounds(0,0,500,500);
		
		setText();
		setTextField();
		setButton();
	}

	private void setText() {
		this.id = new JLabel();
		this.pw = new JLabel();
		this.name = new JLabel();
		
		this.id.setText("id");
		this.id.setBounds(30,50,60,50);
		add(id);
		this.pw.setText("pw");
		this.pw.setBounds(30,110,60,50);
		add(pw);
		this.name.setText("name");
		this.name.setBounds(30,170, 60,50);
		add(name);
		
		
	}

	private void setTextField() {
		this.idField = new JTextField();
		this.pwField = new JTextField();
		this.nameField = new JTextField();
		
		this.idField.setBounds(90,50,150,50);
		add(idField);
		this.pwField.setBounds(90,110,150,50);
		add(pwField);
		this.nameField.setBounds(90,180,150,50);
		add(nameField);
	}

	private void setButton() {
		
		this.login = new JButton();
		
		this.login.setText("로그인");
		this.login.setBounds(200,300,150,100);
		add(login);
		
	}
}
class JoinAccFrame extends JFrame implements ActionListener, KeyListener{
	
	JoinAccPanel panel = new JoinAccPanel();
	
	public JoinAccFrame() {
		setLayout(null);
		setTitle("회원가입");
		setBounds(600,200,500,500);
		
		add(panel);
		
		this.panel.idField.setFocusable(true);
		this.panel.idField.addKeyListener(this);
		this.panel.pwField.setFocusable(true);
		this.panel.pwField.addKeyListener(this);
		this.panel.nameField.setFocusable(true);
		this.panel.nameField.addKeyListener(this);
		this.panel.login.addActionListener(this);
		setVisible(true);
		revalidate();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object target = e.getSource();
		
		if(e.getKeyCode() == e.VK_ENTER) {
			
			if(target == this.panel.idField || target == this.panel.pwField || target == this.panel.nameField ) {
				checkEmpty();
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.panel.idField.setFocusable(true);
		this.panel.idField.addKeyListener(this);
		this.panel.pwField.setFocusable(true);
		this.panel.pwField.addKeyListener(this);
		this.panel.nameField.setFocusable(true);
		this.panel.nameField.addKeyListener(this);
		
		this.panel.login.addActionListener(this);
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.panel.login) {
				
				checkEmpty();
			}
		}
		
	}

	private void checkEmpty() {
		String id = this.panel.idField.getText();
		String pw = this.panel.pwField.getText();
		String name = this.panel.nameField.getText();
		
		if(!id.equals("") && !pw.equals("") && !name.equals("")) {
			
			JoinUser(id,pw,name);
		}
		
	}

	private void JoinUser(String id, String pw, String name) {
		
		boolean check = checkUserId(id);
		
		if(!check) {
			Vector<String> user = new Vector<>();
			user.add(id);
			user.add(pw);
			user.add(name);
			AccPanel.users.add(user);
			
			JOptionPane.showMessageDialog(null, "회원가입성공");
			
			for(int i=0; i<AccPanel.users.size(); i++) {
				System.out.printf("%d) id: %s / pw: %s / name: %s \n",i+1, AccPanel.users.get(i).get(0),AccPanel.users.get(i).get(1),AccPanel.users.get(i).get(2));
			}
			System.out.println("-----------------");
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
		}
		
	}

	private boolean checkUserId(String id) {
		for(int i=0; i<AccPanel.users.size(); i++) {
			if(AccPanel.users.get(i).get(0).equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
}
class AccPanel extends Gui_MyUtil{
	
	private JButton login;
	private JButton join;
	
	private JoinAccFrame joinFrame;
	private LoginAccFrame loginFrame;
	
	public static Vector<Vector<String>> users = new Vector<>();
	
	public AccPanel() {
		setLayout(null);
		setBounds(0,0,700,700);
	
		setButtons();
	}

	private void setButtons() {
		this.login = new JButton();
		this.join = new JButton();
		
		this.login.setBounds(150,100,150,150);
		this.login.setText("로그인");
		this.login.addActionListener(this);
		add(this.login);
		
		this.join.setBounds(350,100,150,150);
		this.join.setText("회원가입");
		this.join.addActionListener(this);
		add(this.join);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.login) {
				
			}
			else if(target == this.join) {
				this.joinFrame = new JoinAccFrame();
			}
			
		}
		
	}
}
class AccFrame extends JFrame{
	
	private AccPanel panel = new AccPanel();
	
	public AccFrame() {
		setLayout(null);
		setTitle("login");
		setBounds(600,200,700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		setVisible(true);
		revalidate();
	}
}
public class Gui_SignUp {

	public static void main(String[] args) {
		new AccFrame();
	}
}
