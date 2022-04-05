package mobility;
import java.lang.Math;
import utilities.MessageUtility;

public abstract class Mobile implements Ilocatable{
	
	private Point location;
	private double totalDistance;
	
	public Mobile(Point p)
	{
		if(setLocation(p))
		{
			this.location=new Point(p);
		}
		this.totalDistance=0;
	}
	
	public void addTotalDistance(double d1)
	{
		this.totalDistance += d1;
	}
	
	public double calcDistance(Point p2)
	{
		return Math.sqrt(Math.pow(this.location.getx() - p2.getx(),2) + Math.pow(this.location.gety() - p2.gety(),2));
	}
	
	public Point getLocation()
	{
		return this.location;
	}
	
	public boolean setLocation(Point p)
	{
		return true;
	}
	
	public boolean setTotalDistance(double d)
	{
		if(d > 0)
		{
			this.totalDistance = d;
			return true;
		}
		return false;
	}
	
	public double getTotalDistanc()
	{
		return this.totalDistance;
	}

}
