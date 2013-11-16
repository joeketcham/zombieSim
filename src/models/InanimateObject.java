package models;

public class InanimateObject extends GameObject
{
	int weight;
	int skill;
	int value;
	String description;
	
	public InanimateObject(String inName, String inDesc, 
							int inValue, int inWeight, int inSkill)
	{
		super(inName);
		this.description = inDesc;
		this.value = inValue;
		this.weight = inWeight;
		this.skill = inSkill;
	}
	
    public int getWeight()
    {
    	return this.weight;
    }
    public int getSkill()
    {
    	return this.skill;
    }
    public int getValue()
    {
    	return this.value;
    }
    public String getDescription()
    {
    	return this.description;
    }
}
