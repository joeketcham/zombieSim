package notification;

import java.util.EventObject;

public class NavigateEvent extends EventObject
{
  private static final long serialVersionUID = 7526472295622776147L;
  
  public NavigateEvent(Object source)
  {
    super(source);
  }
}