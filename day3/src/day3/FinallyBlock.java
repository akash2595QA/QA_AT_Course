package day3;

public class FinallyBlock {
	
	public static void main(String[] args) {
		// Try Catch Block
		
		try {
		int x=10/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("The error is "+e);
		}
		finally {
		System.out.println("Finally block code");	
		}
		System.out.println("End of the code after finally block");
		
	}	

}
