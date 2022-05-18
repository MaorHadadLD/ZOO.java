package graphics;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import animals.*;
import food.*;
import mobility.Point;


public class AnimalTable extends AbstractTableModel{
	
	private ArrayList<Animal> data;
	private ZooPanel zooP;
	private final String[] columTaitels = {"Name", "Color", "Weight", "HorSpeed", "VerSpeed", "Eat counter"};
	private int totalS = 0;
	private Animal animal;
	
	public AnimalTable(ZooPanel zooPa)
	{
		this.zooP = zooPa;
		data = new ArrayList<Animal>();
		for(int i = 0; i < zooP.getArraysize(); i++)
		{
			data.add(zooP.animalist.get(i));
			totalS += zooP.animalist.get(i).getEatCount();
		}
		Point point1 = new Point(0, 0);
		animal = new Animal("Total",point1) {
			
			public boolean eat(IEdible food) {
				return false;
			}
			
			public String toString() {
				return "Total";
			}

			@Override
			public EFoodType getFoodtype() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void loadmages(String nm) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public String getColor() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void makeSound() {
				// TODO Auto-generated method stub
				
			}
		};
		animal.setEatCount(totalS);
		data.add(animal);
		
	}
	

	@Override
	public int getRowCount() {
		
		return zooP.getArraysize();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Animal data1 = data.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
				return data1.getName();
			case 1:
				return data1.getColor();
			case 2:
				return data1.getWeight();
			case 3:
				return data1.getHorSpeed();
			case 4:
				return data1.getVerSpeed();
			case 5:
				return data1.getEatCount();
		
		}
		return null;
	}
	
	public String getColumnName(int column)
	{
		return columTaitels[column];
	}

}
