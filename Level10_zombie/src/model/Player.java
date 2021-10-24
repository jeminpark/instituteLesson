package model;

public class Player extends Unit{
	private int cnt = 3;
	public Player(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
	}
	
	public int getCnt() {
		return cnt;
	}
	public void drink() {
		if(cnt > 0) {
			System.out.println("회복약을 마십니다.");
			System.out.println("체력이 100회복 되었습니다.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"의 남은 체력: "+this.getHp());
			cnt--;
		}
		else {
			System.out.println("물약이 없습니다.");
		}
	}
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing)target).shield >0){
				int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100;
				if(dam<= 0) {
					dam = 1;
				}
				System.out.println(getName()+"의 공격!");
				System.out.println(dam+"의 데미지!");
				((ZombieKing) target).setShield(((ZombieKing) target).getShield()-dam);
				if(((ZombieKing) target).getShield()<= 0) {
					System.out.println(target.getName()+"의 쉴드가 박살났다!");
					((ZombieKing) target).setShield(0);
				}
				System.out.println(target.getName()+"의 남은체력: "+target.getHp()+" (쉴드: "+((ZombieKing) target).getShield()+")");
				
						
				
			}
			else {
				super.attack(target);
			}
		}
		else {
			super.attack(target);
		}
		
	}
}
