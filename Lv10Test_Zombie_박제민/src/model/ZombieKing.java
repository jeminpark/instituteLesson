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
		
		int damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100; 
		if(damage <= 0) {
			damage = 1;
		}
		else if(damage < 10 ) {
			damage*=2;
			System.out.println(this.getName()+"의 필살기!");
			System.out.println(damage+"의 데미지");
			System.out.println(target.getName()+"의 남은체력: "+this.getHp());
			target.setHp(target.getHp()- damage);
			
		}
		else {
			damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100;
			if(damage <= 0) {
				damage = 1;
			}
			System.out.printf("%s의 공격!\n", this.getName());
			System.out.printf("%d의 데미지!\n", damage);
			target.setHp(target.getHp()-damage);
			System.out.printf("%s의 남은체력: %d\n",target.getName(), target.getHp());
			
		}
		
		
	}
}
