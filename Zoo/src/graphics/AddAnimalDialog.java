package graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import animals.*;

public class AddAnimalDialog extends JDialog implements ActionListener{
	
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JComboBox<Object> colorBox;
	private JComboBox<Object> aanimalBox;
	private JComboBox<Object> horSpeedBox;
	private JComboBox<Object> verSpeedBox;
	private JButton create;
	private String animalColor=" ";
	private String animaName=" ";
	private String colors[]={"Natural","Red","Blue"};
	private String animals[]= {"Lion","Bear","Elephant","Giraffe","Turtle"};
	private String intNums[]= {"1","2","3","4","5","6","7","8","9","10"};
	private JTextField size;
	private int animalType=0,horSpeed=0,verSpeed=0,size1,lionCount=0,bearCount=0,elephantCount=0,giraffeCount=0,turtleCount=0;
	private ZooPanel zooPanel;
	private Animal newAnimal;
	
	public AddAnimalDialog(ZooPanel zoopanel1)
	{
		
		super();
		zooPanel = new ZooPanel();
		this.zooPanel = zoopanel1;
		//panel=new JPanel();
		create=new JButton("Create");
		aanimalBox=new JComboBox<Object>(animals);
		colorBox=new JComboBox<Object>(colors);
		horSpeedBox=new JComboBox<Object>(intNums);
		verSpeedBox=new JComboBox<Object>(intNums);
		label1 = new JLabel("Pick an animal: ");
		label2= new JLabel("Enter the size of the animal between 50 - 300:");
		label3 = new JLabel("Enter horizontal speed:");
		label4 = new JLabel("Enter vetical speed:  ");
		label5 = new JLabel("Enter the color of the animal: ");
		this.add(label1);
		this.add(aanimalBox);
		aanimalBox.addActionListener(this);
		this.add(label2);
		this.add(size);
		size.addActionListener(this);
		this.add(label3);
		this.add(horSpeedBox);
		horSpeedBox.addActionListener(this);
		this.add(label4);
		this.add(verSpeedBox);
		verSpeedBox.addActionListener(this);
		size = new JTextField();
		this.add(label5);
		this.add(colorBox);
		colorBox.addActionListener(this);
		this.setLayout(new GridLayout(6, 1));
		this.setSize(400, 200);
		this.setVisible(true);
		this.add(create);
		
		
	}
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aanimalBox)
		{
			if(aanimalBox.getSelectedIndex() == 0)
			{
				animalType = 1;
			}
			else if(aanimalBox.getSelectedIndex() == 1)
			{
				animalType = 2;
			}
			else if(aanimalBox.getSelectedIndex() == 2)
			{
				animalType = 3;
			}
			else if(aanimalBox.getSelectedIndex() == 3)
			{
				animalType = 4;
			}
			else if(aanimalBox.getSelectedIndex() == 4)
			{
				animalType = 5;
			}
		}
		else if(e.getSource() == horSpeedBox)
		{
			horSpeed = horSpeedBox.getSelectedIndex() + 1;
		}
		else if(e.getSource() == verSpeedBox)
		{
			verSpeed = verSpeedBox.getSelectedIndex() + 1;
		}
		else if(e.getSource() == colorBox)
		{
			if(colorBox.getSelectedIndex() == 0)
			{
				animalColor = colors[0];
			}
			else if(colorBox.getSelectedIndex() == 1)
			{
				animalColor = colors[1];
			}
			else if(colorBox.getSelectedIndex() == 2)
			{
				animalColor = colors[2];
			}
		}
		else if(e.getSource() == create)
		{
			if(animalType == 0 || animalColor == " " || horSpeed == 0 || verSpeed == 0)
			{
				JOptionPane.showMessageDialog(null, "Missing deatails");
			}
			else
			{
				if(animalType == 1)
				{
					lionCount++;
					animaName = "Lion" + lionCount;
					newAnimal = Lion(size1,animalColor,horSpeed,verSpeed);
					zooPanel.setArraySize(zooPanel.getArraysize() + 1);
					zooPanel.animalList.add(newAnimal);
					zooPanel.setListOfAnimals(name);
					JOptionPane.showMessageDialog(null, "Animal added");
				}
				else if(animalType == 2)
				{
					bearCount++;
					animaName = "Bear" + bearCount;
					newAnimal = new Bear(size1,animalColor,horSpeed,verSpeed);
					zooPanel.setArraySize(zooPanel.getArraysize() + 1);
					zooPanel.animalList.add(newAnimal);
					zooPanel.setListOfAnimals(name);
					JOptionPane.showMessageDialog(null, "Animal added");
				}
				else if(animalType == 3)
				{
					elephantCount++;
					animaName = "Bear" + elephantCount;
					newAnimal = new Elephant(size1,animalColor,horSpeed,verSpeed);
					zooPanel.setArraySize(zooPanel.getArraysize() + 1);
					zooPanel.animalList.add(newAnimal);
					zooPanel.setListOfAnimals(name);
					JOptionPane.showMessageDialog(null, "Animal added");
				}
				else if(animalType == 4)
				{
					giraffeCount++;
					animaName = "Bear" + giraffeCount;
					newAnimal = new Giraffe(size1,animalColor,horSpeed,verSpeed);
					zooPanel.setArraySize(zooPanel.getArraysize() + 1);
					zooPanel.animalList.add(newAnimal);
					zooPanel.setListOfAnimals(name);
					JOptionPane.showMessageDialog(null, "Animal added");
				}
				else
				{
					turtleCount++;
					animaName = "Bear" + turtleCount;
					newAnimal = new Turtle(size1,animalColor,horSpeed,verSpeed);
					zooPanel.setArraySize(zooPanel.getArraysize() + 1);
					zooPanel.animalList.add(newAnimal);
					zooPanel.setListOfAnimals(name);
					JOptionPane.showMessageDialog(null, "Animal added");
				}
			}
		}
	}
	
	

}
