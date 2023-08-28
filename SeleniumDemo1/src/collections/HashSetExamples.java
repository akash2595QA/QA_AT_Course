package collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExamples {

	public static void main(String[] args) {
		// HashSet does not support duplicates and values are stored randomly which
		//means insertion order is not preserved.
		
		HashSet hs = new HashSet(); //default size is 16 and Load factor is 0.75
		
	//	HashSet hs_new = new HashSet(100, (float) 0.95); //size is 100 and Load factor is 0.95
		
		//adding elements
		hs.add("101");
		hs.add("A");
		hs.add("Welcome");
		hs.add(16.6);
		hs.add(null);
		hs.add(true);
		
		System.out.println("Initial HashSet is "+hs); //It will print in random order
		
		//remove()
		hs.remove(16.6);
		System.out.println("Initial HashSet is "+hs);
		
		//No get() and set() methods in HashSet since we do not have index
		
		//contains() and isEmpty() similar to ArrayList/LinkedList
		
		//Reading elements can be done in just 2 ways : for each loop and iterator method
		
		//1)for each loop
		for(Object e:hs)
		{
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println();
		
		//2)iterator method
		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next());
			System.out.print(" ");
		}
		System.out.println();
		
		//addAll() and removeAll() similar to those of List
		
		//methods to perform union, intersections and differences
		
		HashSet <Integer> set1 = new HashSet <Integer> ();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(6);

		HashSet <Integer> set2 = new HashSet <Integer> ();
		set2.add(8);
		set2.add(2);
		set2.add(9);
		set2.add(4);
		
		//to find union of two sets(combine unique elements from both sets)
		//set1.addAll(set2);
		//System.out.println("Union: "+set1);
		
		//Intersection(give common elements from 2 sets)
		//set1.retainAll(set2);
		//System.out.println("Intersection: "+set1);
		
		//To find difference
		//set1.removeAll(set2);
		//System.out.println("Difference: "+set1);
		
		//subset
		set1.containsAll(set2);//true
		System.out.println("Subset: "+set1);
		

	}

}
