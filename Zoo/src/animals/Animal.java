package animals;
import food.IEdible;
import diet.IDiet;

public abstract class Animal extends Mobile implements IEdible {
	private String name;
	private double weight;
	private IDiet diet;
	
	public static final Point()
	
	public Animal(String name, Point location)
	{
		super(location);
		this.name = name;
		this.weight = weight;
	}
	
	public abstract void makeSound();

}
