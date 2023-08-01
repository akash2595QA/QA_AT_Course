package day3;

public class RecursionFunction {

	public static void main(String[] args) 
	{
		// Recursion
		
		RecursionFunction obj = new RecursionFunction();
		int result=obj.fact(10);
		System.out.println("Factorial of the given number is "+result);

	}
	
	public int fact(int k)
	{
		if(k>1)
		{
			return k * fact(k-1);
		}
		else
			return 1;
	}

}
