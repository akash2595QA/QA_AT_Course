package day3;

public class RemoveSpaces {

	public static void main(String[] args) 
	{
		// Remove spaces
		String str="a b c";
		char s[]=str.toCharArray();
		int length = str.length();
		RemoveSpaces obj = new RemoveSpaces();
		obj.deleteDuplicates(s, length);	

	}
	void deleteDuplicates(char str[], int n)
	{
		String newStr="";
		int i;
		int j;
		for(i=0;i<n;i++)
		{
			if(str[i]!='\s')
			{
				newStr=newStr+str[i];
			}
			
		}
		System.out.println("The String after removing spaces is "+newStr);				
	}

}
