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
  	
	public boolean equipWeapon(Human human, String weaponDesc){
		return human.equipWeapon(weaponDesc);
	}
	
	public boolean unEquipWeapon(Human human){
		return human.unEquipWeapon();
	}
  
	public boolean equipArmor(Human human, String armorDesc){
		return human.equipArmor(armorDesc);
	}
	
	public boolean unEquipArmor(Human human){
		return human.unEquipArmor();
	}
	
	public int attack(Human human, Zombie zombie){
		return zombie.defend(human.attack());
	}
	
	public int attack(Zombie zombie, Human human){
		return human.defend(zombie.attack());
	}
}