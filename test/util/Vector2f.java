package util;

public class Vector2f 
{
	private float i_,j_;
	
	public Vector2f (float i, float j)
	{
		setI(i);
		setJ(j);
	}
	
	public Vector2f ()
	{
		this (0f,0f);
	}

	public void setI(float i) 
	{
		this.i_ = i;
	}

	public float getI() 
	{
		return i_;
	}

	public void setJ(float j)
	{
		this.j_ = j;
	}

	public float getJ() 
	{
		return j_;
	}
	
}
