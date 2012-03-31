package util;



public class BoundingEllipse extends Bounding
{
	private Ellipse e_;

	public BoundingEllipse(Ellipse e)
	{
		e_ = e;	
	}
	
	public boolean estEnCollision(Point2d p)
	{
		float d = Math.arcos(p.getX()-e_.getCentre()
					/Point2d.distance(p,e_));
		Point2d pb = e_.pointBordure(d);	
		return (pb.getX()>=p.getX() && pb.getY()>= p.getY());
	}
}
