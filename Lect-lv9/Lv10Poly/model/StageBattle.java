package model;
import java.util.Random;
import java.util.Vector;

import controller.GameManager;
import controller.UnitManager;

public class StageBattle extends Stage{							//전투스테이지는 스테이지의 자식클래스이다.
	UnitManager unitManager = new UnitManager();				//유닛매니저 변수에 유닛매니저객체를 담음.
	Vector<Player> playerList = null;							// 벡터 유닛 플레이어 리스트를 선언
	Vector<Unit> monList = null;								// 벡터 유닛 몬스터리스트를 선언
	Random ran = new Random();									// 랜덤클래스호출
	int monDead = 0;											// 멤버변수에 몬스터가 죽은숫자카운터변수 선언
	int playerDead = 0;											// 플레이어 죽은숫자 카운터변수 선언
	
	public void init() {										// 전투스테이지 세팅메소드
		unitManager.mon_list.clear();							// 유닛매니저의 몬스터리스트를 전부삭제한다.
		unitManager.monster_rand_set(4);						// 유닛매니저의 몬스터를 랜덤으로 셋팅하는 메소드에 숫자4를 매개변수를 입력한다.
		playerList = null;										// 플레이어리스트를 null화 시켜줘서 깨끗히 비우고
		playerList = unitManager.player_list;					// 플레이어리스트 벡터에 유닛매니저에 있는 플레이어 리스트를 저장한다.
		monList= null;											// 몬스터리스트를 null화 시킨다.
		monList = unitManager.mon_list;							// 몬스터리스트에 벡터에 유닛매니저에있는 몬스터리스트를 저장한다.
		monDead = monList.size();								// 몬스터죽은카운트는 몬스터리스트의 사이즈로 저장한다.
		playerDead = playerList.size();							// 플레이어의 목숨카운트는 플레이어 리스트의 사이즈로한다.
	}
	void print_character() {									// 캐릭터 출력
		System.out.println("======[BATTLE]======");				// 전투로고 출력
		//System.out.println(playerSize + " " + monSize);
		System.out.println("======[PLAYER]======");				// 플레이어 로고 출력
		for(int i = 0; i < playerList.size(); i++) {			// i를 플레이어리스트벡터의 사이즈만큼 반복시킨다.
			this.playerList.get(i).printData();					// 플레이어리스트 벡터의 겟(인덱스숫자)로 플레이어리스트백터 가 담고있는 이름과 체력 힘등을 표시하는 프린트데이터 메소드를 호출한다.
		}
		System.out.println("======[MONSTER]======");			// 몬스터 로고 출력
		for(int i = 0; i < monList.size(); i++) {				//i를 몬스터리스트벡터의 사이즈만큼 반복시킨다.
			this.monList.get(i).printData();					// 몬스터 리스트 벡터의 겟(인덱스숫자)로 플레이어 리스트 벡터가 담고있는 
		}
	}
	void player_attack(int index) {
		Player p = playerList.get(index);
		if(p.curhp<=0) return;
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
		int sel = GameManager.scan.nextInt();
		if(sel == 1) {
			while(true) {
				int idx = ran.nextInt(monList.size());
		
				if(monList.get(idx).curhp > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		}else if(sel ==2) {}		
	}
	void monster_attack(int index) {
		Unit m = monList.get(index);
		if(m.curhp <= 0) return;
		while(true) {
			int idx = ran.nextInt(playerList.size());
			if(playerList.get(idx).curhp > 0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
	}
	void check_live() {
		int num = 0;
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).curhp <= 0) {
				num += 1;
			}
		}	
		playerDead = playerList.size() - num;		
		num = 0;
		for(int i = 0; i < monList.size(); i++) {
			if(monList.get(i).curhp <= 0) {
				num += 1;
			}
		}	
		monDead = monList.size() - num;
		
	}
	
	public boolean update() {		
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;	
		
		while(run) {		
			//print_character();
			if(turn) {			
				print_character();
				if(p_index < playerList.size() ) {				
					player_attack(p_index);	
					
					p_index += 1;
				}else {
					turn = !turn;
					p_index= 0;
				}
					
			}else if(!turn){
				if(m_index < monList.size() ) {					
					monster_attack(m_index);
					m_index += 1;
				}else {
					turn = !turn;
					m_index= 0;
				}
			}
			check_live();
			if(monDead <= 0 || playerDead <= 0)break;
		}
		GameManager.nextStage = "LOBBY";	
		return false;
	}
}