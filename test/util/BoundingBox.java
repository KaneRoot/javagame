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
		return null;
	}

	public boolean estEnCollision(Bounding b)
	{
		return false;
	}

	public boolean estEnCollision(Point2d p)
	{
		return false;
	}
}
