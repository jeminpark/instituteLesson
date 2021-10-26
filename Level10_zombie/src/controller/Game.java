package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Player;
import model.Unit;
import model.Zombie;
import model.ZombieKing;

public class Game {
	public static Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	public static Game instance = new Game();
	private Player p;
	private ArrayList<Unit> enemy = new ArrayList<>();
	private Game( ) {}
	
	private void init() {
		this.p = new Player("용사", 100, 5, 1, 1);
		Zombie zom = new Zombie("그냥좀비", 25, 5, 1, 3);
		this.enemy.add(zom);
		zom = new Zombie("힘쌘좀비", 45, 10, 2, 6);
		this.enemy.add(zom);
		zom = new Zombie("정예좀비", 65, 15, 3, 9);
		this.enemy.add(zom);
		this.enemy.add(new ZombieKing("좀비군주", 100, 20 , 4, 12, 50));
		
	}
	private int check() {
		for(int i=0; i<this.enemy.size(); i++) {
			if(this.p.getPosition() == this.enemy.get(i).getPosition()) {
				System.out.println("좀비가 나타났다!!");
				return i;
			}
		}
		return -1;
	}
	private int die(Unit a) {
		if(this.p.getHp()<= 0) {
			return 1;
		}
		else if(a.getHp()<= 0) {
			return 2;
		}
		else {
			return 0;
		}
	}
	private boolean fight(Unit enemy) {
		while(true) {
			this.p.print();
			System.out.println("===== VS =====");
			enemy.print();
			System.out.println("--------------");
			System.out.println("[ 무엇을 할까? ]");
			System.out.println("1.공격   2.물약("+this.p.getCnt()+"개 남음)");
			int sel = scan.nextInt();
			if(sel == 1) {
				this.p.attack(enemy);
			}
			else if(sel == 2) {
				this.p.drink();
			}
			if(die(enemy)!= 0) {
				break;
			}
			System.out.println();
			((Zombie) enemy).attack(this.p);
			if(die(enemy)!= 0) {
				break;
			}
			System.out.println();
			
		}
		if(die(enemy) == 1) {
			System.out.println("사망했다.....");
			return false;
		}
		else {
			System.out.println("승리했다!");
			return true;
		}
	}
	private void map(int a) {
		System.out.println("[현재 층: "+this.p.getPosition()+" ]");
		System.out.println("[1]: 올라간다.");
		if(a == 1) {
			System.out.println("[2]: 체력을 회복한다.");
			System.out.println("[3]: 무기를 강화한다.");
		}
	}
		
	public void run() {
		init();
		int act = 1;
		while(true) {
			if(this.p.getPosition() >= 12) {
				System.out.println("생존에 성공했다.");
				break;
			}
			map(act);
			int sel = scan.nextInt();
			if(sel == 1) {
				this.p.setPosition(this.p.getPosition()+1);
				int check = check();
				if(check != -1) {
					boolean a = fight(this.enemy.get(check));
					if(a == false) {
						break;
					}
				}
				else {
					System.out.println("아무일도 일어나지 않았다..");
				}
				act = 1;
			}
			else if(sel == 2 && act == 1) {
				int rNum = rand.nextInt(40)+20;
				this.p.setHp(this.p.getHp()+rNum);
				System.out.println("체력을 "+rNum+"만큼 회복했다!");
				act = 2;
			}
			else if(sel == 3 && act == 1) {
				int rNum = rand.nextInt(2)+1;
				if(rNum == 1) {
					rNum = rand.nextInt(3)+1;
					this.p.setAtt(this.p.getAtt()+rNum);
					System.out.println("공격력이 "+rNum+"만큼 증가했다!");
				}
				else if(rNum == 2) {
					rNum = rand.nextInt(3)+1;
					this.p.setDef(this.p.getDef()+rNum);
					System.out.println("방어력이 "+rNum+"만큼 증가했다!");
				}
				act = 2;
			}
		}
	}
}
