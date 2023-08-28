package restAssuredProject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class HttpRequestsCaptureId 

{
	
	int id;
	@Test(priority=1)
	void getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();  //to display output in console window
	}
	
	@Test(priority=2)
	void createUser()
	{
		HashMap data = new HashMap();
		data.put("name", "Akash");
		data.put("job", "engineer");
		
		id = given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");  //capture id from response and store in variable
										// and pass it to id variable and then update user
										//using id
		
	}
	
	@Test(priority=3, dependsOnMethods="createUser")
	void updateData()
	{
		HashMap data = new HashMap();
		data.put("name", "Sky");
		data.put("job", "doctor");
		
		 given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		 
		 .then()
		 	.statusCode(200)
		 	.log().all();

	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}

}
