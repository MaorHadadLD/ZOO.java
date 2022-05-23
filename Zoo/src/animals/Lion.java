package animals;
import mobility.Point;
import diet.Carnivore;
import diet.IDiet;
import food.*;
import graphics.Graphics;

import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JTextField;

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
	
	public Lion(int size, String color, int horSpeed, int verSpeed)
	{
		super(stratLOcation,size,color,horSpeed,verSpeed);
		super.setDiet(lionDiet);
		super.setWeight(size * 0.8);
	}
	
	public int getScars()
	{
		MessageUtility.logGetter(this.getName(), "getScars()", this.scarCount);
		return this.getScars();
	}
	
	public EFoodType getFoodtype()
	{
		return EFoodType.NOTFOOD;
	}
	
	public boolean eat(IEdible food)
	{
		double newWeight = super.getDiet().eat(this, food);
		if(newWeight > 0.0)
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
	
	public void roar()
	{
		MessageUtility.logSound(super.getName(), "Roar, then stretches and shakes its mane");
	}
	
	public String toString()
	{
		return "[Lion]:" + this.getName();
	}

	@Override
//	public void loadmages(String nm) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void drawObject(Graphics2D g) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setLocation(Point newLocation) {
		
		return true;
	}

}
