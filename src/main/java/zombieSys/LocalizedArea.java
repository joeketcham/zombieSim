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
	
  	public InanimateObject dropItem(Human human, String itemDescription){
		return human.dropItem(itemDescription);
	} 
  	
	public boolean equipWeapon(Human human, Weapon weapon){
		return human.equipWeapon(weapon);
	}
	
	public boolean unEquipWeapon(Human human, Weapon weapon){
		return human.unEquipWeapon(weapon);
	}
  
	public boolean equipArmor(Human human, Armor armor){
		return human.equipArmor(armor);
	}
	
	public boolean unEquipArmor(Human human, Armor armor){
		return human.unEquipArmor(armor);
	}
	
	public int attack(Human human, Zombie zombie){
		return zombie.defend(human.attack());
	}
	
	public int attack(Zombie zombie, Human human){
		return human.defend(zombie.attack());
	}
}