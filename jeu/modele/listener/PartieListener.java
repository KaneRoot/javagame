package modele.listener;

import java.util.EventListener;
import modele.event.PartieEvent;


public interface PartieListener extends EventListener
{
	public void partie (PartieEvent event);
}
