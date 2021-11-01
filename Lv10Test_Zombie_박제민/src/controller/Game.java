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
		this.p = new Player("용사", 100, 5, 1, 1);
		this.enemy.add(new Zombie("일반좀비", 40, 5, 1, 3));
		this.enemy.add(new Zombie("힘쌘좀비", 60, 10, 3, 6));
		this.enemy.add(new Zombie("강한좀비", 80, 15, 5, 9));
		this.enemy.add(new ZombieKing("좀비왕", 100, 20, 10, 12, 50));
	}
	
	
	public void map(int act) {
		System.out.println("현재층: "+this.p.getPosition());
		System.out.println("[1] 올라간다.");
		if(act == 1) {
			System.out.println("[2] 체력을 회복한다.");
			System.out.println("[3] 무기를 강화한다.");
		}
	}
	public int check() {
		for(int i=0; i<this.enemy.size(); i++) {
			if(this.enemy.get(i).getPosition() == this.p.getPosition()) {
				System.out.println("좀비와 마주쳤다.");
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
			System.out.println("무엇을 할까?");
			System.out.println("1.공격 2.물약 "+this.p.getPotion()+"개 남음.");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				this.p.attack(enemy);
			}
			else if(sel == 2) {
				this.p.Heal();
				
			}
			enemy.attack(this.p);
			if(die(enemy) != 0) {
				break;
			}
			System.out.println();			
		}
		if(die(enemy) == 1) {
			System.out.println("-------- 플레이어 사망.. ---------");
			return false;
			
		}
		else if(die(enemy) == 2) {
			System.out.println("-------- "+enemy.getName()+"를 해치웠다.--------");
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
			
			map(act);
			int sel = scan.nextInt();
			
			if(sel == 1) {
				this.p.setPosition(this.p.getPosition()+1);
				//check
				int check = check();
				if(check != -1) {
					//싸움이 일어나야함.
					boolean battleRun = true;
					battleRun = battle(this.enemy.get(check));
					if(battleRun == false) {
						break;
					}
				}
				else {
					System.out.println("아무일도 일어나지 않았다.");
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
