package notification;

import java.util.EventObject;

import models.AnimateObject;

public class CombatEvent extends EventObject
{
	AnimateObject source;
	String defender;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7120758591189966073L;

	public CombatEvent(AnimateObject obj)
	{
		super(obj);
		this.source = obj;
	}
	
	public void setDefender(String inDefender)
	{
		this.defender = inDefender;
	}
	
	public String getDefender()
	{
		return this.defender;
	}
	
	public AnimateObject getSourceObject()
	{
		return this.source;
	}
}
