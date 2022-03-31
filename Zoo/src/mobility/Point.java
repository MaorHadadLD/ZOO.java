package mobility;

public class Point {
	private int x;
	private int y;
	
	public boolean setX(int x)
	{
		
		if(0 < x && x < 800)
		{
			this.x = x;
			return true;
		}
		return false;
		
	}
	
	public boolean serY(int y)
	{
		
		if(0 < y && y < 600)
		{
			this.y = y;
			return true;
		}
		return false;
	}

}
