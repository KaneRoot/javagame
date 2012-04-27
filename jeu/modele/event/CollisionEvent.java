package modele.event;

import util.Vector2f;
import java.util.EventObject;

public class CollisionEvent extends EventObject
{
	private Vector2f v_;

	public CollisionEvent (Object source, Vector2f v)
	{
		super(source);
		v_ = v;
	}

	public Vector2f getVector()
	{
		return v_;
	}
}
