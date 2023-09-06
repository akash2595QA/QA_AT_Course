package day3;
import java.util.*;



public class JavaIntQuestionsNaveenAutom {

	public static void main(String[] args) {
		// 1) Reverse String - we can use StringBuffer reverse() method or in Normal Sting we can
		// pop each char using charAt() method and append it in new string

		
		//2) Remove Junk
		String s = "&*&**&%abcDEF880";
		s = s.replaceAll("[^a-bA-b0-9]", ""); //regex <-- regular expression
		System.out.println(s);
		
		
		//3)Reverse a integer
		int num = 12345;
		int rev =0;
		while(num!=0)
		{
			rev = rev * 10 + num % 10;
			num = num/10;
		}
		System.out.println(rev);
		//using StringBuffer
		long num1 = 12345;
		StringBuffer s3 = new StringBuffer(String.valueOf(num1)).reverse(); 		
		System.out.println(s3);		
		
		
		//4)MissingNumber like from 1245 number 3 is missing
		int[] a = {1, 2, 4, 5};
		int sum = 0;
		for(int i=0; i<a.length; i++)
		{
			sum = sum + a[i];
		}
		int sum1=0;
		for(int i=1; i<=a.length+1;i++)
		{
			sum1=sum1+i;
		}
		System.out.println("Missing number is "+(sum1-sum));
		
		
		//5)Print Duplicate elements from Array
		String[] s5 = {"Java", "Ruby", "C", "Java", "C", "Python"};
		for(int i=0; i<s5.length; i ++)
		{
			for(int j=i+1; j<s5.length;j++)
			{
				if(s5[i].equals(s5[j]))
				{
					System.out.println("Duplicate element is "+s5[i]);
				}
			}
		}
		//Using HashSet
		Set<String> hs = new HashSet<>();
		for(String name : s5)
		{
			if(hs.add(name)==false)
			{
				System.out.println("Duplicate element is "+name);
			}
		}
		//usingHashMap
		System.out.println("Using Hashmap");
		Map<String, Integer> hm = new HashMap<>();
		for(String name : s5)
		{
			Integer count = hm.get(name);
			if(count == null)
			{
				hm.put(name, 1);
			}
			else
			{
				hm.put(name, ++count);
			}		
		}
		for(Map.Entry<String, Integer> entry: hm.entrySet())
		{
			if(entry.getValue() > 1)
			{				
				System.out.println("Duplicate element is "+ entry.getKey());	
			}
		}	
		
		
		//6) Find largest and smallest number
		System.out.println("Find largest and smallest number");
		int[] numbers = {-29, 24, 50, -88, 89758};
		int largest = numbers[0];
		int smallest = numbers[0];	
		for(int i=1; i<numbers.length; i++)
		{
			if(numbers[i]>largest)
			{
				largest = numbers[i];
			}
			else if(numbers[i]<smallest)
			{
				smallest = numbers[i];
			}
		}
		System.out.println("\n"+Arrays.toString(numbers));
		System.out.println("largest is "+largest);
		System.out.println("Smallest is "+smallest);
		
		//7) String methods
		//length()
		//charAt()
		//indexOf()
		//If in indexOf method the element is not available it will return -1
		//equals()
		//equalsIgnoreCase()
		//substring(beg index, end index)
		//trim() --> remove before and after space
		//replace(" ", "")  <-- removes between spaces
		//split() <-- mention the delimiter and store it in array
		//concat()
		
		
		
		
		
		
		
		//
		
	}
}
