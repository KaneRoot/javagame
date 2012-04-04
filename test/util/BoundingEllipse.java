package util;


public class BoundingEllipse extends Bounding
{
	private Ellipse e_;

	public BoundingEllipse(Ellipse e)
	{
		e_ = e;	
	}

	protected Point2d proxima(GeoMorph gm)
	{
		Point2d cg = gm.getCentre(), ce = e_.getCentre();
		float d = (float)Math.acos(((cg.getX()-ce.getX())/Point2d.distance(cg,ce))) + (float)Math.PI;
		return gm.pointBordure(d);
	}
	
	public boolean estEnCollision(Bounding b)
	{
		return estEnCollision(b.proxima(e_));
	}

	public boolean estEnCollision(Point2d p)
	{
		float d = (float)Math.acos((p.getX()-e_.getCentre().getX())
					/Point2d.distance(p,e_.getCentre()));
		Point2d pb = e_.pointBordure(d);	
		return (pb.getX()>=p.getX() && pb.getY()>= p.getY());
	}
}
