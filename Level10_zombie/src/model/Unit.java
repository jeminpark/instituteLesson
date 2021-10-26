package model;

import java.util.Random;

interface Damageable{
	public void damage(int attack);
}
interface Attack{
	public void attack(Unit target);
}
interface Heal{
	public void heal();
}

public abstract class Unit {
	Random rand = new Random();
	private String name;
	private int hp;
	private int att;
	private int def;
	private int position;
	
	public String getName() {
		return this.name;
		
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtt() {
		return this.att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPosition() {
		return this.position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Unit(String name, int hp, int att, int def, int position) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.position = position;
	}
//	public void attack(Unit target) {
//		int dam = (this.att - target.def)*(rand.nextInt(150)+50)/100;
//		if(dam <= 0) {
//			dam = 1;
//		}
//		System.out.printf("%s의 공격!\n", this.name);
//		System.out.printf("%d의 데미지!\n", dam);
//		target.setHp(target.getHp()-dam);
//		System.out.println(target.name+"의 남은 체력: "+target.hp);
//		
//	}
	
	public void print() {
		System.out.println("[이름]: "+this.name+"   [체력]: "+this.hp);
		System.out.println("[공격력]: "+this.att+"   [방어력]: "+this.def+"   [위치]: "+this.position);
	}
	
	
	
}
