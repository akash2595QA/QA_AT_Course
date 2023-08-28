package collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class HashMapExamples {

	public static void main(String[] args) {
		// Declare HashMap
		//HashMap hm = new HashMap();
		HashMap <Integer, String> hm = new HashMap <Integer, String>(); 
		
		hm.put(101, "John");
		hm.put(102, "David");
		hm.put(103, "Scott");
		hm.put(104, "Mary");
		hm.put(105, "Tye");
		hm.put(106, "David");
		
		System.out.println(hm);//Duplicate keys not allowed and insertion order is preserved
							   //Duplicate values are allowed
		
		System.out.println(hm.get(102));
		
		System.out.println("removed: "+hm.remove(104));
		System.out.println("After removing: "+hm);
		
		System.out.println(hm.containsKey(101)); //true
		System.out.println(hm.containsKey(104)); //false
		
		System.out.println(hm.containsValue("John")); //true
		System.out.println(hm.containsValue("Mary")); //false
		
		//isEmpty() method same for all collection
		
		System.out.println("keysets: "+hm.keySet());//retrieve only keys from HashMap which returns set
		for(Object e: hm.keySet())
		{
			System.out.println(e);
		}
		System.out.println();
		System.out.println("return all values: "+hm.values());//return all the values as Collection
		for(Object e: hm.values())
		{
			System.out.println(e);
		}
		System.out.println();
		//now to print key and value in one entry
		for(Object e: hm.keySet())
		{
			System.out.println(e+"   "+hm.get(e));
		}
		
		System.out.println("Entry sets: "+hm.entrySet());//retrun all entries as set object
		
		//Entry methods
		
		for(Map.Entry entry: hm.entrySet())
		{
			System.out.println(entry.getKey()+"  "+entry.getValue());
			//System.out.println(entry.getValue());
		}
		
		System.out.println("Using iterator method");
		//get entries using iterator method
		Set s = hm.entrySet();
		
		Iterator it = s.iterator();
		while(it.hasNext())
		{
			Map.Entry entry = (Entry) it.next();
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		
		

	}

}
