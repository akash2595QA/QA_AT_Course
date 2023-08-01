package day3;

class DefaultClass
{
	int x=10; //Using Default access modifier
	void VehicleModule() //Using Default Access modifier
	{
		System.out.println("Vehicle Properties with default modifier");
	}
	void Module()
	{
		System.out.println("Method 2 code");
	}
}

public class DefaultAccessModifierClass extends Default {

	public static void main(String[] args) {
		// Default Access modifier
		
		DefaultClass obj = new DefaultClass();
		obj.VehicleModule();
		obj.Module();
		System.out.println("Default varaible x from the above method is "+obj.x);

	}

}
