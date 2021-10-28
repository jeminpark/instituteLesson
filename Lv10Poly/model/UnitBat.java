package model;
public class UnitBat extends Unit{					//유닛박쥐는 유닛의 자식클래스이다.
	public UnitBat(){								// 유닛박쥐의 생성자 생성
		name = "박쥐";								//유닛의 멤버 이름을이용해 박쥐라는 이름을 저장.
	}
	public void skill() {							// 스킬메소드
		System.out.println("적 한명에게 침묵 시전 ");		// 스킬시전시 출력문
	}
}