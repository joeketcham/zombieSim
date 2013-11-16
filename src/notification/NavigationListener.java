package notification;
import java.util.EventListener;

public interface NavigationListener extends EventListener
{
	public void objectNavigated(NavigationEvent e);
}
