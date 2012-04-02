package util;

public abstract class Bounding
{
	protected abstract Point2d proxima(GeoMorph gm);
	public abstract boolean estEnCollision(Bounding b);
	public abstract boolean estEnCollision(Point2d p);
}
