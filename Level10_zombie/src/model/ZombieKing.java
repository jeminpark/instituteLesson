package model;

import controller.Game;
import model.Zombie;

public class ZombieKing extends Unit implements Attack, Damageable{		//좀비킹클래스가 유닛클래스의 상속을 받는자식클래스이다.
	private int shield;	
	private boolean isDead;
	private int dam;//갑옷의 변수를 추가한다.
	public ZombieKing(String name, int hp, int att, int def, int position, int shield) {// 생성자 좀비왕에 GAME에서 받은 좀비왕의 스탯을 인자로준다.
		super(name, hp, att, def, position);		//부모클래스에 인자로 받은 좀비왕의 스탯을 super로 부모클래스의 생성자에 접근시킨다.
		this.shield = shield;					//인자로 받은 쉴드를 좀비왕의 쉴드변수에 저장한다.
	}
	public int getShield() {					//게터로 쉴드수치 출력
		return this.shield;
	}
	public void setShield(int shield) {			//세터로 쉴드수치 수정
		this.shield = shield;
	}
//	public void attack(Unit target) {			//공격메소드에 유닛클래스를 자료형으로 받는 타겟을 인자로 받으면
//		if(rand.nextInt(100)>74) {				//만약 랜덤을 100번 돌려서 74보다 큰수가 나오면
//			int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100; //데미지는 Unit의 공격값 빼기 대상의 방어력 곱하기 랜덤을 150번 돌려서 나온 값+50나누기 100
//			if(dam <= 0 ) {						//데미지가 0 이하이면
//				dam = 1;						//데미지는 1이된다.
//				
//			}
//			dam*=2;												
//			System.out.println(getName()+"의 필살기!!");				//좀비킹이 필살기시전할때 출력문
//			System.out.println(dam+"의 데미지");						//데미지 값출력
//			target.setHp(target.getHp()-dam);						//데미지를 받는 대상의 체력을 대상의 체력-데미지로 수정한다.
//			System.out.println(target.getName()+"의 남은체력 : "+target.getHp());		//데미지를 받은 대상의 체력을 출력한다.
//			
//		}
//		else {
//			super.attack(target);
//		}
//	}
	@Override
	public void attack(Unit target) {
		if(rand.nextInt(100)>74) {				//만약 랜덤을 100번 돌려서 74보다 큰수가 나오면
			this.dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100; //데미지는 Unit의 공격값 빼기 대상의 방어력 곱하기 랜덤을 150번 돌려서 나온 값+50나누기 100
			if(this.dam <= 0 ) {						//데미지가 0 이하이면
				this.dam = 1;						//데미지는 1이된다.
				
			}
			this.dam*=2;												
			System.out.println(this.getName()+"의 필살기!!");				//좀비킹이 필살기시전할때 출력문
			System.out.println(this.dam+"의 데미지");						//데미지 값출력
			target.setHp(target.getHp()-dam);						//데미지를 받는 대상의 체력을 대상의 체력-데미지로 수정한다.
			System.out.println(target.getName()+"의 남은체력 : "+target.getHp());		//데미지를 받은 대상의 체력을 출력한다.
			((Player)target).damage(this.dam);
		}
		else {
//			super.attack(target);
			this.dam = (this.getAtt()- target.getDef())*(Game.rand.nextInt(150)+50)/100;
			if(this.dam <= 0) {
				this.dam = 1;
			}
			System.out.printf("%s의 공격!\n", this.getName());
			System.out.printf("%d의 데미지!\n", dam);
			((Player) target).damage(this.dam);
		}
		
	}
	@Override
	public void damage(int attack) {
		this.setHp(this.getHp()-attack);
		System.out.println(this.getName()+"의 남은체력: "+this.getHp());
		if(this.getHp()<= 0) {
			isDead = true;
			System.out.println("좀비군주 사망...");
		}
		
	}
}
