package day3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaPractice {

	public static void main(String[] args) 
	{
		
		//stringDuplicateUsingHashmap();
		//palindrome();
		//palindromeStringBuilder();
		//numberReverse();
		//reverseArrayWithTemp();
		//reverseWords();
		//primeNum();
		largestandSmallestNum();
	}
	
	public static void stringDuplicateUsingHashmap() {
		String[] s = {"akash", "sky", "rahul", "akash", "mahesh", "rahul"};
		HashMap<String, Integer> hm = new HashMap<>();
		for(String str: s)
		{
			Integer count = hm.get(str);
			if(count==null)
			{
				hm.put(str, 1);
			}
			else
			{
				hm.put(str, ++count);
			}
		}
		System.out.println(hm);
		
		for(Map.Entry<String, Integer> entry: hm.entrySet())
		{
			if(entry.getValue()>1)
			{
				System.out.println("Duplcate string is "+entry.getKey());
			}
		}
		
	}
	
	public static void palindrome()
	{
		
		//palindrome
		System.out.println("Enter a String");
		Scanner sc = new Scanner(System.in);
		String str_pal = sc.nextLine();
		int len=str_pal.length();
		boolean status=true;
		int count=0;
		for(int i=0; i<len/2; i++)
		{
			if(str_pal.charAt(i) == str_pal.charAt(len-1-i))
			++count;	
		}
		System.out.println(count);
		if(count>=len/2)
		{
			System.out.println("String is Palindrome");
		}
		else
			System.out.println("String is not Palindrome");	
	}

	
	public static void palindromeStringBuilder()
	{
		
		//palindrome
		System.out.println("Enter a String");
		Scanner sc = new Scanner(System.in);
		String str_pal = sc.nextLine();
		StringBuilder sb = new StringBuilder(str_pal);
		String rev_str = sb.reverse().toString();
		
		System.out.println(str_pal+"      "+rev_str);
		if(str_pal.equals(rev_str))
		{
			System.out.println("String is Palinderome");
		}
		else
		{
			System.out.println("String is not palindrome");
		}
		
		
	}
	
	public static void numberReverse()
	{
		System.out.println("Enter a number to reverse ");
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		
		long rev = 0;
		while(num != 0)
		{
			rev = rev*10 +num % 10;
			num = num/10;
		}
		System.out.println("Reverse of is "+rev);	
	}
	
	public static void reverseArrayWithTemp()
	{
		System.out.println("Enter 5 numbers to reverse ");
		int[] num = new int[5]; 
		for(int i=0; i<5;i++)
		{
			Scanner sc = new Scanner(System.in);
			num[i]=sc.nextInt();		
		}
		int len=num.length;
		int temp;
		for(int i=0;i<len/2;i++)
		{
			temp = num[i];
			num[i] = num[len-1-i];
			num[len-1-i]=temp;
		}
		System.out.println(Arrays.toString(num));
	}
	
	
	//reverse words
	
	public static void reverseWords()
	{
		System.out.println("Enter 5 words with space");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		StringBuilder sbr = new StringBuilder();
		
		String[]  wordsArr= str.split(" ");
		System.out.println(Arrays.toString(wordsArr));
		int len = wordsArr.length;
		
		for(int i=len-1; i>=0; i--)
		{
			sbr.append(wordsArr[i]).append(" ");
		}
		System.out.println(sbr.toString().trim());
	}
	
	public static void primeNum()
	{
		System.out.println("Enter a number to check if it is prime");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean status=false;
		for(int i=2; i<=num/2; i++)
		{
			if(num%i==0)
			{
				status=true;
				break;
				
			}
		}
		System.out.println(status);
		if(status==true)
		{
			System.out.println(num+" is not prime");
		}
		else
			System.out.println(num+" is prime");
	}
	
	static void largestandSmallestNum()
	{
		int[] arrNum = new int[5];
		System.out.println("Enter 5 numbers");
		for(int i=0; i<5; i++)
		{
			Scanner sc = new Scanner(System.in);
			arrNum[i] = sc.nextInt();
		}
		int largest = arrNum[0];
		int smallest = arrNum[0];
		
		for(int i=1; i<arrNum.length;i++)
		{
			if(arrNum[i]>largest)
			{
				largest = arrNum[i];
			}
			else if(arrNum[i]<smallest)
			{
				smallest = arrNum[i];
			}		
		}
		System.out.println("Largest number is "+largest);
		System.out.println("Smallest number is "+smallest);
		
	}
	
	
}