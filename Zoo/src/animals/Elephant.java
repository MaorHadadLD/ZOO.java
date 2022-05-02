package animals;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import mobility.Point;
import utilities.MessageUtility;


public class Elephant extends Chew{
	
	private double trunkLength;
	private final static Point startLocation = new Point(50, 90);
	private final static IDiet elephantDiet = new Herbivore();
	
	public Elephant(String name)
	{
		super(name, startLocation);
		super.setWeight(500.0);
		super.setDiet(elephantDiet);
		setTrunkLength(1.0);
		MessageUtility.logConstractor("Elephant", name);
	}
	
	public Elephant(String name, Point point1)
	{
		super(name,startLocation);
		super.setWeight(500.0);
		super.setDiet(elephantDiet);
		setTrunkLength(1.0);
		MessageUtility.logConstractor("Elephant", name);
		
	}
	
	public Elephant(int size,String color,int hoerSpeed,int verSpeed)
	{
		super(startLocation,size,color,hoerSpeed,verSpeed);
		super.setDiet(elephantDiet);
		super.setWeight(size * 10);
	}
	
	public boolean setTrunkLength(double trunkl)
	{
		if(trunkl > 3.5 || trunkl < 0.5)
		{
			MessageUtility.logSetter(getName(), "setTrunkLength()", trunkl, false);
			return false;
		}
		else
		{
			this.trunkLength = trunkl;
			return true;
		}
		
	}
	
	public double getTrunkLength()
	{
		MessageUtility.logGetter(getName(), "getTrunkLength()", this.trunkLength);
		return this.trunkLength;
	}
	
	public EFoodType getFoodtype()
	{
		return EFoodType.MEAT;
	}
	
	public boolean eat(IEdible food)
	{
		double elephantWeight = super.getDiet().eat(this, food);
		if(elephantWeight > 0.0)
		{
			super.makeSound();
			super.setWeight(elephantWeight);
			return true;
		}
		return false;
	}
	
	public void chew()
	{
		MessageUtility.logSound(super.getName(), "Trumpets with joy while flapping its ears, then chews");
	}
	
	public String toString()
	{
		return "[Elephant]:" + this.getName();
	}

}
