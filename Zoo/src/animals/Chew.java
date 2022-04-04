package animals;
import mobility.Point;

public abstract class Chew extends Animal{
	
	public Chew(String name, Point location)
	{
		super(name,location);
	}
	
	public abstract void chew();
	
	public void makeSound()
	{
		chew();
	}

}
