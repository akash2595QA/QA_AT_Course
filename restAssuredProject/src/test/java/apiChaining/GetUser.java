package apiChaining;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser 
{
	@Test
	void testGetUser(ITestContext context)
	{
		int id=(Integer) context.getAttribute("user_id") ; //this should come from createUser response
		String bearerToken = "013d1fdaf7c95c63d05d5e272848ef59feecfd3371ea45b2b5c578002c5e667e";
		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id) //path parameter should be passed in get() url
								//query param is not required to be passed in get() url
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}
