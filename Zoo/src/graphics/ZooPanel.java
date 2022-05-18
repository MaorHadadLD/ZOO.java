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

import animals.Animal;

public class ZooPanel extends JPanel implements ActionListener{
	
	private JButton addAnimal;
	private JButton moveAnimal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit;
	private JPanel jpanel;
	private Image img;
	ArrayList<Animal> animalist = new ArrayList<Animal>();
	private int arraySize = 0;
	private ArrayList<String> listOfanimal = new ArrayList<String>();
	//static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public ZooPanel()
	{
		this.setBackground(null);
		this.setVisible(true);
		try{ img = ImageIO.read(new File("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg")); }
   	 catch (IOException ie) { System.out.println("Cannot load image"); }
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		 if(img!=null)
		 {
		   g.drawImage(img,0,0,getWidth(),getHeight(), this);
		 }
		 else if(this.arraySize > 0)
		 {
			 animalist.get(0).drawObject(g);
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
//			 try { img = ImageIO.read(new File("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg")); }
//			 catch (IOException e) { System.out.println("Cannot load image"); }
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
	
	public  void setListofanimals(String name) {
		
		this.listOfanimal.add(name);
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
	
	public void managZoo()
	{
		if(isChange())
		{
			repaint();
		}
	}
	

}
