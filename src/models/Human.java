package models;

import java.util.HashMap;

public class Human extends AnimateObject
{
	  private HashMap<String, InanimateObject> carryBag;
	  private HashMap<String, InanimateObject> equipment;
	  private int armorValue;
	  private int capacity;
	  private int weightOfItems;
	  private int skill;
	      
	  /**
	   * Human constructor method. 
	   */
	  public Human(String inName, int inPower, int inHealth,
			  		int inCapacity, int inSkill)
	  {
		  super(inName, inPower, inHealth);
	      //this.carryBag = new HashMap<String, InanimateObject>();
		  this.equipment = new HashMap<String, InanimateObject>();
		  this.carryBag = new HashMap<String, InanimateObject>();
		  this.capacity = inCapacity;
		  this.skill = inSkill;
		  	this.armorValue = 0;
	  }
	  
	  /**
	   * Called when a human attempts to pick-up
	   * an item from a localized area. 
	   * @param the key to access the item.  
	   * @return the item if it was successfully picked-up. 
	   */
		public InanimateObject pickupItem(InanimateObject item)
		{
		        if (item.getWeight() + this.weightOfItems <= this.capacity &&
		                        item.getSkill() <= this.skill)
		        {
		        	this.weightOfItems += item.getWeight();
		                carryBag.put(item.getName(), item);
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
	  public InanimateObject dropItem(String anItem)
	  {
          InanimateObject toDrop = carryBag.get(anItem);
          this.weightOfItems -= toDrop.getWeight();
          carryBag.remove(anItem);
          return toDrop;
	  }  
	  public boolean equipWeapon(String inWeaponName)
	  {
		  InanimateObject toEquip;
          if (!this.carryBag.containsKey(inWeaponName))
          { 
                  return false; 
          }
          else
          {
        	  toEquip = carryBag.get(inWeaponName);
          }
          if (!this.equipment.containsKey(toEquip.getDescription()))
          {
                  InanimateObject equipedWeaponTest = carryBag.get(inWeaponName);
                  if (equipedWeaponTest instanceof Weapon)
                  {
                	  this.carryBag.remove(inWeaponName);
                          this.equipment.put("weapon", equipedWeaponTest);
                          return true;
                  }
                  else
                  {
                          carryBag.put(inWeaponName, equipedWeaponTest);
                          return false;
                  }
          }
          return false; 
  }
  public boolean unEquipWeapon()
  {
	  if (this.equipment.containsKey("weapon"))
      {
		  InanimateObject unWeapon = this.equipment.get("weapon");
		  this.equipment.remove("weapon");
          carryBag.put(unWeapon.getName(), unWeapon);
          return true;
      }
          return false;
  }
  public boolean equipArmor(String inArmorName)
  {
	  	InanimateObject toEquip;
          if (!carryBag.containsKey(inArmorName))
          { 
                  return false; 
          }
          else
          {
        	  toEquip = carryBag.get(inArmorName);
          }
          if (!this.equipment.containsKey(toEquip.getDescription()))
          {
              InanimateObject equipedArmorTest = carryBag.get(inArmorName);
              if (equipedArmorTest instanceof Armor)
              {
            	  	  this.carryBag.remove(inArmorName);
                      this.equipment.put(equipedArmorTest.getDescription(), equipedArmorTest);
                      this.armorValue += equipedArmorTest.getValue();
                      return true;
              }
              else
              {
                      return false;
              }
          }
          return false; 
  }
  public boolean unEquipArmor(String inArmorDesc)
  {
	  if (this.equipment.containsKey(inArmorDesc))
      {
		  InanimateObject unArmor = this.equipment.get(inArmorDesc);
		  this.equipment.remove(inArmorDesc);
		  this.armorValue -= unArmor.getValue();
          carryBag.put(unArmor.getName(), unArmor);
          return true;
      }
          return false;
  }
	  
	  public int getAttackPower()
	  {
		  if (this.equipment.containsKey("weapon"))
		  {
			  InanimateObject weap = this.equipment.get("weapon");
			  return weap.getValue() + this.power;
		  }
		  return this.power;
	  }
	  
	  public void defend(int inAttack)
	  {
		int netAttack = inAttack - armorValue; 
		this.health = (netAttack < 1) ? this.health : this.health - netAttack;
	  }
}
