package util;


public class Ellipse extends GeoMorph
{
	
	private Point2d o_;	// Centre de l'ellipse
	private int a_,b_;	// a_ demi grand axe, b_ demi petit axe
	
	public Ellipse(Point2d o, int a, int b)
	{
		o_ = o;
		a_ = a;
		b_ = b;
	}

	public Ellipse(Point2d f1, Point2d f2, int a, int b)
	{
		this(Point2d.milieu(f1,f2),a_,b_);
	}

	public Ellipse()
	{
		this(new Point2d(),0,0);
	}	

	public Point2d pointBordure(float t)
	{
		return new Point2d((int)(o_.getX()+a_*Math.cos(t)),
					(int)(o_.getY()+b_*Math.sin(t)));
	}	
	
	public Point2d getCentre()
	{
		return o_;
	}	

}
