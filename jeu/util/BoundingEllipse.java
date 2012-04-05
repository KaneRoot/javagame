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
		float d = (float)Math.acos((cg.getX()-ce.getX())/Point2d.distance(ce,cg)) + (float)Math.PI;
		return e_.pointBordure(d);
	}
	
	public boolean estEnCollision(Bounding b)
	{
		return estEnCollision(b.proxima(e_));
	}

	public boolean estEnCollision(Point2d p)
	{
		float d = (float)Math.acos((p.getX()-e_.getCentre().getX())/Point2d.distance(e_.getCentre(),p));
		Point2d pb1 = e_.pointBordure(d), pb2 = e_.pointBordure(d+(float)Math.PI);

		System.out.print("Proxima de l'objet : ("+p.getX()+","+p.getY()+")\nBounding bordure1 : ("+pb1.getX()+","+pb1.getY()+
						")\nBounding bordure2 : ("+pb2.getX()+","+pb2.getY()+")\n\n");
		return (pb1.getX()>=p.getX() && pb2.getX()<= p.getX() && pb1.getY()>=p.getY() && pb2.getY()<= p.getY());
	}

}
