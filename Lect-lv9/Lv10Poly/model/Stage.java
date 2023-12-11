package model;
public abstract class Stage {
	
	public abstract boolean update();		//스테이지를 참거짓방식의 업데이트메소드로 추상적으로 선언
	public abstract void init();			//세팅메소드를 추상적으로 선언
}