package controller;

import java.util.Random;
import java.util.Vector;

import models.Player;
import models.Unit;

public class UnitManager {

	public Vector<Player> player_list = new Vector<>();
	public Vector<Unit> mon_list = new Vector<>();
	String path = "models.";
	String mons[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	
	Random rand = new Random();
	public UnitManager() {
		player_list.add(new Player("전사", 1000 , 45));
		player_list.add(new Player("마법사", 800, 60));
		player_list.add(new Player("힐러", 500, 70));
	}
	public void monsterLandSet(int size) {
		for(int i=0; i<size; i++) {
			int rNum = rand.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path+mons[rNum]);
				System.out.println(path+mons[rNum]);
				Object obj = clazz.newInstance();
				Unit temp = (Unit)obj;
				int hp = rand.nextInt(100)+100;
				int power = rand.nextInt(10)+10;
				temp.init(hp, power);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
