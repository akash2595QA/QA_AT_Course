package day3;

public class ExceptionWithOneCatch {

	public static void main(String[] args) {
		// Try Catch Block
		
		try {
		int x=10/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("The error is "+e);
		}
		System.out.println("The code written after declaring variable x");

	}

}
