package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

public class Carnivore implements IDiet{
	
	public boolean canEat(EFoodType food)
	{
		if(food.equals(EFoodType.MEAT))
		{
			return true;
		}
		return false;
	}
	
	public double eat(Animal animal, IEdible food)
	{
		
		if(canEat(food.getFoodType() == true))
		{
			double weightCarniv = animal.getWeight() + animal.getWeight() * 0.1;
			return weightCarniv;
		}
	}

}
