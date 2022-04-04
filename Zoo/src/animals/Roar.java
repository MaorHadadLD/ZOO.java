package animals;
import mobility.Point;

public abstract class Roar extends Animal{
	
	public Roar(String name, Point location)
	{
		super(name,location);
	}
	
	public abstract void roar();
	
	public void makeSound()
	{
		roar();
	}

}
