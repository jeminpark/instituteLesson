package model;

public class Zombie extends Unit implements Attack {
	public Zombie(String name, int hp, int att, int def, int position) {
		super(name, hp, att, def, position);
	}
	public void attack(Unit attack) {
		super.attack(attack);
	}
}
