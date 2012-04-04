package modele.listener;

import java.util.EventListener;
import modele.event.MouvementEvent;

public interface MouvementListener extends EventListener
{
	public void enMouvement(MouvementEvent event);
}
