package model;

public class Zombie extends Unit {

	public Zombie(String name, int hp, int attack, int def, int position) {
		super(name, hp, attack, def, position);
	}
	public void attack(Unit target) {
		super.attack(target);
	}
}
