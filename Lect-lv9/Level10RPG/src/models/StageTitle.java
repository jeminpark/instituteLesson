package models;

import controller.GameManager;

public class StageTitle extends Stage{

	@Override
	public boolean update() {
		System.out.println("===== TEXT RPG =====");
		System.out.println("[����] �� �Է��ϼ���.");
		String start = GameManager.scan.next();
		if(start.equals("����"));
		GameManager.nextStage = "LOBBY";
		return false;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}