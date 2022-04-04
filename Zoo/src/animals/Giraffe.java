package animals;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import mobility.Point;
import utilities.MessageUtility;
import java.util.Random;

public class Giraffe extends Chew{
	
	private double neckLength;
	private final static Point startLocation = new Point(50, 0);
	private final static IDiet giraffeDiet = new Herbivore();
	
	public Giraffe(String name)
	{
		 super(name, startLocation);
		 super.setWeight(450.0);
		 super.setDiet(giraffeDiet);
		 setNeckLength(1.5);
		 MessageUtility.logConstractor("Giraffe", name);
	}
	
	public Giraffe(String name, Point point1)
	{
		super(name, startLocation);
		super.setWeight(450.0);
		super.setDiet(giraffeDiet);
		setNeckLength(1.5);
		MessageUtility.logConstractor("Giraffe", name);
	}
	
	public boolean setNeckLength(double neckl)
	{
		if(neckl < 1.0 || neckl > 2.5)
		{
			MessageUtility.logSetter(getName(), "setNeckLength()", neckl, false);
			return false;
		}
		else
		{
			this.neckLength = neckl;
			MessageUtility.logSetter(getName(), "setNeckLength()", neckl, true);
			return true;
		}
	}
	
	public double getNeckLength()
	{
		MessageUtility.logGetter(getName(), "getNeckLength()", this.neckLength);
		return this.neckLength;
	}
	
	public EFoodType getFoodType()
	{
		return EFoodType.MEAT;		
	}
	
	public boolean eat(IEdible food)
	{
		double giraffeWeight = super.getDiet().eat(this, food);
		if(giraffeWeight > super.getWeight())
		{
			super.makeSound();
			super.setWeight(giraffeWeight);
			return true;
		}
		return false;
	}
	
	public void chew()
	{
		MessageUtility.logSound(getName(), "Bleats and Stomps its legs, then chews");
	}
	
	public String toString()
	{
		return this.getName();
	}

}
