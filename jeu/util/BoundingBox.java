package util;

public class BoundingBox extends Bounding
{
	private Rectangle r_;
	
	public BoundingBox(Rectangle r)
	{
		r_ = r;
	}

	protected Point2d proxima(GeoMorph gm)
	{
		Point2d cg = gm.getCentre(), ce = r_.getCentre();
		float d = (float)Math.acos((cg.getX()-ce.getX())/Point2d.distance(ce,cg)) + (float)Math.PI;

		if (cg.getX()<=ce.getX()&&cg.getY()>=ce.getY())
			d+=Math.PI/2;
		else if (cg.getX()<=ce.getX()&&cg.getY()<=ce.getY())
			d+=Math.PI;
		else if (cg.getX()>=ce.getX()&&cg.getY()>=ce.getY())
			d+=3*Math.PI/2;

		return r_.pointBordure(d);
	}
	
	public boolean estEnCollision(Bounding b)
	{
		return estEnCollision(b.proxima(r_));
	}

	public boolean estEnCollision(Point2d p)
	{
		float d = (float)Math.acos((p.getX()-r_.getCentre().getX())/Point2d.distance(r_.getCentre(),p));
		if (p.getX()<=r_.getCentre().getX()&&p.getY()>=r_.getCentre().getY())
			d+=(float)Math.PI/2;
		else if (p.getX()<=r_.getCentre().getX()&&p.getY()<=r_.getCentre().getY())
			d+=(float)Math.PI;
		else if (p.getX()>=r_.getCentre().getX()&&p.getY()>=r_.getCentre().getY())
			d+=3*(float)Math.PI/2;

		Point2d pb1 = r_.pointBordure(d), pb2 = r_.pointBordure(d+(float)Math.PI);

		System.out.print("Proxima de l'objet : ("+p.getX()+","+p.getY()+")\nBounding bordure1 : ("+pb1.getX()+","+pb1.getY()+
						")\nBounding bordure2 : ("+pb2.getX()+","+pb2.getY()+")\n\n");
		return (pb1.getX()>=p.getX() && pb2.getX()<= p.getX() && pb1.getY()>=p.getY() && pb2.getY()<= p.getY());
	}
}
