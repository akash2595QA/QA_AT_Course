package javaPrograms;
import java.util.Scanner;
public class Patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number ");
		int num = sc.nextInt();
		
		//star pyramid pattern
		for(int i=1;i<=num;i++)
		{
			for (int j=(num-i); j>0;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//star number pattern with row number on each row
		for(int i=1;i<=num;i++)
		{
			for (int j=(num-i); j>0;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//star number pattern with each row containing numbers from 1
		for(int i=1;i<=num;i++)
		{
			for (int j=(num-i); j>0;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}

		
		System.out.println();
		System.out.println();
		
		//different pattern
		for(int i=1;i<=num;i++)
		{
			for (int j=(num-i); j>0;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			for(int j=i-1;j>0;j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//different pattern(reverse numbers)
		for(int i=1;i<=num;i++)
		{
			for (int j=(num-i); j>0;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print(num-i+j);
			}
			for(int j=i-1;j>0;j--)
			{
				System.out.print(num-i+j);
			}
			System.out.println();
		}


	}

}
