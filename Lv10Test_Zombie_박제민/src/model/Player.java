package model;

public class Player extends Unit implements Heal, UpgradeArmor{
	private int potion = 3;
	public Player(String name, int hp, int attack, int def, int position) {
		super(name, hp, attack, def, position);
	}
	public int getPotion() {
		return this.potion;
	}
	public void setPotion(int potion) {
		this.potion = potion;
	}
	public void attack(Unit target) {
		int damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100;
		if(target instanceof ZombieKing) {
			if(((ZombieKing)target).getShield() > 0) {
				if(damage <= 0) {
					damage = 1;
				}
				System.out.printf("%s 의 공격\n", this.getName());
				System.out.printf("%d의 데미지\n",damage);
				((ZombieKing)target).setShield(((ZombieKing)target).getShield()- damage);
				if(((ZombieKing)target).getShield()<= 0) {
					System.out.println(target.getName()+"의 쉴드를 박살냈다");
					((ZombieKing)target).setShield(0);
					
				}
				System.out.println(target.getName()+"의 남은체력: "+this.getHp()+"(쉴드: "+((ZombieKing)target).getShield()+")");
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
		damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100;
		if(damage <= 0) {
			damage = 1;
		}
		System.out.printf("%s의 공격!\n", this.getName());
		System.out.printf("%d의 데미지!\n", damage);
		target.setHp(target.getHp()-damage);
		System.out.printf("%s의 남은체력: %d\n",target.getName(), target.getHp());
		
	}
	public void Heal() {
		if(this.potion > 0) {
			System.out.println("물약을 사용합니다.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"의 남은체력: "+this.getHp());
			this.potion --;
			
		}
		else {
			System.out.println("사용할 물약이 없습니다.");
		}
	}
	public void upgrade() {
		int rNum = rand.nextInt(2)+1;
		if(rNum == 1) {
			rNum = rand.nextInt(3)+1;
			this.setAttack(this.getAttack()+rNum);
			System.out.println("공격력이 "+rNum+"만큼 증가했습니다.");
		}
		else {
			rNum = rand.nextInt(3)+1;
			this.setDef(this.getDef()+rNum);
			System.out.println("방어력이 "+rNum+"만큼 증가했습니다.");
		}
	}
	
}
