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
			System.out.println("회복약을 마십니다.");
			System.out.println("체력이 100회복 되었습니다.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"의 남은체력: "+this.getHp());
			this.cnt --;
		}
		else {
			System.out.println("물약이 없습니다.");
		}
	}
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing)target).getShield()> 0) {
				int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100;
				if(dam <= 0) {
					dam = 1;
				}
				System.out.println(getName()+"의 공격!");
				System.out.println(dam+"의 데미지!");
				((ZombieKing)target).setShield(((ZombieKing) target).getShield()-dam);
				if(((ZombieKing)target).getShield()<= 0) {
					System.out.println(target.getName()+"의 쉴드가 박살났다!");
					((ZombieKing) target).setShield(0);
				}
				System.out.println(target.getName()+"의 남은 체력: "+target.getHp()+" (쉴드: "+((ZombieKing) target).getShield()+")");
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
//		System.out.println(this.getName()+"의 남은체력: "+this.getHp());
//		if(this.getHp()<= 0) {
//			isDead = true;
//			System.out.println("사망했습니다.");
//		}
//	}
//	public void heal() {
//		if(this.cnt > 0) {
//			System.out.println("회복약을 마십니다.");
//			System.out.println("체력이 100회복되었습니다.");
//			this.setHp(this.getHp()+100);
//			System.out.println(this.getName()+"의 남은체력: "+this.getHp());
//			this.cnt --;
//		}
//		else {
//			System.out.println("물약이 없습니다.");
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
//				System.out.println(getName()+"의 공격!");
//				System.out.println(dam+"의 데미지!");
//				((ZombieKing)target).setShield(((ZombieKing) target).getShield()-dam);
//				if(((ZombieKing)target).getShield()<= 0) {
//					System.out.println(target.getName()+"의 쉴드가 박살났다!");
//					((ZombieKing) target).setShield(0);
//				}
//				System.out.println(target.getName()+"의 남은 체력: "+target.getHp()+" (쉴드: "+((ZombieKing) target).getShield()+")");
//				
//			}
//			else {			
//				this.dam = (this.getAtt()- target.getDef())*(Game.rand.nextInt(150)+50)/100;
//				if(this.dam <= 0) {
//					this.dam = 1;
//				}
//				System.out.printf("%s의 공격!\n", this.getName());
//				System.out.printf("%d의 데미지!\n", dam);
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
//			System.out.printf("%s의 공격!\n", this.getName());
//			System.out.printf("%d의 데미지!\n", dam);
//			((Zombie)target).damage(this.dam);
//		}
//		
//	}
//	@Override
//	public void damage(int attack) {
//		
//		this.setHp(this.getHp()-attack);
//		System.out.println(this.getName()+"의 남은체력: "+this.getHp());
//		if(this.getHp()<= 0) {
//			isDead = true;
//			System.out.println("사망했습니다.");
//		}
//		
//		
//	}
	@Override
	public void heal() {
		if(this.cnt > 0) {
			System.out.println("회복약을 마십니다.");
			System.out.println("체력이 100회복되었습니다.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"의 남은체력: "+this.getHp());
			this.cnt --;
		}
		else {
			System.out.println("물약이 없습니다.");
		}
		
	}
	
}
