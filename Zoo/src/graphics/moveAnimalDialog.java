package graphics;

import mobility.*;
import mobility.Point;

import javax.swing.*;
import animals.*;
import animals.Animal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class moveAnimalDialog extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox a;
	JButton Movement;
	JTextField x , y;
	String typeAn;
	Animal animal;
	int x1 , y1, size, typean;
	//Point pointA;
	ZooPanel Zoo;
	String safary;
	String animalString[];
	JLabel labelA, CorX, CorY, moveA;
	
	@SuppressWarnings("unchecked")
	public moveAnimalDialog(ZooPanel zoo)
	{
		this.Zoo = zoo;
		size = Zoo.getArraysize();
		animalString = new String[Zoo.getArraysize()];
		for(int i = 0; i < Zoo.getArraysize(); i++)
		{
			animalString[i] = Zoo.getListOfAnimal().get(i);
		}
		a = new JComboBox(animalString);
		this.setLayout(new GridLayout(4, 1));
		this.setSize(400, 200);
		this.setTitle("Move animal");
		labelA = new JLabel("Select an animal:");
		this.add(labelA);
		a.addActionListener(this);
		this.add(a);
		CorX = new JLabel("Insret X coordinates (0 < x < 800)");
		this.add(CorX);
		x = new JTextField();
		this.add(x);
		x.addActionListener(this);
		CorY = new JLabel("Insret y coordinates (0 < y < 600)");
		this.add(CorY);
		y = new JTextField();
		this.add(y);
		y.addActionListener(this);
		moveA = new JLabel("To move press here");
		this.add(moveA);
		Movement = new JButton("Ok");
		this.add(Movement);
		Movement.addActionListener(this);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == a)
		{
			for(int i = 0; i < Zoo.getArraysize(); i++)
			{
				if(a.getSelectedIndex() == i)
				{
					typean = i;
				}
			}
		}
		
		if(e.getSource() == Movement)
		{
			x1 = Integer.parseInt(x.getText());
			y1 = Integer.parseInt(y.getText());
			if((x1 > 0 && x1 < 801) && (y1 > 0 && y1 < 601))
			{
				typeAn = (String)a.getSelectedItem();
				for(int i = 0; i < Zoo.getArraysize(); i++)
				{
					if(animalString[i] == typeAn)
					{
						Point pointA = new Point(x1, y1);
						if(Zoo.animalist.get(i).move(pointA))
						{
							Zoo.animalist.get(i).setChanges(true);
							JOptionPane.showMessageDialog(null, Zoo.animalist.get(i).getName() + "managed to move");
						}
						else
						{
							JOptionPane.showMessageDialog(null, Zoo.animalist.get(i).getName() + "stayed in place");
						}
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There is an error entering the data.Please try again",null, JOptionPane.WARNING_MESSAGE);
				x1 = Integer.parseInt(x.getText());
				y1 = Integer.parseInt(y.getText());
			}
		}
		
	}
	

}
