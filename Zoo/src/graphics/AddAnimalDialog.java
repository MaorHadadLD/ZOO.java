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
	private String animalColor="Emptey";
	private String animalName;
	private String colors[]={" ","Natural","Red","Blue"};
	private String animals[]= {" ","Lion","Bear","Elephant","Giraffe","Turtle"};
	private String intNums[]= {" ","1","2","3","4","5","6","7","8","9","10"};
	private JTextField size;
	private int animalType=0,horSpeed=0,verSpeed=0,size1 = 0,lionCount=0,bearCount=0,elephantCount=0,giraffeCount=0,turtleCount=0;
	private ZooPanel zooPanel;
	private Animal newAnimal;
	
	public AddAnimalDialog(ZooPanel zoopane1)
	{
		
		super();
		size = new JTextField();
		zooPanel = new ZooPanel();
		this.zooPanel = zoopane1;
		//panel=new JPanel();
		create=new JButton("Create");
		create.addActionListener(this);
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
		this.add(label5);
		this.add(colorBox);
		colorBox.addActionListener(this);
		this.setLayout(new GridLayout(6, 1));
		this.setSize(400, 200);
		this.setVisible(true);
		this.setTitle("Add animal");
		this.add(create);
	}
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aanimalBox)
		{
			if(aanimalBox.getSelectedIndex() == 1)
			{
				animalType = 1;
			}
			else if(aanimalBox.getSelectedIndex() == 2)
			{
				animalType = 2;
			}
			else if(aanimalBox.getSelectedIndex() == 3)
			{
				animalType = 3;
			}
			else if(aanimalBox.getSelectedIndex() == 4)
			{
				animalType = 4;
			}
			else if(aanimalBox.getSelectedIndex() == 5)
			{
				animalType = 5;
			}
		}
		else if(e.getSource() == horSpeedBox)
		{
			horSpeed = horSpeedBox.getSelectedIndex();
		}
		else if(e.getSource() == verSpeedBox)
		{
			verSpeed = verSpeedBox.getSelectedIndex();
		}
		else if(e.getSource() == colorBox)
		{
			if(colorBox.getSelectedIndex() == 1)
			{
				animalColor = colors[1];
			}
			else if(colorBox.getSelectedIndex() == 2)
			{
				animalColor = colors[2];
			}
			else if(colorBox.getSelectedIndex() == 3)
			{
				animalColor = colors[3];
			}
		}
		else if(e.getSource() == create)
		{
			if(animalType == 0 || animalColor == "Emptey" || horSpeed == 0 || verSpeed == 0)
			{
				JOptionPane.showMessageDialog(null, "Some details are missing");
			}
			else 
			{
				size1 = Integer.parseInt(size.getText());
				if(size1 > 49 && size1 < 301)
				{
					if(animalType == 1)
					{
						lionCount++;
						animalName = "Lion" + lionCount;
						newAnimal = new Lion(size1,animalColor,horSpeed,verSpeed);
						newAnimal.setName(animalName);
						zooPanel.setArraySize(zooPanel.getArraysize() + 1);
						zooPanel.animalist.add(newAnimal);
						zooPanel.setListofanimals(animalName);
						newAnimal.setChanges(true);
						newAnimal.loadImages("lio");
						zooPanel.managZoo();
						JOptionPane.showMessageDialog(null, "Animal add");
					}
					else if(animalType == 2)
					{
						bearCount++;
						animalName = "Bear" + bearCount;
						newAnimal = new Bear(size1,animalColor,horSpeed,verSpeed);
						newAnimal.setName(animalName);
						zooPanel.setArraySize(zooPanel.getArraysize() + 1);
						zooPanel.animalist.add(newAnimal);
						zooPanel.setListofanimals(animalName);
						newAnimal.setChanges(true);
						newAnimal.loadImages("bea");
						zooPanel.managZoo();
						JOptionPane.showMessageDialog(null, "Animal add");
					}
					else if(animalType == 3)
					{
						elephantCount++;
						animalName = "Elephant" + elephantCount;
						newAnimal = new Elephant(size1,animalColor,horSpeed,verSpeed);
						newAnimal.setName(animalName);
						zooPanel.setArraySize(zooPanel.getArraysize() + 1);
						zooPanel.animalist.add(newAnimal);
						zooPanel.setListofanimals(animalName);
						newAnimal.setChanges(true);
						newAnimal.loadImages("elf");
						zooPanel.managZoo();
						JOptionPane.showMessageDialog(null, "Animal add");
					}
					else if(animalType == 4)
					{
						giraffeCount++;
						animalName = "Giraffe" + giraffeCount;
						newAnimal = new Giraffe(size1,animalColor,horSpeed,verSpeed);
						newAnimal.setName(animalName);
						zooPanel.setArraySize(zooPanel.getArraysize() + 1);
						zooPanel.animalist.add(newAnimal);
						zooPanel.setListofanimals(animalName);
						newAnimal.setChanges(true);
						newAnimal.loadImages("grf");
						zooPanel.managZoo();
						JOptionPane.showMessageDialog(null, "Animal add");
					}
					else if(animalType == 5)
					{
						turtleCount++;
						animalName = "Turtle" + turtleCount;
						newAnimal = new Turtle(size1,animalColor,horSpeed,verSpeed);
						newAnimal.setName(animalName);
						zooPanel.setArraySize(zooPanel.getArraysize() + 1);
						zooPanel.animalist.add(newAnimal);
						zooPanel.setListofanimals(animalName);
						newAnimal.setChanges(true);
						newAnimal.loadImages("trt");
						zooPanel.managZoo();
						JOptionPane.showMessageDialog(null, "Animal add");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The size of the animal must be between 50 and 300 ");
				}
			}
		}
	}
	
	

}
