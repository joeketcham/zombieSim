package models;

public class Weapon extends InanimateObject
{
	private String description;
	private int bonus;
	public Weapon(){
		description = "weapon";
		bonus = 0;
	}
	public Weapon(String args[]){
		//desc, bonus, skill, weight
		description = args[0];
		bonus = Integer.parseInt(args[1]);
		super.setSkill(Integer.parseInt(args[2]));
		super.setWeight(Integer.parseInt(args[3]));
	}
	public void setDescription(String description){ 
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	
	public void setValue(int bonus){
		this.bonus = bonus;
	}
	public int useItem(){
		return bonus;
	}
}