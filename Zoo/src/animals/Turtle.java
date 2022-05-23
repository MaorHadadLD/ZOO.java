package animals;
import diet.Herbivore;
import diet.IDiet;
import food.*;
import graphics.ZooPanel;
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
	
	public Turtle(int size,String color,int hoerSpeed,int verSpeed, ZooPanel zoo)
	{
		super(startLocation,size,color,hoerSpeed,verSpeed, zoo);
		super.setDiet(turtleDite);
		super.setWeight(size * 0.5);
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
	
	public EFoodType getFoodtype()
	{
		return EFoodType.MEAT;
	}
	
	public boolean eat(IEdible food)
	{
		double turtleWeight = super.getDiet().eat(this, food);
		if(turtleWeight > 0.0)
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
		return "[Turtle]:" + this.getName();
	}

//	@Override
//	public boolean setLocation(Point newLocation) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
////	public void loadmages(String nm) {
////		// TODO Auto-generated method stub
////		
////	}
//
//	@Override
//	public String getColor() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
