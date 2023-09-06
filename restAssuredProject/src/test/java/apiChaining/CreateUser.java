package apiChaining;
import com.github.javafaker.Faker;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateUser 
{
	@Test
	void test_createUser(ITestContext context)
	{
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Inactive");
		
		String bearerToken = "013d1fdaf7c95c63d05d5e272848ef59feecfd3371ea45b2b5c578002c5e667e";
		
		int id = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath()
			.getInt("id");
		
		System.out.println(id);
		
		context.setAttribute("user_id", id);
		
	}

}
