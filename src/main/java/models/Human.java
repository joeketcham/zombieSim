package models;

import java.util.HashMap;


public class Human extends AnimateObject
{  

  private HashMap<String, InanimateObject> carryBag;
  private boolean itemInHand;
      
  /**
   * Human constructor method. 
   */
  public Human()
  {
      //this.carryBag = new HashMap<String, InanimateObject>();
      this.itemInHand = false;
  }
  
  /**
   * Called when a human attempts to pick-up
   * an item from a localized area. 
   * @param the key to access the item.  
   * @return the item if it was successfully picked-up. 
   */
  public InanimateObject pickUpItem(String anItem)
  {
     if (!itemInHand){
       itemInHand = true;
       return carryBag.get(anItem);
     }     
     return null;
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
      if (itemInHand) {
        itemInHand = false;
        return carryBag.get(anItem);
      } 
      return null;
  }
}