package mobility;

public class Point {
	
	private int x,y;
	private static final int maxX=800,maxY=600;
	
	public Point()
	{
		this.x=0;
		this.y=0;
	}
	
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Point(Point p1)
	{
		this.x=p1.getx();
		this.y=p1.gety();
	}
	
	public int getx()
	{
		return this.x;
	}
	
	public int gety()
	{
		return this.y;
	}
	
	public boolean checkBoundaries(Point p)
	{
		if(p.getx()<0||p.getx()>maxX||p.gety()<0||p.gety()>maxY)
		{
			return false;
		}
		return true;
	}
	
	public String getPoint()
	{
		return this.x + ", " + this.y;
	}

	public static boolean cheackBounderies(Point newLocation) {
		// TODO Auto-generated method stub
		return false;
	}

}
