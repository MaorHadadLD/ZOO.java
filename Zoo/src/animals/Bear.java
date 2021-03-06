package animals;
import diet.Omnivore;

import diet.IDiet;
import food.*;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

public class Bear extends Roar{
	
	private String furcolor;
	private final static IDiet bearDiet = new Omnivore();
	private final static Point stratLocation = new Point(100, 5);
	
	public Bear(String name)
	{
		super(name, stratLocation);
		super.setWeight(308.7);
		super.setDiet(bearDiet);
		setFurColor("GRAY");
		MessageUtility.logConstractor("Bear", name);
	}
	
	public Bear(String name, Point point1)
	{
		super(name, point1);
		super.setWeight(308.7);
		super.setDiet(bearDiet);
		setFurColor("GRAY");
		MessageUtility.logConstractor("Bear", name);
	}
	
	public Bear(int size,String color,int hoerSpeed,int verSpeed, ZooPanel zoo)
	{
		super(stratLocation,size,color,hoerSpeed,verSpeed, zoo);
		super.setDiet(bearDiet);
		super.setWeight(size * 1.5);
	}
	
	public boolean setFurColor(String furColor)
	{
		if(furColor.equals("GRAY") || furColor.equals("WHITE") || furColor.equals("BLACK"))
		{
			this.furcolor = furColor;
			MessageUtility.logSetter(getName(), "setFurColor()", furColor, true);
			return true;
		}
		else
		{
			MessageUtility.logSetter(getName(), "setFurColor()", furColor, false);
			return false;
		}
	}
	
	public String getFurColor()
	{
		MessageUtility.logGetter(getName(), "getFurColor()", this.furcolor);
		return this.furcolor;
	}
	
	public EFoodType getFoodtype()
	{
		return EFoodType.MEAT;
	}
	
	public boolean eat(IEdible food)
	{
		double baerWeight = super.getDiet().eat(this, food);
		if(baerWeight > 0.0)
		{
			super.makeSound();
			super.setWeight(baerWeight);
			return true;
		}
		return false;
	}
	
	public void roar()
	{
		MessageUtility.logSound(super.getName(), "Stands on its hind legs, roars and scraches its belly");
	}
	
	public String toString()
	{
		return "[Bear]:" + this.getName();
	}

	@Override
	public boolean setLocation(Point newLocation) {
		// TODO Auto-generated method stub
		return true;
	}

//	@Override
//	public void loadmages(String nm) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public String getColor() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setSuspended() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setResumed() {
//		// TODO Auto-generated method stub
//		
//	}
//	

}
