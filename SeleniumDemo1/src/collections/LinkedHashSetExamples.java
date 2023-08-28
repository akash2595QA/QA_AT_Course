package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
public class LinkedHashSetExamples {

	public static void main(String[] args) {
		// Here duplicates are not allowed but insertion order is preserved
		
		HashSet<Integer> hset = new HashSet <Integer>();
		hset.add(100);
		hset.add(200);
		hset.add(300);
		hset.add(400);
		hset.add(500);
		System.out.println("Hashset is: "+hset);//Random order
		
		
		LinkedHashSet<Integer> lhset = new LinkedHashSet <Integer>();
		lhset.add(100);
		lhset.add(200);
		lhset.add(300);
		lhset.add(400);
		lhset.add(500);
		System.out.println("LinkedHashset is: "+lhset);//Preserved order
		
		//rest all the methods are same as HashSet
	}

}
