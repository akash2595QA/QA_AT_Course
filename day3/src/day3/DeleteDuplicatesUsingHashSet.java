package day3;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.HashSet;

class DeleteDuplicatesUsingHashSet {
	
	public static void deleteDuplicateMethod(String str)
	{
		char[] ch = str.toCharArray();
		//LinkedHashSet<Character> hs = new LinkedHashSet<>();
		HashSet<Character> hs = new HashSet<>();
		for(int i=0; i<str.length(); i++)
		{
			hs.add(ch[i]);
		}
		
		for(Character c : hs)
		{
			System.out.println(c);
		}
	}
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		deleteDuplicateMethod(s);
		
	}

}
