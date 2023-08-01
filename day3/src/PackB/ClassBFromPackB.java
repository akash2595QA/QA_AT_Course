package PackB;

import PackA.ClassAFromPackA;

public class ClassBFromPackB {

	public static void main(String[] args) {
		// Main Class
		ClassAFromPackA obj = new ClassAFromPackA();
		obj.ClassAMethod();
		System.out.println("Variable from Pack A Class A is "+obj.x);

	}

}
