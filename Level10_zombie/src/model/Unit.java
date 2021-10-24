package model;

import java.util.Random;

public abstract class Unit {
	Random rand = new Random();
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;
	
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
		this.att =att;
	}
	public int getDef() {
		return this.def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPos() {
		return this.pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	Unit(String name, int hp, int att, int def, int pos){
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		
	}
	public void attack(Unit target) {
		int dam = (this.att - target.def)*(rand.nextInt(150)+50/100);
		if(dam <= 0 ) {
			dam = 1;
		}
		System.out.println(name+ "의 공격!");
		System.out.println(dam+"의 데미지!");
		target.setHp(target.getHp()-dam);
		System.out.println(target.name+"의 남은 체력: "+target.hp);
	}
	public void print() {
		System.out.println("[이름]: "+name+"  [체력]: "+hp);
		System.out.println("[공격력]: "+att+"  [방어력]:"+def+"  [위치]: "+pos);
		
	}
	
}
