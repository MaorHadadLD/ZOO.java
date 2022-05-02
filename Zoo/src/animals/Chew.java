package animals;
import mobility.Point;

public abstract class Chew extends Animal{
	
	public Chew(String name, Point location)
	{
		super(name,location);
	}
	
	public Chew(Point startLocation, int size, String color, int hoerSpeed, int verSpeed) {
		
		super(startLocation,size,color,hoerSpeed,verSpeed);
	}

	public abstract void chew();
	
	public void makeSound()
	{
		chew();
	}

}
