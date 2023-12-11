package model;
import controller.GameManager;

public class StageTitle extends Stage{										//스테이지의 이름은 스테이지의 자식클래스이다.

	@Override																//스테이지의 추상메소드로 받은 불리언타입의 update메소드를 오버라이딩한다(덮어쓰기).
	public boolean update() {														
		System.out.println("==== TEXT RPG ====");							//텍스트 RPG라는 이름을 출력시킨다.
		System.out.println("[시작] 을 입력하세요");								//시작을 출력시킨다.
		String start = GameManager.scan.next();								//문자열 스캔문으로 start란 변수에 입력값을 집어넣는다.
		if(start.equals("시작"));												//만약 문자열 start에 입력된 글자가 "시작"과 같으면
		GameManager.nextStage = "LOBBY";									//게임매니저클래스에 스테틱으로 넣은 nextStage변수가 LOBBY를 참조한다.
		return false;														//불리언타입을 거짓으로 바꿔서 스테이지 타이틀의 업데이트 메소드의 실행을 정지시킨다.
	}

	@Override
	public void init() {													//stage클래스의 셋팅을 오버라이딩함.
		
	}

}