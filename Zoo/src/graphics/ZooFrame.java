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
	
	static JFrame frame;
	static JLabel label;
	static Image pic;
	private JMenu file;
	private JMenu background;
	private JMenu help;
	private JMenuItem exit;
	private JMenuItem image;
	private JMenuItem green;
	private JMenuItem none;
	private JMenuItem help1;
	JButton addAnimal;
	JButton moveAnimal;
	JButton clear;
	JButton food;
	JButton info;
	JButton exit1;

	private BufferedImage pic2; 
	
	
	
	public ZooFrame()
	{
		
		this.setName("Zoo");
		this.setSize(900, 600); //sets the x-dimension, and y-dimension of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		this.setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		label = new JLabel();
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
		this.setVisible(true);
	}
	
	//public void paintComponent(Graphics g) {
		 //super.paintComponent(g) ;

		// if(pic2!=null)
		//g.drawImage(pic2,0,0,getWidth(),getHeight(), this);
		// .....
		//}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
	
		
		if(e.getSource() == image)
		{
			//try { pic2 = ImageIO.read(new File("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg")); }
			//catch (IOException e1) { System.out.println("Cannot load image");}
			label = new JLabel(new ImageIcon("C://Users//maorh//git//ZOO.java//Zoo//src//graphics//savanna.jpg"));
			this.add(label);
		}
		//repait();
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
		
		if(e.getSource() == help)
		{
			JFrame frameMessage = new JFrame("Message");
			JLabel label1 = new JLabel ("<html>Home Work 2<br/>GUI</html>");
			frameMessage.setSize(300,300);
			frameMessage.setVisible(true);
			frameMessage.add(label1);
			ImageIcon icon = new ImageIcon("about.jpeg");
			label1.setIcon(icon);
			JButton buttonOk = new JButton("OK");
			buttonOk.setFocusable(false);
			buttonOk.setBounds(150,150,70,30);
			label1.add(buttonOk);
			buttonOk.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
				 frameMessage.dispose();
				}
				});
			
			 
		}
		
	}
	
	public static void main(String args[])
	{
		ZooFrame zo = new ZooFrame();
	}

}
