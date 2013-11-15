package models;


public class GameObject
{
	String name;
	Double currentLocation;
	
	public GameObject(String inName)
	{
		this.name = inName;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setLocation(Double area)
	{
		currentLocation = area;
	}
		
	public double getLocation()
	{
		return currentLocation;
	}
}
