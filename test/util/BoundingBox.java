package util;

public class BoundingBox
{
	private Rectangle r_;
	
	public Bounding(Rectange r)
	{
		r_ = r;
	}

	protected Point2d proxima(GeoMorph gm)
	{
		Point2d cg = gm.getCentre(), ce = e_.getCentre();
		float d = Math.arcos((cg.getX()-ce.getX())/Point2d.distance(cg,ce)) + Math.PI;
		return cg.pointBordure(d);
	}

	public boolean estEnCollision(Bounding b)
	{
		return estEnCollision(b.proxima(e_));
	}

	public boolean estEnCollision(Point2d p)
	{
		float d = Math.arcos((p.getX()-e_.getCentre().getX())
					/Point2d.distance(p,e_));
		Point2d pb = e_.pointBordure(d);	
		return (pb.getX()>=p.getX() && pb.getY()>= p.getY());
	}
}
