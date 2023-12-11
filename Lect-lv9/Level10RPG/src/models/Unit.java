package models;

public abstract class Unit {

	private int curhp;
	private int maxhp;
	private int power;
	private String name;
	private String state = "노말";
	
	public Unit() {}
	
	public int getCurhp() {
		return curhp;
	}

	public void setCurhp(int curhp) {
		this.curhp = curhp;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Unit(String name, int max, int power) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = power;
		
	}
	public void init(int max, int power) {
		
		this.maxhp = max;
		this.curhp = max;
		this.power = power;
	}
	public void init(String name, int max, int power) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = power;
	}
	public void attack(Unit target) {
		target.curhp -= power;
		System.out.println("["+this.name+"] 이 ["+target.name+"] 에게"+power+"의 데미지를 입힙니다.");
		
		if(target.curhp<= 0) {
			System.out.println("["+target.name+"] 을 처치했습니다.");
			target.curhp = 0;
			
		}
	}
	public void printData() {
		System.out.println("["+this.name+"] ["+this.curhp+"/"+this.maxhp+"] ["+this.power +"]");
	}
}
