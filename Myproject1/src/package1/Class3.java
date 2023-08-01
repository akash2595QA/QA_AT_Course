package package1;

public class Class3 
{


	public static void main(String[] args) 
	{
		// print number 10 times using for, while and do while
		
		System.out.println("Using For loop:");
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
		}
		
		System.out.println("----");
		System.out.println("Using While loop");
		
		int i=1;
		while(i<=10)
		{
			System.out.println(i);
			i++;
		}
		
		System.out.println("----");
		System.out.println("Using Do While loop");
		
		int j=1;
		do {
			System.out.println(j);
			j++;
		}while(j<=10);
	}

}
