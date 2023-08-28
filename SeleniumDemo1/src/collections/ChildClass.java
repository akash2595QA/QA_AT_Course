package collections;



public class ChildClass extends ParentClass{
	
	
	public void methodname()
	{
		System.out.println("This is Child Class");
	}
	public static void main(String[] args) {
		ParentClass p= new ChildClass();
		p.methodname();
		

	}

}
