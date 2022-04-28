package graphics;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ZooPanel extends JPanel implements ActionListener{
	
	
	
	public ZooPanel()
	{
		addAnimal = new JButton("Add Animal");
		addAnimal.addActionListener(this);
		moveAnimal = new JButton("Move Animal");
		moveAnimal.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		food = new JButton("Food");
		food.addActionListener(this);
		info = new JButton("Info");
		info.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
	}

}
