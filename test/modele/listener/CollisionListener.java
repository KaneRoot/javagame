package modele.listener;

import java.util.EventListener;
import modele.event.CollisionEvent;

public interface CollisionListener extends EventListener
{
	public void enCollision(CollisionEvent event);
}
