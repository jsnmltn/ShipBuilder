//written by Jason Milton
public class CargoShip extends Ship {
	
	public double dWT;
	public double speed;
	
	public CargoShip()
	{
		super();
		this.dWT = 1.0;
		this.speed = 1.0;
	}
	public CargoShip(String xName, String xLaunchDate, double xDWT, double xSpeed)
	{
		super(xName, xLaunchDate);
		this.setDWT(xDWT);
		this.setSpeed(xSpeed);
	}

	public double getDWT()
	{
		return this.dWT;
	}
	public void setDWT(double xDWT)
	{
		if(xDWT >= 1)
		{
		this.dWT = xDWT;
		}
		else
		{
			System.out.println("Invalid entry for deadweight tonnage!");
		}
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	public void setSpeed(double xSpeed)
	{
		if(xSpeed >= 1)
		{
			this.speed = xSpeed;
		}
	}
	public void writeOutput()
	{
		System.out.println("Ship Name: "+super.getName()
		+"\nDeadweight Tonnage: "+this.dWT
		+"\nMaximum Speed: "+this.speed);
	}
}
