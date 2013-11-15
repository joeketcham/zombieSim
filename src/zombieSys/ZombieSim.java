package zombieSys;
import java.util.HashMap;
import java.util.ArrayList;

import notification.*;
import models.*;

public class ZombieSim implements NavigationListener
{
	HashMap<Double, LocalizedArea> rooms;
	
	public ZombieSim(ArrayList<Double> rList)
	{
		rooms = new HashMap<Double, LocalizedArea>();
		for(Double d: rList)
		{
			rooms.put(d, new LocalizedArea(d));
		}
	}
	
	public void placeObject(Double loc, GameObject objectToPlace)
	{
		if(rooms.containsKey(loc))
		{
			rooms.get(loc).addObject(objectToPlace);
		}
		if (objectToPlace instanceof AnimateObject)
		{
			//need to check if listener is already assigned
			((AnimateObject) objectToPlace).addNavigateListener(this);
		}
	}
	
	public void objectNavigated(NavigationEvent e)
	{
		double area = e.getAnimatedObject().getLocation();
		double z = area % 100;
		double x = (area - z) % 10000;
		double y = (area - z - x) % 1000000;
		double navigateTo = verifyArea(findDirectionDelta(e.getDirection()), x, y, z);
		if (navigateTo == -1)
		{
			//return "You can not navigate there";
			//fire message event for user
		}
		else if (navigateTo <= -9999998.00)
		{
			//return "You can not go that way";
			//fire message event for user
		}
		else
		{
			if(!rooms.containsKey(navigateTo))
			{
				//return "Room does not exist";
				//fire message event for user
			}
			else
			{
				e.getAnimatedObject().removeCombatListener(rooms.get(area));
				rooms.get(area).removeObject(e.getAnimatedObject().getName());
				rooms.get(navigateTo).addObject(e.getAnimatedObject());
				e.getAnimatedObject().addCombatListener(rooms.get(navigateTo));
				
				//return "Moved " + e.getDirection();
				//wire new message and combat event and listeners
				//fire message event for user
			}
		}
	}
	
	private Double findDirectionDelta(String direction)
	{
		double mapDelta = 0.00;
		if(direction == "u")
		{
			mapDelta += 1.00;
		}
		else if(direction == "d")
		{
			mapDelta -= 1.00;
		}
		else if(direction == "e")
		{
			mapDelta += 100.00;
		}
		else if(direction == "w")
		{
			mapDelta -= 100.00;
		}
		else if(direction == "n")
		{
			mapDelta += 10000.00;
		}
		else if(direction == "s")
		{
			mapDelta -= 10000.00;
		}
		else
		{
			mapDelta = -99999999.00;
		}
		return mapDelta;
	}
	
	private Double verifyArea(double directionDelta, double x, double y, double z)
	{
		if(directionDelta == 1.00 || directionDelta == -1.00)
		{
			if (z + directionDelta < 0.00 || z + directionDelta == 100.00)
			{
				return -1.00;
			}
		}
		else if(directionDelta == 100.00 || directionDelta == -100.00)
		{
			if (x + directionDelta == 99.00 || x + directionDelta == 10000.00 || x + directionDelta < 0.00)
			{
				return -1.00;
			}
		}
		else if(directionDelta == 10000.00 || directionDelta == -10000.00)
		{
			if (y + directionDelta == 1000000.00 || y + directionDelta == 9900.00 || y + directionDelta < 0)
			{
				return -1.00;
			}
		}
		
		return y + x + z + directionDelta;
	}
	
	public GameObject getObjectFromRoom(double room, String objName)
	{
		if (this.rooms.containsKey(room))
		{
			return this.rooms.get(room).getObject(objName);
		}
		
		return null;
	}
}
