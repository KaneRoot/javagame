



public class Ellipse
{
	
	private Point2d f1_,f2_; // les deux foyer
	private a_,b_; // a_ demi grand axe, b_ demi petit axe
	
	public Ellipse(Point2d f1, Point2d f2, int a, int b)
	{
		f1_ = f1;
		f2_ = f2;
		a_ = a;
		b_ = b;
	}

	public Ellipse()
	{
		this(new Point2d(),new Point2d(),0,0);
	}	

}
