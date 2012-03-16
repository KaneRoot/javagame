package evenement;
import java.util.EventListener;

public interface MouvementListener extends EventListener
{
	public void enMouvement(MouvementEvent event);
	
}
