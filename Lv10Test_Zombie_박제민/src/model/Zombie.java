package model;

public class Zombie extends Unit {

	public Zombie(String name, int hp, int attack, int def, int position) {
		super(name, hp, attack, def, position);
	}
	public void attack(Unit target) {
		int damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100;
		if(damage <= 0) {
			damage = 1;
		}
		System.out.printf("%s의 공격!\n", this.getName());
		System.out.printf("%d의 데미지!\n", damage);
		target.setHp(target.getHp()-damage);
		System.out.printf("%s의 남은체력: %d\n",target.getName(), target.getHp());
	}
}
