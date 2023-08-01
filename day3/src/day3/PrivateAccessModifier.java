package day3;

class Default
{
	private int x=10;
	private void PrivateVehicleModule()
	{
		System.out.println("Vehicle Properties in private");
	}
	void Module()
	{
		System.out.println("Non private method code");
	}
}


public class PrivateAccessModifier extends Default {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Default obj = new Default();
		obj.PrivateVehicleModule(); //Since this method is private in the above class, it is not visible in subclass
		obj.Module();
		int y=obj.x; //x variable cannot be accessed as it is private
		
	}
}

