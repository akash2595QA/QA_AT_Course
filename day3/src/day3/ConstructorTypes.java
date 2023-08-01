package day3;

public class ConstructorTypes 
{
	
	String name;
	int id;
	char group;
	static String college_name="NMIS";
	

	public static void main(String[] args) 
	{		// Multiplication using different constructor types
		ConstructorTypes obj1 = new ConstructorTypes(7,6.0);	
	}	
	ConstructorTypes(int x, int y)	
	{
		int mult = x*y;
		System.out.println("Multiplication of "+x+" & "+y+" is "+mult  );
	}	
	ConstructorTypes(float x, float y)	
	{
		float mult = x*y;
		System.out.println("Multiplication of "+x+" & "+y+" is "+mult  );
	}	
	ConstructorTypes(double x, double y)	
	{
		double mult = x*y;
		System.out.println("Multiplication of "+x+" & "+y+" is "+mult  );
	}	
	ConstructorTypes(int x, double y)	
	{
		double mult = x*y;
		System.out.println("Multiplication of "+x+" & "+y+" is "+mult  );
	}	


}
