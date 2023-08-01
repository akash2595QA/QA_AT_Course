package day3;

class Vehicle
{
	
	void vehicleModule()
	{
		System.out.println("Common Vehicle Properties");
	}
}

class Bike extends Vehicle 
{
	void BikeModule()
	{
		System.out.println("This keyword");
	}
	void vehicleModule()
	{
		super.vehicleModule();
		this.BikeModule();
		System.out.println("Only Bike Properties");
	}

	public static void main(String[] args) 
	{
		Bike obj = new Bike();
		obj.vehicleModule();		
	}

}
