package model;
public abstract class Unit {
	int curhp;										//현재 hp를 저장
	int maxhp;										//최대 hp를 저장
	int power;										//힘을 저장
	String name;									//이름을 저장
	String state = "노말";							// 상태를 저장
	Unit(){};										//몬스터들을 코드로 생성하기위해 생성자생성
	Unit(String na , int max , int pw){				//플레이어캐릭터 생성용 생성자
		name = na;									//플레이어이름
		maxhp = max;								//플레이어 최대체력
		curhp = max;								//플레이어 현재체력
		power = pw;									//플레이어 힘
	};
	public void init(int max , int pw){				//
		maxhp = max;
		curhp = max;
		power = pw;
	};
	public void init(String na , int max , int pw){
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};
	public void attack(Unit target) {											//유닛 공격메소드(타겟을매개변수로받음)
		target.curhp -= power;													//매개변수로 받은 타겟의 현재체력 - 공격한놈의 힘
		System.out.println("[" + name + "] 이 " + "[" + target.name + "] 에게 "	// 공격하는동시에 공격한주체의이름이 타겟의이름에게 공격한주체의힘의 데미지를 주었다고 출력
				+ power + "의 데미지를 입힙니다. ");
		if(target.curhp <= 0) {													//만약 타겟의 현재체력이 0보다 작아진다면
			System.out.println("[" + target.name + "] 을 쳐치했습니다.");			// 타겟의이름 을 처치했다고 출력
			target.curhp = 0;													//타겟의 현재체력을 0으로 만듬.
		}
	}
	public void printData() {													// 출력데이터 메소드
		System.out.println("["+name + "] [" + curhp + "/" + maxhp + "] [" + power +"]");	//이름과 현재체력/최대체력 힘을 출력
	}
}