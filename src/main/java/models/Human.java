package models;

import java.util.HashMap;
import java.util.Map;

public class Human extends AnimateObject
{  

	private String fname;
	private String lname;
	private Weapon equipedWeapon;
	private Armor equipedArmor;
	private Map<String, InanimateObject> carryBag = new HashMap<String, InanimateObject>();
	private int carryingCapacity;
	private int weight;
	private int skill;
	private int health;	
	      
  /**
   * Human constructor method. 
   */
  public Human()
  {
	    //this.carryBag = new HashMap<String, InanimateObject>();	    
	    fname = "";
		lname = "";
		carryingCapacity = 10;
		weight = 1;
		skill = 1;
		health = 10;
  }
  public Human(String args[]){
		fname = args[0];
		lname = args[1];
		carryingCapacity = Integer.parseInt(args[2]);
		weight = Integer.parseInt(args[3]);
		skill = Integer.parseInt(args[4]);
  }

  public void setFname(String fname){ this.fname = fname; }
  public String getFname(){ return fname; }
  
  public void setLname(String lname){ this.lname = lname; }
  public String getLname(){ return lname; }
	
  /**
   * Called when a human attempts to pick-up
   * an item from a localized area. 
   * @param the key to access the item.  
   * @return the item if it was successfully picked-up. 
   */
  public InanimateObject pickupItem(InanimateObject item){
		if (item.getWeight() + this.weight <= this.carryingCapacity &&
				item.getSkill() <= this.skill){
			carryBag.put(item.getDescription(), item);
			return null;
		}
		return item;
	}
  
  /**
   * Called when a human attempts to drop
   * an item. The item will then be added to
   * the localized area. 
   * @param the key to access the item. 
   * @return the item if it was successfully dropped. 
   */
  public InanimateObject dropItem(String itemDescription){
	  InanimateObject toDrop = carryBag.get(itemDescription);
	  carryBag.remove(itemDescription);
	  return toDrop;
	}  

	public boolean equipWeapon(Weapon weapon){
		return false; 
	}
	public boolean unEquipWeapon(Weapon weapon){
		return false;
	}
	public boolean equipArmor(Armor armor){
		return false; 
	}
	public boolean unEquipArmor(Armor armor){
		return false;
	}
	public int attack(){
		if (equipedWeapon != null){
			return equipedWeapon.useItem() + 1;
		}
		return 1;
	}
	public int defend(int attackValue){
		if (equipedArmor != null){
			int netAttack =attackValue - equipedArmor.useItem(); 
			health = (netAttack < 1) ? health : health - netAttack;
			return health;
		}
		health = (health - attackValue < 1) ? 0 : health - attackValue;
		return health;
	}
}