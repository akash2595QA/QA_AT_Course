package javaPrograms;

public class PrintIndexForAddition {
	
    public int[] twoSum(int[] nums, int target) {
    	int[] output = new int[2];

        
        for(int i=0;i<4;i++)
        {
            for(int j=i+1; j<4;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                
                output[0]=i;
                output[1]=j;
                return output;
              
                }

            }
        }
        
        return null;
        
    }

	public static void main(String[] args) {
	    int[] array = {2,4,6,8};
	    int targetSum=14;
	    PrintIndexForAddition s = new PrintIndexForAddition();
	    int[] output1=s.twoSum(array,targetSum);   
	    for(int i=0;i<output1.length;i++)
	    {
	    	System.out.print(output1[i]+" ");

	}
	}

}
