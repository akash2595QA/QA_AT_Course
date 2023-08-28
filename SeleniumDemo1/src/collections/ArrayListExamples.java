package collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ArrayListExamples {

	public static void main(String[] args) {
		
		// Declaring Array list in heterogenous form
		ArrayList al = new ArrayList();
		
		//Declaring ArrayList in Homogenous  form
	//	ArrayList <String> al1 = new ArrayList<String>();
	//	ArrayList <Integer> al2 = new ArrayList<Integer>();
	//	List al3 = new ArrayList();
		
		
		//insert element in Arraylist
		al.add(20);
		al.add("Welcome");
		al.add(15.25);
		System.out.println(al);
		
		//size
		System.out.println("Size of element is "+al.size());
		
		//remove element
		al.remove(1);
		
		//insert new element in middle
		al.add(0, "Python");
		System.out.println("After insertion "+al);
		
		//retrive element
		System.out.println("Retrived element is "+al.get(0));
		
		//replace element
		al.set(1, true);
		System.out.println("After replacing Arraylist is : "+al);
		
		//search element
		System.out.println("Does the arralst contain 15.25 value: "+al.contains(15.25));
		
		//isEmpty
		System.out.println("is the array empty?: "+al.isEmpty());
		
		//Read elements from ArrayList using 3 ways
		//1) for loop
		for (int i=0; i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print(" ");
		}
		System.out.println();
		//2)Using For each
		for(Object e:al)
		{
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println();
		
		//3) Using iterator method from Iterator interface which is parent interface of collection interface
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next());
			System.out.print(" ");
		}
		
		//Using add all method
		ArrayList arrl = new ArrayList();
		arrl.add("X");
		arrl.add("Y");
		arrl.add("Z");
		arrl.add("L");
		arrl.add("M");
		arrl.add("N");
		arrl.add("O");
		
		System.out.println("Print the initial arraylist ");
		System.out.println(arrl);
		
		ArrayList arrl_dup = new ArrayList();
		arrl_dup.addAll(arrl);
		System.out.println("Print the duplicate Arraylist");
		System.out.println(arrl_dup);
		
		//using remove all method
		System.out.println("After removing all elements from dupicate arraylist");
		arrl_dup.removeAll(arrl);
		System.out.println(arrl_dup);
	
		//For sorting elements in arraylist in ascending or reverse order we do not have direct methods in Arraylist,
		//We have to use it from collections class Collections.sort();
		
		//sort
		Collections.sort(arrl);
		System.out.println("After sorting");
		System.out.println(arrl);
		
		//reverse sort
		Collections.sort(arrl, Collections.reverseOrder());
		System.out.println("After reversing the order");
		System.out.println(arrl);
		
		//Shuffling - arranging in random order
		Collections.shuffle(arrl);
		System.out.println("After shuffling");
		System.out.println(arrl);
		
		//To convert Array into ArrayList we have a asList() method in Arrays class which is in java.util package 
		String arr[] = {"Dog", "Cat", "Elephant"};
		System.out.println("Print the array");
		for(String s: arr)
		{
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.println();
		ArrayList cal = new ArrayList(Arrays.asList(arr));
		System.out.println("Printing the array converted to arraylist");
		System.out.println(cal);
	}

}
