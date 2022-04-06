package diet;
import food.*;
import animals.Animal;

public class Omnivore implements IDiet{
	
	private static  Carnivore c = new Carnivore();
	private static Herbivore h = new Herbivore();
	

	public boolean canEat(EFoodType food)
	{
		if(!(food.equals(EFoodType.NOTFOOD)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	} 
	
	public double eat(Animal animal, IEdible food)
	{
		if(canEat(food.getFoodtype()) == true)
		{
		 if(food.getFoodtype() == EFoodType.MEAT)
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
		return 0;
	}

}
