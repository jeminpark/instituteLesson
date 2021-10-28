package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import models.Stage;
import models.StageBattle;
import models.StageLobby;
import models.StageTitle;

public class GameManager {

	Random rand = new Random();
	
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	
	String curStage = "";
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	public GameManager() {
		
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		
		nextStage = "TITLE";
	}
	public boolean changeStage() {
//		System.out.println("curStage: "+curStage);
//		System.out.println("nextStage: "+nextStage);
		
		if(curStage.equals(nextStage)) {
			return true;
		}
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(true) {
			run = stage.update();
			if(run == false) {
				break;
			}
		}
		if(nextStage.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
}
