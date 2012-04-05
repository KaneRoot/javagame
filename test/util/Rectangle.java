package util;


public class Rectangle extends GeoMorph
{

	private Point2d o_; // Centre du rectangle 
	private int a_,b_;  // a_ largeur, b_ hauteur

	public Rectangle(Point2d o, int a, int b)
	{
		o_ = o;
		a_ = a;
		b_ = b; 
	}
	
	public Rectangle()
	{
		this(new Point2d(),0,0);
	}

	public Point2d pointBordure(float t)	
	{
		double pi = Math.PI;
		Point2d p;
		if (t<=pi/4 && t>=(-pi/4))
			p = new Point2d(a_+o_.getX(),o_.getY()+((int)(Math.cos(t)*b_))+b_);
		else if (t>pi/4 && t<=3*pi/4)
			p = new Point2d((int)(Math.cos(t)*a_)+o_.getX(),o_.getY()+b_);
		else if (t>3*pi/4 && t<=5*pi/4)
			p = new Point2d(-a_+o_.getX(),o_.getY()+((int)(Math.sin(t)*b_))+b_);
		else
			p = new Point2d((int)(Math.cos(t)*a_)+o_.getX(),o_.getY()-b_);
		return p;
	}

	public Point2d getCentre()
	{
		return o_;
	}

}
