package animals;
import mobility.Point;

public abstract class Roar extends Animal{
	
	public Roar(String name, Point location)
	{
		super(name,location);
	}
	
public Roar(Point startLocation, int size, String color, int hoerSpeed, int verSpeed) {
		
		super(startLocation,size,color,hoerSpeed,verSpeed);
	}
	
	public abstract void roar();
	
	public void makeSound()
	{
		roar();
	}

}
