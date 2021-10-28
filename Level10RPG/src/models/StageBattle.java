package models;

import java.util.Random;
import java.util.Vector;

import controller.GameManager;
import controller.UnitManager;

public class StageBattle extends Stage{
	private UnitManager um = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	Random rand = new Random();
	int monDead = 0;
	int playerDead = 0;
	
	public void init() {
		um.mon_list.clear();
		um.monsterLandSet(4);
		playerList = null;
		playerList = um.player_list;
		monList = null;
		monList = um.mon_list;
		monDead = monList.size();
		playerDead = playerList.size();
	}
	public void printCharacter() {
		System.out.println("======= [BATTLE] =======");
//		System.out.println(playerSize+" "+monSize);
		System.out.println("======= [PLAYER] =======");
		for(int i=0; i<playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("======= [MONSTER] =======");
		for(int i=0; i<monList.size(); i++) {
			System.out.println(monList.get(i)); //몬스터가 출력이안되고있다.
		}
	}
	public void playerAttack(int index) {
		Player p = playerList.get(index);
		if(p.getCurhp()<= 0) {
			return;
		}
		System.out.println("===== [메뉴 선택] =====");
		System.out.println("["+p.getName()+"] [1.공격] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if(sel == 1) {
			while(true) {
				int idx = rand.nextInt(monList.size());
				
				if(monList.get(idx).getCurhp() > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		}
		else if(sel == 2) {
			
		}
	}
	public void monsterAttack(int index) {
		Unit m = monList.get(index);
		if(m.getCurhp()<= 0) {
			return;
		}
		while(true) {
			int idx = rand.nextInt(playerList.size());
			if(playerList.get(idx).getCurhp()> 0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
		
	}
	public void checkLive() {
		int num = 0;
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getCurhp()<= 0) {
				num++;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for(int i=0; i<monList.size(); i++) {
			if(monList.get(i).getCurhp()<= 0) {
				num++;
			}
		}
		monDead = monList.size()- num;
	}
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		
		while(run) {
			//printCharacter();
			if(turn) {
				printCharacter();
				if(p_index < playerList.size()) {
					playerAttack(p_index);
					
					p_index++;
				}
				else {
					turn = !turn;
					p_index = 0;
				}
			}
			else if(!turn) {
				if(m_index < monList.size()) {
					monsterAttack(m_index);
					m_index++;
				}
				else {
					turn = !turn;
					m_index = 0;
				}
			}
			checkLive();
			if(monDead <= 0 || playerDead <= 0) {
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	

}
