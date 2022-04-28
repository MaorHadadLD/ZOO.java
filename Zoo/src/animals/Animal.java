package animals;
import food.*;
import mobility.*;
import diet.IDiet;
import utilities.MessageUtility;
import graphics.*;

public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior{
	private String name;
	private double weight;
	private IDiet diet;
	private final int EATÉDISTANCE = 5;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	private Thread thread;
	private int x_dir;
	private int y_dir;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
	
	
	
	public Animal(String name, Point location)
	{
		super(location);
		setName(name);
		this.coordChanged = false;
		this.eatCount = 0;
		MessageUtility.logConstractor("Animal", name);
		
	}
	
	public Animal(Point point, int size, String col, int horSpeed, int verSpeed)
	{
		super(point);
		setName(" ");
		this.coordChanged = false;
		this.eatCount = 0;
		this.col = col;
		this.horSpeed = horSpeed;
		this.verSpeed = verSpeed;
	}
	
	public double getWeight()
	{
		MessageUtility.logGetter(name, "getWeight()", this.weight);
		return this.weight;
	}
	
	public String getName()
	{
		MessageUtility.logGetter(name, "getNmae()", this.name);
		return this.name;
	}
	
	public boolean setWeight(double weight1)
	{
		if(weight1 > 0.0)
		{
			this.weight = weight1;
			MessageUtility.logSetter(name, "setWeight()", weight1, true);
			return true;
		}
		MessageUtility.logSetter(name, "setWeight()", weight1, false);
		return false;
	}
	
	public boolean setName(String name)
	{
		this.name = name;
		MessageUtility.logSetter(name, "setNmae()", name, true);
		return true;
	}
	
	public boolean setDiet(IDiet diet1)
	{
		this.diet = diet1;
		MessageUtility.logSetter(name, "setDiet()", diet1.getClass().getSimpleName(), true);
		return true;
	}
	
	public IDiet getDiet()
	{
		MessageUtility.logGetter(name, "getDiet()", this.diet);
		return this.diet;
	}
	
	public double move(Point point1)
	{
		double distance1 = calcDistance(point1);
		if(distance1 > 0)
		{
			super.setLocation(point1);
			super.setTotalDistance(distance1);
			this.weight -= (distance1 * weight * 0.00025);
		}
		return distance1;
	}
	
	public abstract void makeSound();
	
	public abstract boolean eat(IEdible food);
	
	public abstract String toString();
	
	public int getEatCount()
	{
		return this.eatCount;
	}
	
	public void setEatCount()
	{
		this.eatCount += 1;
	}
	
	public boolean getChanges()
	{
		return this.coordChanged;
	}
	
	public void setChanges(boolean state)
	{
		if(state)
		{
			this.coordChanged = true;
		}
	}
	
	public String getAnimalName()
	{
		return this.name;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void eatInc()
	{
		this.eatCount++;
	}

}
