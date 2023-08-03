package javaPrograms;
import java.util.HashMap;

public class TwoSumsHashMap {
	
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++)
    	{
    		int ReqNum = target - nums[i];
    		if(map.containsKey(ReqNum))
    		{
    			int[] toReturn = {map.get(ReqNum), i};
    			return toReturn;
    		}
    		else
    		map.put(nums[i], i);	
    	}
    	return null;

        
    }

	public static void main(String[] args) {
	    int[] array = {2,4,6,8};
	    int targetSum=14;
	    TwoSumsHashMap s = new TwoSumsHashMap();
	    int[] output1=s.twoSum(array,targetSum);
	    
	    for(int var : output1)
	    {
	    System.out.print(var+" ");
	    }

	}

}
