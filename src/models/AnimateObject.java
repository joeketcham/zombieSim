package models;

import notification.*;

public abstract class AnimateObject extends GameObject
{
	NavigationEvent nav;
	NavigationListener navListener;
	CombatEvent combat;
	CombatListener combatLis;
	int power;
	int health;
	
	Double location;
	
	public abstract int getAttackPower();
	public abstract void defend(int inAttack);
	
	public AnimateObject(String inName, int inPower, int inHealth)
	{
		super(inName);
		this.power = inPower;
		this.health = inHealth;
		this.nav = new NavigationEvent(this);
		this.combat = new CombatEvent(this);
	}
	
	public int getHealth()
	{
		return this.health;
	}

	//**********************************************************
	// * Navigation Event Handling
	// *********************************************************
	public NavigationEvent getNavigationEvent()
	{
		return this.nav;
	}
	
	public void addNavigateListener(NavigationListener inListener)
	{
		navListener = (inListener);
	}
	
	public void removeNavigateListener(NavigationListener inListener)
	{
		navListener = null;
	}
	
	public void navigate(String direction)
	{
		nav.setDirection(direction);
		fireNavigate();
	}

	protected void fireNavigate()
	{
		if (navListener != null)
		{
			navListener.objectNavigated(nav);
		}
	}
	//End Navigation Event Handling
	//**********************************************************
	
	//**********************************************************
	// * Combat Event Handling
	// *********************************************************
	public CombatEvent getCombatEvent()
	{
		return this.combat;
	}
	
	public void addCombatListener(CombatListener inListener)
	{
		this.combatLis = (inListener);
	}
	
	public void removeCombatListener(CombatListener inListener)
	{
		this.combatLis = null;
	}
	
	public void attack(String entity)
	{
		this.combat.setDefender(entity);
		fireAttack();
	}

	protected void fireAttack()
	{
		if (combatLis != null)
		{
			combatLis.objectAttacking(this.combat);
		}
	}
	//End Combat Event Handling
	//**********************************************************
}
