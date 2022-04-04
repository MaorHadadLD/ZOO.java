package diet;
import food.*;
import animals.Animal;

public class Omnivore implements IDiet{
	

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
		double oldWeight = animal.getWeight();
		Carnivore c = new Carnivore();
		Herbivore h = new Herbivore();
		if(canEat(food.getFoodtype()))
		{
		 if(food.equals(EFoodType.MEAT))
		 {
			double newWeight1 = c.eat(animal, food);
			return newWeight1;
		 }
		 else
		 {
			double newWeight2 = h.eat(animal, food);
			return newWeight2;
		 }
		}
		return oldWeight;
	}

}
