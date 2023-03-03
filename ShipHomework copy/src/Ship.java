//Written by Jason Milton
public class Ship {

	private String name;
	private String launchDate;
	private double launchYear;
	private String sLaunchYear;

	public Ship() {
		this.name = "Ship name Unkown";
		this.launchDate = "01-01-1990";

	}

	// parameterized constructor
	public Ship(String xName, String xLaunchDate) {
		this.setName(xName);
		this.setLaunchDate(xLaunchDate);

	}

	public String getName() {
		return this.name;
	}

	public String getLaunchDate() {
		return this.launchDate;
	}

	public void setName(String xName) {
		this.name = xName;
	}

	public void setLaunchDate(String xLaunchDate) {

		this.launchDate = xLaunchDate;

		/*
		 * if(this.launchYear >= 1990 && this.launchYear <= 2019)//Figure out how to
		 * isolate the last 4 integer of(xLaunchDate )
		 * {
		 * this.launchDate = xLaunchDate;
		 * 
		 * 
		 * }
		 * else
		 * {
		 * System.out.println("Invalid input for launch date!");
		 * }
		 */
	}

	public double getLaunchYear() {

		this.launchYear = Double.parseDouble(sLaunchYear.substring(6));
		return this.launchYear;
	}

	// Need to create more validation statements to check for valid values for day
	// and month
	public void setLaunchYear() {
		sLaunchYear = this.launchDate.substring(6);
		this.launchYear = Double.parseDouble(sLaunchYear);
		if (this.launchYear >= 1990 && this.launchYear <= 2019) {
			this.launchYear = Double.parseDouble(sLaunchYear);
		} else {
			System.out.println("Invalid launch date!");
		}

	}

	public void writeOutput() {

		System.out.println("Ship Name: " + this.name
				+ "\nLaunch Date: " + this.launchDate);
	}

}
