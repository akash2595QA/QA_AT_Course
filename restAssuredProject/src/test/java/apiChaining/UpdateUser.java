package apiChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser 
{
	@Test
	void test_updateUset(ITestContext context)
	{
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken = "013d1fdaf7c95c63d05d5e272848ef59feecfd3371ea45b2b5c578002c5e667e";
		int id =(Integer) context.getAttribute("user_id") ;
		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			
		.then()	
			.statusCode(200)
			.log().all();
		
		
	}
}
