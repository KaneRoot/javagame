package util;

public class Point2d
{
	private int x_,y_;
	
	public Point2d(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public Point2d()
	{
		this(0,0);
	}
	
	/**
	 * Get/Set des champs privée x_ et y_
	 */
	public void setX(int x_) 
	{
		this.x_ = x_;
	}

	public int getX()
	{
		return x_;
	}

	public void setY(int y_)
	{
		this.y_ = y_;
	}

	public int getY()
	{
		return y_;
	}
	
	

}
