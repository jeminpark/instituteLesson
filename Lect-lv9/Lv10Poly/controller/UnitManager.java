package controller;
import java.util.Random;
import java.util.Vector;

import model.Player;
import model.Unit;

public class UnitManager {																//유닛매니저 클래스
	
	public Vector<Player> player_list = new Vector<>(); 								//벡터 플레이어클래스 플레이어리스트변수는 벡터객체로 초기화.
	public Vector<Unit> mon_list = new Vector<>();										// 벡터 유닛의 몬스터 리스트변수는 벡터객체로 초기화.
	String path = "model."; // 패키지명  + . 												// 문자열 path는 패키지명 "model."
	String mons[] = {"UnitWolf" , "UnitBat" , "UnitOrc"};								// 문자열배열 mons는 UnitWolf, UnitBat, UnitOrc 라는 문자열을 담고있다.
	Random ran = new Random();															// 랜덤클래스 호출
	public UnitManager(){																//유닛매니저 생성자 
		player_list.add( new Player("전사" , 1000, 45));									//플레이어 리스트 벡터에 추가( 플레이어객체 "전사", 체력1000,힘 45);
		player_list.add( new Player("마법사" , 800, 60));									//플레이어 리스트 벡터에 추가( 플레이어객체 "마법사", 체력800, 힘60)
		player_list.add( new Player("힐러" , 500, 70));									//플레이어 리스트 벡터에 추가( 플레이어 객체 "힐러", 체력 500, 힘 70)
	}
	
	public void monster_rand_set(int size) {											//몬스터랜덤세팅 메소드 매개변수(사이즈크기)
		for(int i = 0; i < size;  i++) {												// 반복문 i는 매개변수로 입력받은 사이즈만큼 반복한다.
			int num = ran.nextInt(mons.length);											//num 변수는 mons 배열의 크기만큼 랜덤문을 호출한다.
			try {																		//오류방지를 위해 try catch문 호출
				Class<?> clazz = Class.forName(path + mons[num]);						//코드로 클래스를 호출 <?>는 어떤제네릭으로되있는지 확신이없기때문 그리고 clazz 변수에 클래스path에 담긴 패키지명 model. 과 mons배열의 랜덤으로 나온 클래스명을 더해
				
				Object obj = clazz.newInstance();										//최상위 클래스인 object클래스를 자료형으로하는 obj변수에 방금 어떤제네릭으로 호출한지모르는 clazz를 담는다.
				Unit temp = (Unit)obj;													//Unit클래스 자료형으로 temp변수에  최상위클래스 obj변수를 Unit클래스 자료형으로 형변환하여 저장한다.
				int hp = ran.nextInt(100) + 100;										//체력을 담기위해 int자료형 hp변수에 랜덤숫자를 100번돌린 100단위의 숫자를 저장.
				int pow = ran.nextInt(10) + 10;											//힘을 담기위해 int자료형 pow변수에 랜덤숫자를 10번돌린 10단위의 숫자를 저장.
				temp.init(hp, pow);														// Unit클래스를 참조하는 temp변수의 init메소드를 호출하여 파라미터로 hp, pow를 넣는다. 
				mon_list.add(temp);														//몬스터리스트에 Unit클래스를 참조하는 temp를 추가시킨다.
			} catch (Exception e) {e.printStackTrace();}								// 혹시나 오류가 뜨면 어떤오류인지 출력시킨다.
		//	System.out.println(mon_list.get(i).name);
		}	
	}
	
	
	
}