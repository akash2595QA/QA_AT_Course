package package1;
public class Class1 
{
	public static void main(String[] args) 
	{
		
		String str ="staragile";
		char[] c = str.toCharArray();
		char[] reverse=new char[10]; 
		int count=0;
		int length=str.length();
		
		System.out.println("The given string is:");
		for(int z=0;z<length;z++)
		{
		System.out.print(c[z]);
	    }	
		
		System.out.println();
		System.out.println();
			
		for(int i=0;i<length;i++)
		{
			reverse[length-1-i]=c[i];
		}
		
		System.out.println("The reverse of above string is:");
		
		for(int j=0;j<length;j++)
		{
		System.out.print(reverse[j]);
	    }	
	
	
}
}