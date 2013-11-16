package zombieSys;
import java.util.HashMap;

import notification.CombatEvent;
import notification.CombatListener;
import models.AnimateObject;
import models.GameObject;

public class LocalizedArea implements CombatListener
{
	HashMap<String, GameObject> contents; //String direction, Integer location ID
	Double idArea;
		
	public LocalizedArea(Double area)
	{
		this.idArea = area;
		contents = new HashMap<String, GameObject>();
	}
	
	public void addObject(GameObject theObject)
	{
		contents.put(theObject.getName(), theObject);
		theObject.setLocation(this.idArea);		
	}
	
	public void removeObject(String name)
	{
		if (contents.containsKey(name))
		{
			contents.remove(name);
		}
	}
	
	public GameObject getObject(String name)
	{
		if (contents.containsKey(name))
		{
			return contents.get(name);
		}
		
		return null;
	}

	@Override
	public void objectAttacking(CombatEvent e)
	{
		if (contents.containsKey(e.getDefender()))
		{
			if (contents.get(e.getDefender()) instanceof AnimateObject)
			{
				AnimateObject defender = (AnimateObject) contents.get(e.getDefender());
				defender.defend(e.getSourceObject().getAttackPower());
			}
		}		
	}
}
