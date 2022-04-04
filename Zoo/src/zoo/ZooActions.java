package zoo;
import animals.*;
import food.IEdible;
import mobility.Point;
import java.util.*;

public class ZooActions {
	
	public boolean eat(Object animal, IEdible food)
	{
		if(animal instanceof Animal)
		{
			if(((Animal)animal).eat(food))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean move(Object animal, Point point)
	{
		if(point.checkBoundaries(point))
		{
			if(animal instanceof Lion)
			{
				((Lion)animal).move(point);
				return true;
			}
			else if(animal instanceof Bear)
			{
				((Bear)animal).move(point);
				return true;
			}
			else if(animal instanceof Elephant)
			{
				((Elephant)animal).move(point);
				return true;
			}
			else if(animal instanceof Giraffe)
			{
				((Giraffe)animal).move(point);
				return true;
			}
			else if(animal instanceof Turtle)
			{
				((Turtle)animal).move(point);
				return true;
			}
			else
			{
			    return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Animal array[];
		String nameAnimal, bearFur;
		int sizeOfArray, choice, choice1, choice2, numScars, turtleAge;
		double giraffeNeckl, elephantTrunkl;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array (min 3):");
		sizeOfArray = sc.nextInt();
		while(sizeOfArray < 3)
		{
			System.out.println("Wrong number, try again.");
			sizeOfArray = sc.nextInt();
		}
		array = new Animal[sizeOfArray];
		for(int i = 0; i < sizeOfArray; i++)
		{
			System.out.println("Please enter animal name:");
			nameAnimal = sc.next();
			System.out.println("Please select type of animal:");
			System.out.println("1.Lion \n 2.Bear \n 3.Elephant \n 4.Giraffe \n 5.Turtle \n");
			choice = sc.nextInt();
			while(choice < 1 || choice > 5)
			   {
				   System.out.println("Not in range choice ,please try again");
				   System.out.print("1)Lion \n2)Bear \n3)Elephant \n4)Giraffe \n5)Turtle \n");
				   choice=sc.nextInt();
			   }
			System.out.println("Would you like to enter start point for the animal?");
			System.out.println("1.yes \n 2.no");
			choice1 = sc.nextInt();
			while(choice1 != 1 && choice1 != 2)
			{
				System.out.print("Try again");
				System.out.println("1.yes \n 2.no");
				choice1 = sc.nextInt();
				
			}
			if(choice1 == 1)
			{
				int x, y;
				System.out.print("Enter value of x in point:");
				   x=sc.nextInt();
				   System.out.println("Enter value of y in point:");
				   y=sc.nextInt();
				   Point point2 = new Point(x,y);
				   while(!point2.checkBoundaries(point2))
				   {
					   System.out.println("Out of range point, please try again:");
					   System.out.println("Enter value of x in point:");
					   x=sc.nextInt();
					   System.out.println("Enter value of y in point:");
					   y=sc.nextInt();
					   point2= new Point(x,y);
					   
				   }
			
				if(choice == 1)
				{
					array[i] = new Lion(nameAnimal, point2);
					System.out.println("DOse the lion have scars? ");
					System.out.println("1.yes \n 2.no \n");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter number of scars:");
						numScars = sc.nextInt();
						while(!((Lion)array[i]).setScars(numScars))
						{
							System.out.println("Eror number, try again");
							System.out.println("Enter number of scars:");
							numScars = sc.nextInt();
						}
					}
				}
				else if(choice == 2)
				{
					array[i] = new Bear(nameAnimal,point2);
					System.out.println("Would you like to change the color bear fur?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the fur color:");
						bearFur = sc.next();
					 	while(!((Bear)array[i]).setFurColor(bearFur))
					 	{
						 	System.out.println("Eror color, please try again");
						 	System.out.println("Enter the fur color:");
						 	bearFur = sc.next();
					 	}
					}
				
				}
				else if(choice == 3)
				{
					array[i] = new Elephant(nameAnimal,point2);
					System.out.println("Would you like to change the length of the elephant's trunk?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the trunk length:");
						elephantTrunkl = sc.nextDouble();
					 	while(!((Elephant)array[i]).setTrunkLength(elephantTrunkl))
					 	{
						 	System.out.println("Eror length, please try again");
						 	System.out.println("Enter the trunk length:");
						 	elephantTrunkl = sc.nextDouble();
					 	}
					}
				}
				else if(choice == 4)
				{
					array[i] = new Giraffe(nameAnimal, point2);
					System.out.println("Would you like to change the neck length of the giraffe?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the neck length:");
						giraffeNeckl = sc.nextDouble();
					 	while(!((Giraffe)array[i]).setNeckLength(giraffeNeckl));
					 	{
						 	System.out.println("Eror length, please try again");
						 	System.out.println("Enter the neck length:");
						 	giraffeNeckl = sc.nextDouble();
					 	}
					}
				}
				else
				{
					array[i] = new Turtle(nameAnimal, point2);
					System.out.println("Would you like to change the turtle age?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the turtle age:");
						turtleAge = sc.nextInt();
					 	while(!((Turtle)array[i]).setAge(turtleAge));
					 	{
					 		System.out.println("Eror age, please try again");
					 		System.out.println("Enter the turtle age:");
					 		turtleAge = sc.nextInt();
					 	}
					}
				}
			}
			else
			{
				if(choice == 1)
				{
					array[i] = new Lion(nameAnimal);
					System.out.println("DOse the lion have scars? ");
					System.out.println("1.yes \n 2.no \n");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter number of scars:");
						numScars = sc.nextInt();
						while(!((Lion)array[i]).setScars(numScars))
						{
							System.out.println("Eror number, try again");
							System.out.println("Enter number of scars:");
							numScars = sc.nextInt();
						}
					}
				}
				else if(choice == 2)
				{
					array[i] = new Bear(nameAnimal);
					System.out.println("Would you like to change the color bear fur?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the fur color:");
						bearFur = sc.next();
					 	while(!((Bear)array[i]).setFurColor(bearFur))
					 	{
						 	System.out.println("Eror color, please try again");
						 	System.out.println("Enter the fur color:");
						 	bearFur = sc.next();
					 	}
					}
				
				}
				else if(choice == 3)
				{
					array[i] = new Elephant(nameAnimal);
					System.out.println("Would you like to change the length of the elephant's trunk?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the trunk length:");
						elephantTrunkl = sc.nextDouble();
					 	while(!((Elephant)array[i]).setTrunkLength(elephantTrunkl))
					 	{
						 	System.out.println("Eror length, please try again");
						 	System.out.println("Enter the trunk length:");
						 	elephantTrunkl = sc.nextDouble();
					 	}
					}
				}
				else if(choice == 4)
				{
					array[i] = new Giraffe(nameAnimal);
					System.out.println("Would you like to change the neck length of the giraffe?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the neck length:");
						giraffeNeckl = sc.nextDouble();
					 	while(!((Giraffe)array[i]).setNeckLength(giraffeNeckl));
					 	{
						 	System.out.println("Eror length, please try again");
						 	System.out.println("Enter the neck length:");
						 	giraffeNeckl = sc.nextDouble();
					 	}
					}
				}
				else
				{
					array[i] = new Turtle(nameAnimal);
					System.out.println("Would you like to change the turtle age?");
					System.out.println("1. yes \n 2. no");
					choice2 = sc.nextInt();
					if(choice2 != 1 && choice2 != 2)
					{
						System.out.println("Wrong choice, try again");
						System.out.println("1.yes \n 2.no \n");
						choice2 = sc.nextInt();
					}
					if(choice2 == 1)
					{
						System.out.println("Enter the turtle age:");
						turtleAge = sc.nextInt();
					 	while(!((Turtle)array[i]).setAge(turtleAge));
					 	{
					 		System.out.println("Eror age, please try again");
					 		System.out.println("Enter the turtle age:");
					 		turtleAge = sc.nextInt();
					 	}
					}
				}
			}
		}
		
	}
	

}
