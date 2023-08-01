package day3;

public class UsingExceptionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			
	
			int array[]=new int[10];
			array[12]=8;
			int a=6/0;
						
		}
		catch(Exception e) {
			System.out.println("The error is "+e);

	}
		System.out.println("The code written after catch ");

}
}
