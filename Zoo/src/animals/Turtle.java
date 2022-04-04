package animals;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import mobility.Point;
import java.util.Random;
import utilities.MessageUtility; 

public class Turtle extends Chew{
	
	private int age;
	private final static Point startLocation = new Point(80, 0);
	private final static IDiet turtleDite = new Herbivore();
	
	public Turtle(String name)
	{
		super(name, startLocation);
		super.setWeight(1.0);
		super.setDiet(turtleDite);
		setAge(1);
		MessageUtility.logConstractor("Turtle", name);
		
	}
	
	public Turtle(String name, Point point1)
	{
		super(name, point1);
		super.setWeight(1.0);
		super.setDiet(turtleDite);
		setAge(1);
		MessageUtility.logConstractor("Turtle", name);
	}
	
	public boolean setAge(int turtleAge)
	{
		if(turtleAge > 500 || turtleAge < 0)
		{
			MessageUtility.logSetter(getName(), "setAge", turtleAge, false);
			return false;
		}
		else
		{
			MessageUtility.logSetter(getName(), "setAge", turtleAge, true);
			return true;
		}
	}
	
	public int getAge()
	{
		MessageUtility.logGetter(super.getName(), "getAge", this.age);
		return this.age;
	}
	
	public EFoodType getFoodType()
	{
		return EFoodType.MEAT;
	}
	
	public boolean eat(IEdible food)
	{
		double turtleWeight = super.getDiet().eat(this, food);
		if(turtleWeight > super.getWeight())
		{
			super.makeSound();
			super.setWeight(turtleWeight);
			return true;
		}
		return false;
	}
	
	public void chew()
	{
		MessageUtility.logSound(getName(), "Retracts its head in then eats quietly");
	}
	
	public String toString()
	{
		return this.getName();
	}

}
