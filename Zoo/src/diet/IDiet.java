package diet;
import animals.*;
import food.EFoodType;
import food.IEdible;

public interface IDiet
{
	public boolean canEat(EFoodType food);
	public double eat(Animal animal, IEdible food);

}
