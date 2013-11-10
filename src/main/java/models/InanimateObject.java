package models;

public abstract class InanimateObject extends GameObject
{
	int weight;
	int skill;
	
	public InanimateObject(){
		weight = 0;
		skill = 0;
	}
	
	public void setWeight(int weight){ this.weight = weight;}
	public int getWeight(){ return weight; }
	
	public void setSkill(int skill){ this.skill = skill; }
	public int getSkill(){ return skill; }
	
	public abstract String getDescription();
	public abstract void setDescription(String description);
	public abstract void setValue(int value);
	public abstract int useItem();
}