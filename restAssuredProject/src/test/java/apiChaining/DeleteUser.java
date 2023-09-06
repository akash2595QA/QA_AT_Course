package apiChaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser 
{
	@Test
	void deleteUser(ITestContext context)
	{
		int id=(Integer) context.getAttribute("user_id") ;
		String bearerToken = "013d1fdaf7c95c63d05d5e272848ef59feecfd3371ea45b2b5c578002c5e667e";
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204)
		.log().all();
	}

}
