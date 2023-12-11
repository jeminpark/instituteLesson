package model;

public class Player extends Unit implements Heal, UpgradeArmor{
	private int potion = 5;
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
		if(target instanceof ZombieKing) {
			if(((ZombieKing)target).getShield() > 0) {
				int damage = (this.getAttack() - target.getDef())*(rand.nextInt(150)+50)/100;
				if(damage <= 0) {
					damage = 1;
				}
				System.out.printf("%s �� ����\n", this.getName());
				System.out.printf("%d�� ������\n",damage);
				((ZombieKing)target).setShield(((ZombieKing)target).getShield()- damage);
				if(((ZombieKing)target).getShield()<= 0) {
					System.out.println(target.getName()+"�� ���带 �ڻ�´�");
					((ZombieKing)target).setShield(0);
					
				}
				System.out.println(target.getName()+"�� ����ü��: "+this.getHp()+"(����: "+((ZombieKing)target).getShield()+")");
			}
			
			else {
				super.attack(target);
			}
		}
		else {
			super.attack(target);
			
		}
		
	}
	public void Heal() {
		if(this.potion > 0) {
			System.out.println("������ ����մϴ�.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"�� ����ü��: "+this.getHp());
			this.potion --;
			
		}
		else {
			System.out.println("����� ������ �����ϴ�.");
		}
	}
	public void upgrade() {
		int rNum = rand.nextInt(2)+1;
		if(rNum == 1) {
			rNum = rand.nextInt(5)+1;
			this.setAttack(this.getAttack()+rNum);
			System.out.println("���ݷ��� "+rNum+"��ŭ �����߽��ϴ�.");
		}
		else {
			rNum = rand.nextInt(5)+1;
			this.setDef(this.getDef()+rNum);
			System.out.println("������ "+rNum+"��ŭ �����߽��ϴ�.");
		}
	}
	
}
