package animals;
import javax.swing.JTextField;

import graphics.ZooPanel;
import mobility.Point;

public abstract class Roar extends Animal{
	
	public Roar(String name, Point location)
	{
		super(name,location);
	}
	
    public Roar(Point startLocation, int size, String color, int hoerSpeed, int verSpeed, ZooPanel zoo) {
		
		super(startLocation,size,color,hoerSpeed,verSpeed, zoo);
	}
	
	public abstract void roar();
	
	
	public void makeSound()
	{
		roar();
	}
	
	public boolean move(Point pointA)
	{
		double distance1 = calcDistance(pointA);
		if(distance1 > 0)
		{
			super.setLocation(pointA);
			super.setTotalDistance(distance1);
			this.weight -= (distance1 * weight * 0.00025);
			return true;
		}
		return false;
	}

}
