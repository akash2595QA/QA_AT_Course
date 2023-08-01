package day3;

abstract class AbstractClassParent
{
	abstract void m1();
}

public class AbstractClassChild extends AbstractClassParent
{
	void m1()
	{
		System.out.println("Defined the base method here");
	}

	public static void main(String[] args) 
	{
		// Abstract class and method
		
		AbstractClassChild obj = new AbstractClassChild();
		obj.m1();

	}

}
