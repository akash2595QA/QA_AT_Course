package day3;
interface class1
{
	void a();	
}

interface class2
{
	void b();
}

class ClassC implements class1, class2
{
	
	public void a()
	{
		System.out.println("interface method A defination");
	}
	
	public void b()
	{
		System.out.println("interface method B defination");
	}

	public static void main(String[] args) 
	{
		// interfaces
		ClassC obj = new ClassC();
		obj.a();
		obj.b();
	}
}
