package animals;
import mobility.Point;
import diet.Carnivore;
import diet.IDiet;
import food.*;
import java.util.Random;
import utilities.MessageUtility;

public class Lion extends Roar{
	
	private int scarCount;
	private final static IDiet lionDiet = new Carnivore();
	private final static Point stratLOcation = new Point(20,0);
	
	public Lion(String name)
	{
		super(name,stratLOcation);
		super.setWeight(408.2);
		super.setDiet(lionDiet);
		this.scarCount = 0;
		MessageUtility.logConstractor("Lion", name);
	}
	
	public Lion(String name, Point point)
	{
		super(name,point);
		super.setWeight(408.2);
		this.scarCount = 0;
		MessageUtility.logConstractor("Lion", name);
	}
	
	public int getScars()
	{
		MessageUtility.logGetter(this.getName(), "getScars()", this.scarCount);
		return this.getScars();
	}
	
	public EFoodType getFoodType()
	{
		return EFoodType.NOTFOOD;
	}
	
	public boolean eat(IEdible food)
	{
		double newWeight = super.getDiet().eat(this, food);
		if(newWeight > super.getWeight())
		{
			Random scars = new Random();
			this.scarCount = scars.nextInt(scarCount, scarCount + 1);
			super.makeSound();
			super.setWeight(newWeight);
			return true;
		}
		return false;
	}
	
	public boolean setScars(int scars1)
	{
		if(scars1 > 0)
		{
			this.scarCount = scars1;
			MessageUtility.logSetter(getName(), "setScars()", scars1, true);
			return true;
		}
		MessageUtility.logSetter(getName(), "setScars", scars1, false);
		return false;
	}
	
	public void Roar()
	{
		MessageUtility.logSound(super.getName(), "Roar, then stretches and shakes its mane");
	}
	
	public String toString()
	{
		return this.getName();
	}
	
	

}
