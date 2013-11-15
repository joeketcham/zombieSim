package models;

public class Zombie extends AnimateObject
{
	int health;
	int attackVal;
	
	public Zombie(){
		health = 10;
		attackVal = 2;
	}
	
	public int defend(int attackValue){		
		health = (health - attackValue < 1) ? 0 : health - attackValue;
		return health;
	}
	public int attack(){
		return attackVal;
	}
}