package day3;
final class AdminOnly
//This class cannot be inherited by any class
{
	void adminOnlyMethod(){
		System.out.println("This could be only accessed by Admin");
	}
}

class CompanyDetails{
	//Value of final variable here cannot be changed
	final int companyRegNumber=4050123;
	//This final method cannot be overriden
	final void companyName(){
		System.out.println("Company name is XYZ ltd,");
	}
}
class EmployeeDetails extends CompanyDetails{
	void employeeInfo(String name, int ID, char group){
		System.out.println("Employee name is "+name);
		System.out.println("Employee ID is "+ID);
		System.out.println("Employee group is "+group);
	}
}
public class EmployeeDetailsFinalKeyword extends EmployeeDetails{
	public static void main(String[] args) 	{		
		EmployeeDetails obj1 = new EmployeeDetails();
		obj1.employeeInfo("Akash", 1, 'A');
		obj1.companyName();
		int compReg = obj1.companyRegNumber;
		System.out.println("Company Registration number is "+compReg );	
		System.out.println("-----------------------------------------");
		EmployeeDetails obj2 = new EmployeeDetails();
		obj2.employeeInfo("Prasad", 2, 'B');
		obj2.companyName();
		System.out.println("Company Registration number is "+compReg );
	}

}
