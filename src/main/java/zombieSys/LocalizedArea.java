package zombieSys;

import models.*;

public class LocalizedArea
{
	public LocalizedArea()
	{	  
	}
  	public InanimateObject pickupItem(Human human, InanimateObject item){
		return human.pickupItem(item);
	}
	
	public boolean equipWeapon(Human human, Weapon weapon){
		return human.equipWeapon(weapon);
	}
	
	public InanimateObject dropItem(Human human, String itemDescription){
		return human.dropItem(itemDescription);
	} 
  
}