package models;

public class Zombie extends AnimateObject
{
	public Zombie(String inName, int inPower, int inHealth)
	  {
		  super(inName, inPower, inHealth);
	}
	
	public int getAttackPower()
	{
		return this.power;
	}
	  
	public void defend(int inAttack)
	{
		this.health -= inAttack;
	}
}
