package day3;

public class ExceptionWithMultipleCatch {
	
	public static void main(String[] args) {
	try
	{
		int array[]=new int[5];
		array[9]=10/0;
	}
	catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("The error is "+e);
	}
	catch(ArithmeticException e)
	{
		System.out.println("The error is "+e);
	}
	System.out.println("The code written after all the catch blocks");

}
}
