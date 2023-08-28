package collections;
import java.util.PriorityQueue;

public class QueueExamples {

	public static void main(String[] args) {
		//Declaring priorityQueue
		PriorityQueue q = new PriorityQueue();
		
		//In priority queue heterogeneous data is not allowed only same type of data can be added.
		//In LinkedList heterogeneous data is allowed and rest all the methods are same as PriorityQueue.
		
		//adding elements using add() and offer()
		
		q.add("A");
		q.add("B");
		q.add("C");
		q.offer("C");
		
		System.out.println(q); //Insertion order is preserved and duplicates allowed
		
		//get head element using element() and peek()
		
		System.out.println("using element method: "+q.element());
		System.out.println("Using peek metod: "+q.peek());
		
		//make the queue empty and use same methods
	//	System.out.println("Using element method for empty queue:"+q.element()); //returns NoSuchElementException exception
	//	System.out.println("Using peek method for empty queue: "+q.peek()); //returns null
		
		//return and return element from head using remove() and poll()
		
		//System.out.println("Using remove method it will return and remove as well: "+q.remove());
		//System.out.println(q);
		
		//System.out.println("Using poll method it will return and remove as well: "+q.poll());
		//System.out.println(q);
		
		//if Queue is empty remove() will return exception and poll() will return null.
		
		//iterator and for wach loop can be used to read the elements.

	}

}
