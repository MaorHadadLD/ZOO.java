package animals;
import food.*;

import mobility.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import diet.IDiet;
import utilities.MessageUtility;
import graphics.*;

public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior{
	private String name;
	protected double weight;
	private IDiet diet;
	private final int EATÉDISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	protected Thread thread;
	protected boolean threadSuspended = false;
	private int x_dir;
	private int y_dir;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
	private int xcor, ycor;
	
	
	
	public Animal(String name, Point location)
	{
		super(location);
		setName(name);
		this.coordChanged = false;
		this.eatCount = 0;
		MessageUtility.logConstractor("Animal", name);
		
	}
	
	public Animal(Point point, int size, String col, int horSpeed, int verSpeed, ZooPanel zooP)
	{
		super(point);
		setName(" ");
		this.coordChanged = false;
		this.eatCount = 0;
		this.col = col;
		this.horSpeed = horSpeed;
		this.verSpeed = verSpeed;
		this.size = size;
		this.pan = zooP;
	}
	
    public void Animal1(Point startLocation, int size, String color, int hoerSpeed, int verSpeed) {
		
    	Animal1(startLocation,size,color,hoerSpeed,verSpeed);
	}
	
	public double getWeight()
	{
		MessageUtility.logGetter(name, "getWeight()", this.weight);
		return this.weight;
	}
	
	public String getName()
	{
		MessageUtility.logGetter(name, "getName()", this.name);
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
	
	public boolean move(Point pointA)
	{
		double distance1 = calcDistance(pointA);
		if(distance1 > 0)
		{
			super.setLocation(pointA);
			super.setTotalDistance(distance1);
			this.weight -= (distance1 * weight * 0.00025);
			return true;
		}
		return false;
	}
	
	public abstract void makeSound();
	
	public abstract boolean eat(IEdible food);
	
	public abstract String toString();
	
	public int getEatCount()
	{
		return this.eatCount;
	}
	
	public void setEatCount(int totalS)
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
	
	public void setSuspended()
	{
		this.threadSuspended = true;
	}
	
	public void setResumed()
	{
		this.threadSuspended = false;
	}
	
	public String getAnimalName()
	{
		return this.name;
	}
	
	public String getColor()
	{
		return this.col;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void eatInc()
	{
		this.eatCount++;
	}
	
	public int getHorSpeed()
	{
		return horSpeed;
	}
	
	public int getVerSpeed()
	{
		return verSpeed;
	}
	
	public void drawObject(Graphics g)
	{
		if(this.x_dir==1) 
		 {
			 g.drawImage(img1, this.getLocation().getx()-this.size/2, this.getLocation().gety()-this.size/10, this.size/2, this.size, this.pan);
		 }
		
		 else 
		 {
			 g.drawImage(img2, this.getLocation().getx(), this.getLocation().gety()-this.size/10, this.size/2, this.size, this.pan);
		 }

	}
	
	public void loadmages(String nm)
	{
		if (nm == "lio")
		{
			if( col == "Natural")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_n_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Red")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_r_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Blue")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_b_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
		}
		else if (nm == "bea")
		{
			if( col == "Natural")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_" + "n_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Red")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_r_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Blue")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_b_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
		}
		else if (nm == "elf")
		{
			if( col == "Natural")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_" + "n_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Red")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_r_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Blue")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_b_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
		}
		else if (nm == "grf")
		{
			if( col == "Natural")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_" + "n_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Red")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_r_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Blue")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_b_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
		}
		else if (nm == "trt")
		{
			if( col == "Natural")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_n_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Red")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_r_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
			if(col == "Blue")
			{
				try {
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm + "_b_1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Animal drawed");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Error uploading image");
		}
	}
	
	public boolean distanceCheck(double distance)
	{
		if(distance < this.EATÉDISTANCE)
		{
			return true;
		}
		return false;
	}
	
	public void run()
	{
		while(!this.threadSuspended)
		{
			xcor = getXLocation() + horSpeed * x_dir;
			ycor = getYLocation() + verSpeed * y_dir;
			this.coordChanged = true;
			if(xcor > 800)
			{
				x_dir = -1;
				xcor = getXLocation() + horSpeed * x_dir;
			}
			else if(xcor < 0)
			{
				x_dir = 1;
				xcor = getXLocation() + horSpeed * x_dir;
			}
			if(ycor > 600)
			{
				y_dir = -1;
				ycor = getYLocation() + verSpeed * y_dir;
			}
			else if(ycor < 0)
			{
				y_dir = 1;
				ycor = getYLocation() + verSpeed * y_dir;
			}
			Point point1 = new Point(xcor,ycor);
			this.setLocation(point1);
			try
			{
				Thread.sleep(100);
			}catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
			this.pan.repaint();
		}
	}
	

	
	

	


}
