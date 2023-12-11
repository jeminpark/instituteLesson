package model;

import controller.Game;
import model.Player;
import model.Unit;

public class Zombie extends Unit {
	public Zombie(String name, int hp, int att, int def, int position) {
		super(name, hp, att, def, position);
	}
	public void attack(Unit target) {
		super.attack(target);
	}
	
}
