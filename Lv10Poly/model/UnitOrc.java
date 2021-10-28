package model;
public class UnitOrc extends Unit{						//유닛오크는 유닛의 자식클래스이다.
	public UnitOrc(){									// 유닛오크생성자
		name = "오크";									//유닛의 멤버에 오크 이름저장
	}
	
	public void skill() {									//스킬메소드
		System.out.println("한명에게 2배의 데미지 + 기절 ");		//스킬시전시 출력문
		
	}
}