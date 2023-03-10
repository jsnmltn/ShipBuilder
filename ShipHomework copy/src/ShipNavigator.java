//Written by Jason Milton

import java.util.Comparator;
import java.util.Scanner;

public class ShipNavigator implements Comparator<Ship>{

	public static final int MAX_SHIPS = 100;

	static Scanner key;

	public static void main(String[] args) {

		key = new Scanner(System.in);

		System.out.println("Welcome to the ship navigator");

		ShipNavigator sNV = new ShipNavigator();

		boolean quit = false;
		while (!quit) // Runs until the user quits
		{
			printOptions();
			int pick = key.nextInt();
			key.nextLine();

			switch (pick) {
				case 1: // Add ship
					sNV.addShip(makeAShipDialog());
					break;
				case 2: // Remove ship
					sNV.removeShip(makeAShipDialog());
					break;

				case 3: // Rename Ship
					sNV.renameShip(renameShipDialoge());
					break;

				case 9:
					quit = true;
					break;

				default:
					System.out.println("Invalid input");
					break;
			}
			System.out.println("**********************************");
			System.out.println("The Current Fleet");
			System.out.println();
			printFleet(sNV);
		}
		System.out.println("Goodbye!");
	}
	
	public static Ship renameShipDialoge() {
		Ship retS;
		int pick = 0;
		System.out.println(
				"Enter 1: if it is a Cruise Ship\nEnter 2: if it is a Cargo Ship\nEnter 3: if it is unclassified");
		pick = key.nextInt();
		key.nextLine();
		while (pick != 1 && pick != 2 && pick != 3) {
			System.out.println("Invalid choice pick again");
			pick = key.nextInt();
			key.nextLine();
		}
		System.out.println("Enter the ship's name");
		String name = key.nextLine();
		System.out.println("Enter the launch date");
		String launchDate = key.nextLine();

		switch (pick) {
			case 1:
				System.out.println("Enter the capacity:");
				int capacity = key.nextInt();
				System.out.println("Enter the members of crew");
				int crew = key.nextInt();
				retS = new CruiseShip(name, launchDate, capacity, crew);
				break;

			case 2:
				System.out.println("Enter the deadweight tonnage ");
				double dWT = key.nextDouble();
				System.out.println("Enter the maximum speed");
				double speed = key.nextDouble();
				retS = new CargoShip(name, launchDate, dWT, speed);
				break;

			default:
				retS = new Ship(name, launchDate);

		}
		return retS;

	}

	public static void printOptions() {
		System.out.println(
				"Enter 1: to add a Ship\nEnter 2: to remove a Ship\nEnter 3 to rename a Ship \nEnter 9 to quit");
	}

	public static Ship makeAShipDialog() {
		Ship retS;
		int pick = 0;
		System.out.println(
				"Enter 1: if it is a Cruise Ship\nEnter 2: if it is a Cargo Ship\nEnter 3: if it is unclassified");
		pick = key.nextInt();
		key.nextLine();
		while (pick != 1 && pick != 2 && pick != 3) {
			System.out.println("Invalid choice pick again");
			pick = key.nextInt();
			key.nextLine();
		}
		System.out.println("Enter the ship's name");
		String name = key.nextLine();
		System.out.println("Enter the launch date");
		String launchDate = key.nextLine();

		switch (pick) {
			case 1:
				System.out.println("Enter the capacity:");
				int capacity = key.nextInt();
				System.out.println("Enter the members of crew");
				int crew = key.nextInt();
				retS = new CruiseShip(name, launchDate, capacity, crew);
				key.nextLine();
				break;

			case 2:
				System.out.println("Enter the deadweight tonnage ");
				double dWT = key.nextDouble();
				System.out.println("Enter the maximum speed");
				double speed = key.nextDouble();
				retS = new CargoShip(name, launchDate, dWT, speed);
				key.nextLine();
				break;

			default:
				retS = new Ship(name, launchDate);
				key.next();

		}
		return retS;
	}

	public static void printFleet(ShipNavigator sN) {
		for (Ship s : sN.getFleet()) {
			if (s != null) {
				s.writeOutput();
				System.out.println();
			}
			if (s == null) {
				System.out.println("Empty");
				System.out.println();
			}

			continue;
		}
	}

	private Ship[] fleet;

	// Trying to create the remove method
	public ShipNavigator(Ship[] fleet) {
		this.fleet = fleet;
	}

	public ShipNavigator() {
		fleet = new Ship[MAX_SHIPS];
	}

	public Ship[] getFleet() {
		return this.fleet;
	}

	public void addShip(Ship aP) {
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] == null) {
				fleet[i] = aP;
				return;
			}
		}

		System.out.println("The fleet of ships is full!");
	}

	public Ship removeShip(Ship aP) {
		for (int i = 0; i < fleet.length;) {
			if (fleet[i] != null && fleet[i].equals(aP))
			{
				System.out.println("Removing Ship :" + aP.getName());
				aP = null;
			}
			if(fleet[i] == null) {
				System.out.println("Ship not found in fleet");
			}
		}
		return aP;
	}

	public Ship renameShip(Ship aP) {
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null && fleet[i].equals(aP)) {
				System.out.println("Please enter the new name for ship ");
				String xName = key.next();
				aP.setName(xName);
				fleet[i] = aP;
			
			}
		}
		System.out.println("That ship was not found");
		return aP;
	}

	@Override
	public int compare(Ship o1, Ship o2) {
	
		return 0;
	}

}
