//Written by Jason Milton
public class CruiseShip extends Ship {

	private int capacity;
	private int crew;

	public CruiseShip() {
		super();
		this.capacity = 1;
		this.crew = 1;

	}

	public CruiseShip(String xName, String xLaunchDate, int xCapacity, int xCrew) {
		super(xName, xLaunchDate);
		this.setCapacity(xCapacity);
		this.setCrew(xCrew);
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getCrew() {
		return this.crew;
	}

	public void setCapacity(int xCapacity) {
		if (xCapacity >= 1) {
			this.capacity = xCapacity;
		} else {
			System.out.println("Invalid entry for Ship Capacity!");
		}
	}

	public void setCrew(int xCrew) {
		if (xCrew >= 1) {
			this.crew = xCrew;
		} else {
			System.out.println("Invalid entry for Crew!");
		}

	}

	public void writeOutput() {
		
		System.out.println("Ship Name: " + super.getName()
				+ "\nLaunchDate :" + super.getLaunchDate()
				+ "\nCapacity : " + this.capacity
				+ "\nCrew Members: " + this.crew);

	}
}
