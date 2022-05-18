package graphics;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import animals.*;
import diet.*;
import food.*;
import mobility.*;
import plants.*;
import utilities.*;
import zoo.*;




public class ZooFrame extends JFrame implements ActionListener{
	
   // private static final String BACKGROUND_PATH = "C://Users//User//git//java-codes//ZOO2//src//graphics//savanna.jpg";
	static JFrame frame, fooda;
	static JLabel label, lf, l2;
	static Image pic;
	static ZooPanel zooPanel;
	private JMenu file;
	private JMenu background;
	private JMenu help;
	private JMenuItem exit;
	private JMenuItem image;
	private JMenuItem green;
	private JMenuItem none;
	private JMenuItem help1;
	private JButton addAnimal;
	private JButton moveAnimal;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit1;
	private JPanel panel;
	private BufferedImage pic2; 
	moveAnimalDialog ma;
	AddAnimalDialog ad;
	
	
	
	public ZooFrame()
	{
		
		this.setName("Zoo");
		this.setSize(900, 600); //sets the x-dimension, and y-dimension of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		this.setLocationRelativeTo(null);
		zooPanel = new ZooPanel();
		label = new JLabel();
		l2 = new JLabel();
		panel = new JPanel();
		addAnimal = new JButton("Add Animal");
		addAnimal.addActionListener(this);
		panel.add(addAnimal);
		moveAnimal = new JButton("Move Animal");
		moveAnimal.addActionListener(this);
		panel.add(moveAnimal);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		panel.add(clear);
		food = new JButton("Food");
		food.addActionListener(this);
		panel.add(food);
		info = new JButton("Info");
		info.addActionListener(this);
		panel.add(info);
		exit1 = new JButton("Exit");
		exit1.addActionListener(this);
		panel.add(exit1);
		
		this.setLayout(new BorderLayout());
		JMenuBar mub = new JMenuBar();
		this.setJMenuBar(mub);
		file = new JMenu("File");
		background = new JMenu("Background");
		help = new JMenu("Help");
		exit = new JMenuItem("Exit");
		image = new JMenuItem("Image");
		green = new JMenuItem("Green");
		none = new JMenuItem("None");
		help1 = new JMenuItem("Help");
		mub.add(file);
		mub.add(background);
		mub.add(help);
		file.add(exit);
		background.add(image);
		background.add(green);
		background.add(none);
		help.add(help1);
		exit.addActionListener(this);
		image.addActionListener(this);
		green.addActionListener(this);
		none.addActionListener(this);
		help1.addActionListener(this);
		this.add(panel,BorderLayout.SOUTH);
		//this.setLayout(new BorderLayout());
		this.setVisible(true);
		addAnimal.setFocusable(false);
		moveAnimal.setFocusable(false);
		clear.setFocusable(false);
		food.setFocusable(false);
		info.setFocusable(false);
		exit1.setFocusable(false);
		
		
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
	
		
		if(e.getSource() == image)
		{
//			 try { pic2 = ImageIO.read(new File("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg")); }
//			 catch (IOException ef) { System.out.println("Cannot load image"); }
   	        label=new JLabel(new ImageIcon("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg"));
	    	this.add(label);
		}
		
		//}
		//setLayout(new FlowLayout());
		 //label = new JLabel();
		 //add(label);
		 //setSize(900, 600);
		 
		if(e.getSource() == green)
		{
			this.remove(label);
			this.getContentPane().setBackground(Color.green);
		}
		
		if(e.getSource() == none)
		{
			this.remove(label);
			this.getContentPane().setBackground(null);
		}
		
		if(e.getSource() == help1)
		{
//			JOptionPane.showMessageDialog(this, "Home Work 2\nGUI");
			
			JFrame newFrame = new JFrame("Message");
			JLabel label1 = new JLabel ("<html>Home Work 2<br/>GUI</html>");
			newFrame.setSize(500,300);
			newFrame.setVisible(true);
			newFrame.add(label1);
			newFrame.add(label1,BorderLayout.CENTER);
			ImageIcon icon = new ImageIcon("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//helppic.jpeg");
			label1.setIcon(icon);
			JButton buttonOk = new JButton("OK");
			buttonOk.setFocusable(false);
			buttonOk.setBounds(150,150,70,30);
			label1.add(buttonOk);
			buttonOk.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					newFrame.dispose();
				}
				});
		}
		if(e.getSource()== addAnimal)
		{
			 ad = new AddAnimalDialog(zooPanel);
		}
		if(e.getSource() == moveAnimal)
		{
			ma = new moveAnimalDialog(zooPanel);
		}
		if(e.getSource()==clear)
		{
			zooPanel.clearList();
		}
		if(e.getSource()==food)
		{
			fooda = new JFrame("Food for animal");
			lf = new JLabel("Please choose food");
			fooda.setSize(500,300);
			fooda.setVisible(true);
			fooda.add(lf);
			ImageIcon icon2 = new ImageIcon("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//helppic.jpeg");
			lf.setIcon(icon2);
			JButton buttonm = new JButton("Meat");
			buttonm.setFocusable(false);
			buttonm.setBounds(240,200,100,20);
			lf.add(buttonm);
			buttonm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					fooda.dispose();
				}
				});
			JButton buttonc = new JButton("Cabbage");
			buttonc.setFocusable(false);
			buttonc.setBounds(130,200,100,20);
			lf.add(buttonc);
			buttonc.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					fooda.dispose();
				}
				});
			JButton buttonl = new JButton("Lettuce");
			buttonl.setFocusable(false);
			buttonl.setBounds(20,200,100,20);
			lf.add(buttonl);
			buttonl.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					fooda.dispose();
				}
				});
		}
		if(e.getSource() == exit1)
		{
			System.exit(0);
		}
		
	}
	
	public static void main(String args[])
	{
		ZooFrame zo = new ZooFrame();
	}

}
