package food;

import mobility.Point;

public interface IEdible {
	public EFoodType getFoodtype();

	Point getLocation();

	boolean setLocation(Point newLocation);

}
