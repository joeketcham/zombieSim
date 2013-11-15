package notification;

import java.util.EventObject;

public class CombatEvent extends EventObject
{
  private static final long serialVersionUID = 7526472295622776147L;
  
  public CombatEvent(Object source)
  {
    super(source);
  }
}