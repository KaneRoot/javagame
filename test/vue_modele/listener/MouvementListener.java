package vue_modele.listener;

import java.util.EventListener;
import vue_modele.event.MouvementEvent;

public interface MouvementListener extends EventListener
{
	public void enMouvement(MouvementEvent event);
	
}
