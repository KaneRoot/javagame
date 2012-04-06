package util;


public abstract class GeoMorph
{
	public abstract Point2d pointBordure(double t);
	public abstract Point2d getCentre();

	public boolean intersection(GeoMorph g)
	{
		float a = g.getCentre().getX()-this.getCentre().getX(),
		      b = Point2d.distance(g.getCentre(),this.getCentre());

		if (b>0)
		{
			double d = Math.acos(a/b);
			if (g.getCentre().getY()<this.getCentre().getY())
				d = d+Math.PI;

			Point2d p1 = pointBordure(d),
				p2 = pointBordure(d+Math.PI),
				p3 = g.pointBordure(d+Math.PI);
			System.out.print("\n\n----\nPoint1 = ("+p1.getX()+","+p1.getY()+")\nPoint2 = ("+p2.getX()+","+p2.getY()+
						")\nPoint3 = ("+p3.getX()+","+p3.getY()+")\n");
			return intersection(p1,p2,p3);	
		}
		else
			return true;
	}

	public boolean intersection(Point2d p1, Point2d p2, Point2d p3)
	{
		if (p1.getX()>=p2.getX() && p1.getY()>=p2.getY())
			return (p1.getX()>=p3.getX() && p2.getX()<=p3.getX() &&
				p1.getY()>=p3.getY() && p2.getY()<=p3.getY());
		else if (p1.getX()>=p2.getX() && p1.getY()<=p2.getY())
			return (p1.getX()>=p3.getX() && p2.getX()<=p3.getX() &&
				p1.getY()<=p3.getY() && p2.getY()>=p3.getY());
		else if (p1.getX()<=p2.getX() && p1.getY()<=p2.getY())
			return (p1.getX()<=p3.getX() && p2.getX()>=p3.getX() &&
				p1.getY()<=p3.getY() && p2.getY()>=p3.getY());
		else
			return (p1.getX()<=p3.getX() && p2.getX()>=p3.getX() &&
				p1.getY()>=p3.getY() && p2.getY()<=p3.getY());
	}

}
