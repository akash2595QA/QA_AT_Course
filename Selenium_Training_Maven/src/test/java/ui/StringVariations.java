package ui;

public class StringVariations {

	public static void main(String[] args) {
		// String literal is immutable(non changeable object)
				String sl1 = "Akash";
				String sl2 = "Akash";
				//System.out.println("Using String class concat function gives "+s2); 
				System.out.println(sl1==sl2);
				System.out.println(sl1.equals(sl2));
		
				System.out.println();
		
		// String new is immutable(non changeable object)
		String sn1 = new String("Akash");
		String sn2 = new String("Akash");
		//System.out.println("Using String class concat function gives "+s2); 
		System.out.println(sn1==sn2);
		System.out.println(sn1.equals(sn2));
		
		System.out.println();
		
		//string buffer is mutable(Changes can be done in object)
		StringBuffer sb1 = new StringBuffer("Akash");
		sb1.append("Akash");
		//StringBuffer sb2 = new StringBuffer(sb1.append("Akash"));
		System.out.println("String Buffer class append function returns "+sb1);
		//System.out.println(sb1==sb2);
		//System.out.println(sb1.equals(sb2));

	}
	

}
