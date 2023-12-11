package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Player;
import model.Unit;
import model.Zombie;
import model.ZombieKing;

public class Game {
	
	Scanner scan = new Scanner(System.in);
	public static Game instance = new Game();
	private Player p;
	private ArrayList<Unit> enemy = new ArrayList<>();
	
	public void setGame() {
		this.p = new Player("���", 100, 5, 1, 1);
		this.enemy.add(new Zombie("�Ϲ�����", 40, 5, 1, 3));
		this.enemy.add(new Zombie("��������", 60, 10, 3, 6));
		this.enemy.add(new Zombie("��������", 80, 15, 5, 9));
		this.enemy.add(new ZombieKing("�����", 100, 20, 10, 12, 50));
	}
	
	
	public void map(int act) {
		System.out.println("������: "+this.p.getPosition());
		System.out.println("[1] �ö󰣴�.");
		if(act == 1) {
			System.out.println("[2] ü���� ȸ���Ѵ�.");
			System.out.println("[3] ���⸦ ��ȭ�Ѵ�.");
		}
	}
	public int check() {
		for(int i=0; i<this.enemy.size(); i++) {
			if(this.enemy.get(i).getPosition() == this.p.getPosition()) {
				System.out.println("����� �����ƴ�.");
				return i;
			}
		}
		return -1;
	}
	public boolean battle(Unit enemy) {
		
		while(true) {
			
			this.p.printData();
			System.out.println("===== VS =====");
			enemy.printData();
			System.out.println("������ �ұ�?");
			System.out.println("1.���� 2.���� "+this.p.getPotion()+"�� ����.");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				this.p.attack(enemy);
			}
			else if(sel == 2) {
				this.p.Heal();
				
			}
			System.out.println();
			enemy.attack(this.p);
			if(die(enemy) != 0) {
				break;
			}
			System.out.println();			
		}
		if(die(enemy) == 1) {
			System.out.println("-------- �÷��̾� ���.. ---------");
			return false;
			
		}
		else if(die(enemy) == 2) {
			System.out.println("-------- "+enemy.getName()+"�� ��ġ����.--------");
			return true;
		}
		return true;
	}
	private int die(Unit unit) {
		if(this.p.getHp() <= 0) {
			return 1;
		}
		else if(unit.getHp() <= 0) {
			return 2;
		}
		else {
			return 0;
		}
		
	}
	
	public void run() {
		setGame();
		int act = 1;			
		while(true) {
			if(this.p.getPosition() >= 12) {
				System.out.println("������ �����ߴ�.");
				break;
			}
			map(act);
			int sel = scan.nextInt();
			
			if(sel == 1) {
				this.p.setPosition(this.p.getPosition()+1);
				//check
				int check = check();
				if(check != -1) {
					
					boolean battleRun = true;
					battleRun = battle(this.enemy.get(check));
					if(battleRun == false) {
						break;
					}
				}
				else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�.");
					act = 1;
				}
				
			}
			else if(sel == 2 && act == 1) {
				this.p.Heal();
				act = 2;
			}
			else if(sel == 3 && act == 1) {
				this.p.upgrade();
				act = 2;
			}
		}
	}
	
	
	
}
