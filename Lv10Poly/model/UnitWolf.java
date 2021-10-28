package model;
public class UnitWolf extends Unit{									//유닛늑대는 유닛의 자식클래스이다.
	public UnitWolf(){												//늑대생성자
		name = "늑대";												//유닛의 멤버변수 이름에 늑대를 저장
	}

	public void skill() {											//스킬메소드
		System.out.println("적 전체에게 공격력의 절반 데미지 ");				//스킬 시전시 출력문
		
	}
}