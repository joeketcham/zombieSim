package models;

import zombieSys.LocalizedArea;

public abstract class AnimateObject extends GameObject
{
  protected LocalizedArea currentArea;
  
  public LocalizedArea getArea()
  {
    return this.currentArea;
  }
  
  public void setArea(LocalizedArea inArea)
  {
    this.currentArea = inArea;
  }
  
  /*
   * perform navigation from here
   */
   
   
   /*
   * perform combat from here
   */
  
}