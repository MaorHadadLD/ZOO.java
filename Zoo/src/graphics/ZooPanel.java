package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import FoodMeat.Meat;
import animals.Animal;
import plants.Plant;

public class ZooPanel extends JPanel implements ActionListener, Runnable
{
	
	private JButton addAnimal;
	private JButton moveAnimal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit;
	private JPanel jpanel;
	private BufferedImage img = null;
	ArrayList<Animal> animalist = new ArrayList<Animal>();
	private int arraySize = 0;
	private ArrayList<String> listOfanimal = new ArrayList<String>();
	private double distance;
	private Plant planet = null;
	private Meat meat = null;
	private boolean background = false;
	private Thread controller;
	//static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public ZooPanel(ArrayList<Animal> animalist)
	{
		this.animalist = animalist;
		this.setBackground(null);
		this.setVisible(true);
		try{ img = ImageIO.read(new File("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg")); }
   	 	catch (IOException ie) { System.out.println("Cannot load image"); }
	}
	
	public void run()
	{
		System.out.println(animalist.get(animalist.size()-1).toString());
		animalist.get(animalist.size()-1).getThread().start();
//		animalist.get(animalist.size()-1).getPan().repaint();
	}
	
	public void setController(Thread thread)
	{
		this.controller = thread;
	}
	
	public Thread getController()
	{
		return this.controller;
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		 if(background)
		 {
		   g.drawImage(img,0,0,getWidth(),getHeight(), this);
		 }
//		 background = false;
		 if(planet != null)
		 {
			 planet.drawObject(g);
		 }
		 if(meat != null)
		 {
			 meat.drawObject(g);
		 }
		 if(this.arraySize > 0)
		 {
			 for(int i = 0; i < this.arraySize; i++)
			 {
			 animalist.get(i).drawObject(g);
			 }
		 }
		 
		 
		}
	
//	public void drawObject(Graphics g)
//	{
//		g.drawImage(img,0,0,getWidth(),getHeight(), this);
//	}
	
	public void setBackGround(int num)
	{
		if(num == 0)
		{
			this.setBackground(null);
     		 background = true;
			 this.repaint();
		}
		else if(num == 1)
		{
			this.setBackground(null);
			this.setBackground(Color.green);
			
		}
		else if(num == 2)
		{
			this.setBackground(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public  void setArraySize(int num)
	{
		try
		{
			if(num > 0 && num < 11)
			{
				this.arraySize = num;
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		catch(ArrayIndexOutOfBoundsException error)
		{
			JOptionPane.showMessageDialog(null, "number not in range");
		}
		
	}
	
	public void setBackG(int num)
	{
		if(num == 0)
		{
			setBackground(null);
			background = true;
			this.repaint();
		}
		else if(num == 1)
		{
			this.setBackground(null);
			this.setBackground(Color.GREEN);
		}
		else if(num == 2)
		{
			this.setBackground(null);
		}
	}
	
	public void setMeat(Meat meat)
	{
		this.meat = meat;
	}
	
	public Meat getMeat()
	{
		return this.meat;
	}
	
	public  void setListofanimals(String name) 
	{
		
		this.listOfanimal.add(name);
	}
	
	public void setPlant(Plant plant)
	{
		this.planet = plant;
	}
	
	public Plant getPlant()
	{
		return this.planet;
	}
	
	public ArrayList<String> getListOfAnimal()
	{
		return listOfanimal;
	}
	
	public int getArraysize()
	{
		return this.arraySize;
	}
	
	
	
	public void clearList()
	{
		animalist.clear();
		arraySize = 0;
		
	}
	
	public boolean isChange()
	{
		for(int i = 0; i < this.arraySize; i++)
		{
			if(animalist.get(i).getChanges())
			{
				animalist.get(i).setChanges(false);
				return true;
			}
		}
		return false;
	}
	
	public synchronized void managZoo()
	{
		if(isChange())
		{
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					repaint();
				}
			});

			
		}
		else if(this.getArraysize() > 0)
		{
			for(int i = 0; i < this.getArraysize(); i++)
			{
				for(int j = 0; j < this.getArraysize(); j++)
				{
					distance = animalist.get(i).calcDistance(animalist.get(j).getLocation());
					if(i != j && animalist.get(i).distanceCheck(distance) && animalist.get(i).eat(animalist.get(j)));
					{
						this.setArraySize(this.getArraysize() - 1);
						animalist.remove(j);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								repaint();
							}
						});
					}
				}
			}
		}
		else if(this.planet != null)
		{
			for(int k = 0; k < this.getArraysize(); k++)
			{
				distance = animalist.get(k).calcDistance(this.planet.getLocation());
				if(animalist.get(k).distanceCheck(distance) && animalist.get(k).eat(this.planet))
				{
					planet = null;
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							repaint();
						}
					});
				}
			}
		}
		else if(this.meat != null)
		{
			
			for(int h = 0; h < this.arraySize; h++)
			{
				distance = animalist.get(h).calcDistance(this.meat.getLocation());
				if(animalist.get(h).distanceCheck(distance) && animalist.get(h).eat(this.meat))
				{
					meat = null;
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							repaint();
						}
					});
				}
			}
		}
	}
	

}
