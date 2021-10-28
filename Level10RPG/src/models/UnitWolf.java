package models;

public class UnitWolf extends Unit{

	public UnitWolf(){
		this.setName("늑대");
	}
	public void skill() {
		System.out.println("적 전체에게 공격력의 절반데미지");
	}
}
