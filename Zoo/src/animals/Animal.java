package animals;
import food.*;

import mobility.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import diet.IDiet;
import utilities.MessageUtility;
import graphics.*;

public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable
{
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
	private int x_dir = 1;
	private int y_dir = 1;
	private int eatCount;
	private ZooPanel pan;
	private BufferedImage img1, img2;
	private int xcor, ycor;
	private boolean flag = true;
	
	
	
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
		this.thread = new Thread(this);
	}
	
//    public void Animal1(Point startLocation, int size, String color, int hoerSpeed, int verSpeed) {
//		
//    	Animal1(startLocation,size,color,hoerSpeed,verSpeed);
//	}
	
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
	
	public synchronized void setWait() throws InterruptedException
	{
		this.wait();
	}
	
	public synchronized void setNotify() throws InterruptedException
	{
		this.notify();
	}
	
	public synchronized void setSuspended()
	{
		this.threadSuspended = true;
	}
	
	public synchronized void setResumed()
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
	
	public ZooPanel getPan()
	{
		return this.pan;
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
		try
		{
			if(this.col == "Natural")
			{
				
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_n_1.png"));
					this.img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_n_2.png"));
				System.out.println("Animal drawed");
			}
			else if(this.col == "Red")
			{
				
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_r_1.png"));
					this.img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_r_2.png"));
					System.out.println("Animal drawed");
			}
			else if(col == "Blue")
			{
				
					this.img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_b_1.png"));
					this.img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + "_b_2.png"));
					System.out.println("Animal drawed");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error uploading image");
			}
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error uploading image");
			e.printStackTrace();
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
		while(flag = true)
		{
			while(threadSuspended)
			{
				try {
				this.setWait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			System.out.print("Animal: " + getThread().getState());
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
//			if (xcor >= getPan().getWidth() || xcor <= 0) {
//				System.out.println("Test if 1: location:" + getXLocation() + " " + getYLocation());
//				if (xcor == 0) xcor = 1;
//				if (x_dir == 1) x_dir = -1;
//				else x_dir = 1;
//			}
//			if (ycor >= getPan().getHeight() || ycor <= 0) {
//				System.out.println("Test if 2: location:" + getXLocation() + " " + getYLocation());
//				if (ycor == 0) ycor = 1;
//				if (y_dir == 1) y_dir = -1;
//				else y_dir = 1;
//			}
			Point p = new Point(xcor,ycor);
			super.setLocation(p);
			
			//System.out.print(getXLocation() + getYLocation());

//			this.setLocation(point1);
			try
			{
				Thread.sleep(100);
			}catch(InterruptedException e)
			{
//				throw new RuntimeException(e);
			}
			if(pan.getMeat() != null && this.diet.canEat(pan.getMeat().getFoodtype())  )
			{
				if(x_dir == 1 && getXLocation() > 400)
				{
					x_dir = -1;
				}
				if(x_dir == -1 && getXLocation() < 400)
				{
					x_dir = 1;
				}
				if(y_dir == 1 && getYLocation() > 300)
				{
					y_dir = -1;
				}
				if(y_dir == -1 && getYLocation() < 300)
				{
					y_dir = 1;
				}
				if( 400 - verSpeed < getXLocation() && getXLocation() < 400 + verSpeed && getXLocation() != 400)
				{
					Point po = new Point(400, getYLocation());
					setLocation(po);
				}
				if( 300 - horSpeed < getYLocation() && getYLocation() < 300 + horSpeed && getYLocation() != 300)
				{
					Point po = new Point(getXLocation(),300);
					setLocation(po);
				}
					
				if(getXLocation() == 400 && getYLocation() == 300)
				{
					this.eat(this.pan.getMeat());
					this.pan.setMeat(null);
					this.pan.repaint();
				}
			}
				if(pan.getPlant()!= null && this.diet.canEat(pan.getPlant().getFoodtype()))
				{
						if(x_dir == 1 && getXLocation() > 400)
						{
							x_dir = -1;
						}
						if(x_dir == -1 && getXLocation() < 400)
						{
							x_dir = 1;
						}
						if(y_dir == 1 && getYLocation() > 300)
						{
							y_dir = -1;
						}
						if(y_dir == -1 && getYLocation() < 300)
						{
							y_dir = 1;
						}
						if( 400 - verSpeed < getXLocation() && getXLocation() < 400 + verSpeed && getXLocation() != 400)
						{
							Point po = new Point(400, getYLocation());
							setLocation(po);
						}
						if( 300 - horSpeed < getYLocation() && getYLocation() < 300 + horSpeed && getYLocation() != 300)
						{
							Point po = new Point(getXLocation(),300);
							setLocation(po);
						}
							
						if(getXLocation() == 400 && getYLocation() == 300)
						{
							this.eat(this.pan.getPlant());
							this.pan.setPlant(null);
							this.pan.repaint();
						}
						{
					
				}
					
			}
			
//			SwingUtilities.invokeLater(new Runnable() {
//				public void run() {
//			this.pan.managZoo();
//			this.pan.managZoo();
					this.pan.repaint();
					
//				}
//			});

		}
		
	}
	
	public void setPan(ZooPanel pan)
	{
		this.pan = pan;
	}
	
	public Thread getThread()
	{
		return this.thread;
	}
	public BufferedImage getBufferedPic1()
	{
		return this.img1;
	}
	
	public BufferedImage getBufferedPic2()
	{
		return this.img2;
	}
	
	public void setBufferdPic()
	{
		try
		{
			img1 = ImageIO.read(new File(PICTURE_PATH));
		}
		catch(IOException e)
		{
			System.out.println("Cant load image");
		}
	}

	
	

	


}
