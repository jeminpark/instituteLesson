package model;

public class ZombieKing extends Unit{		//좀비킹클래스가 유닛클래스의 상속을 받는자식클래스이다.
	int shield;								//갑옷의 변수를 추가한다.
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
	public void attack(Unit target) {			//공격메소드에 유닛클래스를 자료형으로 받는 타겟을 인자로 받으면
		if(rand.nextInt(100)>74) {				//만약 랜덤을 100번 돌려서 74보다 큰수가 나오면
			int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100; //데미지는 Unit의 공격값 빼기 대상의 
			if(dam <= 0 ) {
				dam = 1;
				
			}
			dam*=2;
			System.out.println(getName()+"의 필살기!!");
			System.out.println(dam+"의 데미지");
			target.setHp(target.getHp()-dam);
			System.out.println(target.getName()+"의 남은체력 : "+target.getHp());
			
		}
		else {
			super.attack(target);
		}
	}
}
