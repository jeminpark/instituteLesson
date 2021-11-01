package model;

public class ZombieKing extends Unit{
	private int shield;
	public ZombieKing(String name, int hp, int attack, int def, int position, int shield ) {
		super(name, hp, attack, def, position);
		this.shield = shield;
	}
	public int getShield() {
		return this.shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public void attack(Unit target) {
		if(rand.nextInt(100)> 80) {
			
			int damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100; 
			if(damage <= 0) {
				damage = 1;
			}			
			damage*=2;
			System.out.println(this.getName()+"의 필살기!");
			System.out.println(damage+"의 데미지");
			System.out.println(target.getName()+"의 남은체력: "+this.getHp());
			target.setHp(target.getHp()- damage);
				
		}
		else {
			super.attack(target);
			
		}
	}				
	
}
