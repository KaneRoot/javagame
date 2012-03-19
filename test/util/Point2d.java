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
	
	public static int distance(Point2d p1, Point2d p2)
	{
		return (int) Math.sqrt(Math.pow(p1.getX()-p2.getX(),2) + Math.pow(p1.getY()-p2.getY(),2));
	}

	
	
}
