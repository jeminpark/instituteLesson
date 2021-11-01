package model;

import java.util.Random;

interface Heal{
	
}
interface UpgradeArmor{
	public void upgrade();
}
public abstract class Unit {
	Random rand = new Random();
	private String name;
	private int hp;
	private int attack;
	private int def;
	private int position;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public Unit(String name, int hp, int attack, int def, int position) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.def = def;
		this.position = position;
	}
	public abstract void attack(Unit target);
//		int damage = (this.attack - target.def)*(rand.nextInt(150)+50)/100;
//		if(damage <= 0) {
//			damage = 1;
//		}
//		System.out.printf("%s의 공격!\n", this.name);
//		System.out.printf("%d의 데미지!\n", damage);
//		target.setHp(target.getHp()-damage);
//		System.out.printf("%s의 남은체력: %d\n",target.name, target.hp);
	
	public void printData() {
		System.out.printf("[이름: %s]   [체력: %d]\n", this.name, this.hp);
		System.out.printf("[공격력: %d]   [방어력: %d]   [위치: %d]\n", this.attack, this.def, this.position);
		
	}
	
}
