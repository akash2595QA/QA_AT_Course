package day3;

public class FunctionExample
{
	String name;
	int id;
	char group;
	static String college_name="NMIS";

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub
		
		FunctionExample obj1 = new FunctionExample();
		obj1.studentDetails("Akash", 01, 'A');
		obj1.display();
	
	}	
	void studentDetails(String name, int id, char group)
	{
		this.name=name;
		this.id=id;
		this.group=group;		
	}	
	
	void display()
	{
		System.out.println("Student name is "+name);
		System.out.println("Student id is "+id);
		System.out.println("Student group is "+group);
		System.out.println("College name is "+college_name);
	}
	

}
