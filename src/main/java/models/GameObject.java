package models;

public abstract class GameObject
{
  protected String name;
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String inName)
  {
    this.name = inName;
  }
}