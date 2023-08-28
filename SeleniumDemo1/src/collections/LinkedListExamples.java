package collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExamples {

	public static void main(String[] args) {
		// Declare Linked list for Heterogeneous data
		LinkedList l = new LinkedList();
		
		//Declare LinkedList for Homogeneous data 
		//LinkedList <String> ls = new LinkedList<String>();
		//LinkedList <Integer> li = new LinkedList <String>();
		
		l.add(21);
		l.add("Welcome");
		l.add(true);
		l.add("15.5");
		l.add("A");
		l.add(null);
		System.out.println(l);
		
		//size
		System.out.println("Size is : "+l.size());
		
		//removing
		l.remove(4);
		System.out.println("After removing one element: "+l);
		
		//add element at a particular index
		l.add(4, "C");
		System.out.println("Adding in the middle of the list : "+l);
		
		//retrieving/fetch element
		System.out.println("The element you are looking for is "+l.get(4));
		
		//replace element
		l.set(5, "java");
		System.out.println("After replacing: "+l);
		
		//search element use contains() method
		System.out.println(l.contains("java")); //true
		System.out.println(l.contains("xyz"));  //false
		
		//isEmpty
		System.out.println("is the linkedlist empty? :"+l.isEmpty());
		
		//Reading elements from LinkedList
		//1)Using for loop
		for(int i=0; i<l.size();i++)
		{
			System.out.print(l.get(i));
			System.out.print(" ");
		}
		System.out.println();
		
		//2)Using for each loop
		for(Object e: l)
		{
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println();
		
		//3)Using iterator class
		Iterator it = l.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next());
			System.out.print(" ");
		}
		System.out.println();
		
		//addAll() and removeAll() are used to add/remove collections to/from the duplicate
		//linked list which are similar to those of Arraylist
		
		//Sorting in  ascending and in reverse order are used from Collections class method
		//which is similar to Arraylist.
		
		//shuffle also same as ArrayList
		
		//There are some specific methods for linked list for implementing stack and queue methods
		
		LinkedList l1 = new LinkedList();
		l1.add("Dog");
		l1.add("Cat");
		l1.add("Elephant");
		l1.add("Snake");
		System.out.println("Before operations "+l1);
		
		//addFirst() and addLast()
		l1.addFirst("Tiger");
		l1.addLast("Lion");
		System.out.println("after adding first and last element "+l1);
		
		//getFirst and getLast
		System.out.println("Fist element is: " +l1.getFirst());
		System.out.println("last element is: "+l1.getLast());
		
		//removeFirst() removeLast()
		l1.removeFirst();
		l1.removeLast();
		System.out.println("After removing first and last element: "+l1);
		
		
		
		
		
		
	}

}
