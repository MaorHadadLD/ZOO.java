package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

public class Omnivore {
	

	public boolean canEat(EFoodType food)
	{
		if(!(food.equals(EFoodType.NOTFOOD)))
		{
			return true;
		}
		return false;
	} 
	
	public double eat(Animal animal, IEdible food)
	{
		double weight = this.getWeight();
		Carnivore c = new Carnivore();
		Herbivore h = new Herbivore();
		if(food.equals(EFoodType.MEAT))
		{
			c.eat(animal, food);
		}
		else
		{
			h.eat(animal, food);
		}
		
	}

}
