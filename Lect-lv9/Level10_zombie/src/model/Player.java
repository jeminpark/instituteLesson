package model;

import controller.Game;
import model.Unit;
import model.Zombie;

public class Player extends Unit implements Heal{
	private int cnt = 3;
	private boolean isDead;
	private int dam;
	public Player(String name, int hp, int att, int def, int position) {
		super(name, hp, att, def, position);
	}
	public int getCnt() {
		return cnt;
	}
	public void drink() {
		if(cnt > 0) {
			System.out.println("ȸ������ ���ʴϴ�.");
			System.out.println("ü���� 100ȸ�� �Ǿ����ϴ�.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
			this.cnt --;
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
	}
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing)target).getShield()> 0) {
				int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100;
				if(dam <= 0) {
					dam = 1;
				}
				System.out.println(getName()+"�� ����!");
				System.out.println(dam+"�� ������!");
				((ZombieKing)target).setShield(((ZombieKing) target).getShield()-dam);
				if(((ZombieKing)target).getShield()<= 0) {
					System.out.println(target.getName()+"�� ���尡 �ڻ쳵��!");
					((ZombieKing) target).setShield(0);
				}
				System.out.println(target.getName()+"�� ���� ü��: "+target.getHp()+" (����: "+((ZombieKing) target).getShield()+")");
			}
			else {
				super.attack(target);
			}
			
		}
		else {
			super.attack(target);
		}
	}
//	public void damage(int attack) {
//		this.setHp(this.getHp()-attack);
//		System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
//		if(this.getHp()<= 0) {
//			isDead = true;
//			System.out.println("����߽��ϴ�.");
//		}
//	}
//	public void heal() {
//		if(this.cnt > 0) {
//			System.out.println("ȸ������ ���ʴϴ�.");
//			System.out.println("ü���� 100ȸ���Ǿ����ϴ�.");
//			this.setHp(this.getHp()+100);
//			System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
//			this.cnt --;
//		}
//		else {
//			System.out.println("������ �����ϴ�.");
//		}
//		
//	}
//	@Override
//	public void attack(Unit target) {
//		if(target instanceof ZombieKing) {
//			if(((ZombieKing)target).getShield()> 0) {
//				int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100;
//				if(dam <= 0) {
//					dam = 1;
//				}
//				System.out.println(getName()+"�� ����!");
//				System.out.println(dam+"�� ������!");
//				((ZombieKing)target).setShield(((ZombieKing) target).getShield()-dam);
//				if(((ZombieKing)target).getShield()<= 0) {
//					System.out.println(target.getName()+"�� ���尡 �ڻ쳵��!");
//					((ZombieKing) target).setShield(0);
//				}
//				System.out.println(target.getName()+"�� ���� ü��: "+target.getHp()+" (����: "+((ZombieKing) target).getShield()+")");
//				
//			}
//			else {			
//				this.dam = (this.getAtt()- target.getDef())*(Game.rand.nextInt(150)+50)/100;
//				if(this.dam <= 0) {
//					this.dam = 1;
//				}
//				System.out.printf("%s�� ����!\n", this.getName());
//				System.out.printf("%d�� ������!\n", dam);
//				
//				((ZombieKing)target).damage(this.dam);				
//				
//			}			
//			
//		}
//		else {
//			this.dam = (this.getAtt()- target.getDef())*(Game.rand.nextInt(150)+50)/100;
//			if(this.dam <= 0) {
//				this.dam = 1;
//			}
//			System.out.printf("%s�� ����!\n", this.getName());
//			System.out.printf("%d�� ������!\n", dam);
//			((Zombie)target).damage(this.dam);
//		}
//		
//	}
//	@Override
//	public void damage(int attack) {
//		
//		this.setHp(this.getHp()-attack);
//		System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
//		if(this.getHp()<= 0) {
//			isDead = true;
//			System.out.println("����߽��ϴ�.");
//		}
//		
//		
//	}
	@Override
	public void heal() {
		if(this.cnt > 0) {
			System.out.println("ȸ������ ���ʴϴ�.");
			System.out.println("ü���� 100ȸ���Ǿ����ϴ�.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
			this.cnt --;
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
		
	}
	
}
