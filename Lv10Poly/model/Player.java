package model;
public class Player extends Unit{									//플레이어는 유닛의 자식클래스이다.
	
	
	
	public Player(String na , int max , int pow){					//플레이어생성자에 매개변수로 문자열이름, 체력값, 힘을 받아온다.
		super(na, max , pow);										//수퍼에 받아온 매개변수를 입력하면 부모클래스의 생성자에 접근한다.
	}
	
	
	
	void skill() {													//스킬메소드
	
	}
	
	
	
}