package evenement;

import java.util.EventObject;

import util.Vector2f;

@SuppressWarnings("serial")
public class MouvementEvent  extends EventObject 
{
	private Vector2f v_;
	
	public MouvementEvent(Object source, Vector2f v)
	{
		super(source);
		setVector(v);
	}

	public void setVector(Vector2f v) 
	{
		this.v_ = v;
	}

	public Vector2f getVector()
	{
		return v_;
	}

}
