package day3;

public class DeleteDuplicate 
{
	public static void main(String[] args) 
	{
		// Delete duplicate characters
		String str="abcdab";
		char s[]=str.toCharArray();
		int length = str.length();
		DeleteDuplicate obj = new DeleteDuplicate();
		obj.removeDuplicates(s, length);	
	}	
	void removeDuplicates(char str[], int n)
	{
		String newStr="";
		int i;
		int j;
		for(i=0;i<n;i++)
		{
			for(j=0;j<i;j++)
			{
				if(str[j]==str[i])				
				break;				
			}
			if(i==j)
			{
				newStr=newStr+str[i];
			}
			
		}
		System.out.println("The String after removing duplicates is "+newStr);				
	}

}
