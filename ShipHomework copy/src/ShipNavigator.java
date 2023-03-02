//Written by Jason Milton

import java.util.Scanner;

public class ShipNavigator {
	
	private Ship[] fleet;
	public ShipNavigator(Ship[] fleet) {
		this.fleet = fleet;
	}

	public static final int MAX_SHIPS = 100;
	
	public ShipNavigator()
	{
		fleet = new Ship[MAX_SHIPS];
	}
	public Ship[] getFleet()
	{
		return this.fleet;
	}
	public void addShip(Ship aP)
	{
		for(int i = 0; i<fleet.length; i++)
		{
			if(fleet[i] == null)
			{
				fleet[i] = aP;
				return;
			}
		}
		
		System.out.println("The fleet of ships is full!");
	}
	
	//Trying to create the remove method
	public void removeShip(Ship aP)
	{
		for(int i=0;i<fleet.length;i++)
		{
			if(fleet[i] != null && fleet[i].equals(aP))
			{
				fleet[i] = null;
				return;
			}
		}
		System.out.println("That ship was not found");
	}
	
	//creating a static to be used throughout
	static Scanner key;
	
	public static void main(String[] args) {
		
		
		key = new Scanner(System.in);
		
		System.out.println("Welcome to the ship navigator");
		
		ShipNavigator sNV = new ShipNavigator();
		
		boolean quit = false;
		while(!quit) //Runs until the user quits
		{
			printOptions();
			int pick = key.nextInt();
			key.nextLine();
		
			switch(pick)
			{
			case 1: //Add ship
				sNV.addShip(makeAShipDialog());
				break;
			case 2: //Remove ship
				sNV.removeShip(makeAShipDialog());
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Invalid input");
			}
			System.out.println("The Fleet currently");
			printFleet(sNV);
		}
		System.out.println("Goodbye!");
	}
		public static void printOptions()
		{
			System.out.println("Enter 1: to add a Ship\nEnter 2: to remove a Ship\nEnter 9 to quit");
		}
		public static Ship makeAShipDialog()
		{
			Ship retS;
			int pick = 0;
			System.out.println("Enter 1: if it is a Cruise Ship\nEnter 2: if it is a Cargo Ship\nEnter 3: if it is unclassified");
			pick = key.nextInt();
			key.nextLine();
			while(pick != 1 && pick != 2 && pick != 3)
			{
				System.out.println("Invalid choice pick again");
				pick = key.nextInt();
				key.nextLine();
			}
			System.out.println("Enter the ship's name");
			String name = key.nextLine();
			System.out.println("Enter the launch date");
			String launchDate = key.nextLine();
			
			switch(pick)
			{
			case 1:
				System.out.println("Enter the capacity:");
				int capacity = key.nextInt();
				System.out.println("Enter the members of crew");
				int crew = key.nextInt();
				retS = new CruiseShip(name,launchDate,capacity,crew);
				break;
				
			case 2:
				System.out.println("Enter the deadweight tonnage ");
				double dWT = key.nextDouble();
				System.out.println("Enter the maximum speed");
				double speed = key.nextDouble();
				retS = new CargoShip(name,launchDate,dWT,speed);
				break;
				
			default :
				retS = new Ship(name,launchDate);
				
			}
			return retS;
		
		}
		public static void printFleet(ShipNavigator sN)
		{
			for(Ship s : sN.getFleet())
			{
				if(s == null)
					continue;
				System.out.println(s);
				System.out.println();
			}
		}
	

}
