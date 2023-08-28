package restAssuredProject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class HttpRequests 

{
	
	//@Test(Priority=1)
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
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		//	.jsonPath().getInt("id");  //capture id from response and store in varaible
		
		.then()
			.statusCode(201)
			.log().all();
	}

}
