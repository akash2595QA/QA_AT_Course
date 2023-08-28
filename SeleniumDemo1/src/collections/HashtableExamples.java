package collections;
import java.util.Hashtable;
public class HashtableExamples {

	public static void main(String[] args) {
		// Declare
		
		Hashtable ht = new Hashtable(); //capacity 11, loadfactor 0.75
		Hashtable htc = new Hashtable(100, (float)0.95); //capacity 100, load factor 0.95
		Hashtable<Integer, String> ht1 = new Hashtable<Integer, String>();
		
		ht1.put(101, "John");
		ht1.put(102, "David");
		ht1.put(103, "Smith");
		//ht1.put(null, "X"); //this will show exception since in hashtable null key is not allowd
		System.out.println(ht1);//insertion order is not preserved
		
		//get(key) same as HashMap
		//remove(key) same as HashMap
		//containsKey(key) will chk if this particular key is present or not
		//containsValue(value) will chk if this particulat value is present or not
		//isEmpty() same as HashMap
		//keySet() same as hashMap will return all keys as Set
		//values() return all values from the Hashtable as Collection
		
		//Entry specific methods similar to hashMap
		
		
		
		
	}

}
