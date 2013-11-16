package notification;

import java.util.EventObject;

import models.*;

public class NavigationEvent extends EventObject
{
	/**
	 * Default serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	String direction;
	AnimateObject animatedObject;
	
	public NavigationEvent(AnimateObject obj)
	{
		super(obj);
		this.animatedObject = obj;
	}
	
	public void setDirection(String inDirection)
	{
		this.direction = inDirection;
	}
	
	public String getDirection()
	{
		return this.direction;
	}
	
	public AnimateObject getAnimatedObject()
	{
		return this.animatedObject;
	}
}
