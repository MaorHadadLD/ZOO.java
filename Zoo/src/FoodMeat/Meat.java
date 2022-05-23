package FoodMeat;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

public class Meat implements IEdible, Ilocatable, IDrawable{
	
	private double height;
	private Point location;
	private double weight;
	private BufferedImage image = null;
	private ZooPanel zooPa;
	
	public Meat(ZooPanel zooP)
	{
		Random rand = new Random();
		this.location = new Point(400, 300);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		this.zooPa = zooP;
		MessageUtility.logConstractor("Meat", "Meat");
	}
	
	public EFoodType getFoodType()
	{
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
		return EFoodType.VEGETABLE;
	}
	
	public double getHeight()
	{
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }
	
	public Point getLocation() 
	{
        return this.location;
    }
	
	public double getWeight() 
	{
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }
	
	public boolean setHeight(double height) 
	{

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }
	
	public boolean setLocation(Point newLocation) 
	{
        boolean isSuccess = newLocation.checkBoundaries(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }
	
	public boolean setWeight(double weight) 
	{
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }
	
	public String toString() 
	{
        return "[" + this.getClass().getSimpleName() + "]";
    }
	
    
    public void loadmages(String nm) {

        try {
            this.image = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + ".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void drawObject(Graphics g) 
    {
        g.drawImage(image,400,300,30,30,zooPa);
        zooPa.managZoo();
    }
    
    public String getColor() 
    {
        return null;
    }
    
    public EFoodType getFoodtype()
    {
        return EFoodType.MEAT;
    }

}
