package notification;

import java.util.EventListener;

public interface CombatListener extends EventListener
{
	public void objectAttacking(CombatEvent e);
}
