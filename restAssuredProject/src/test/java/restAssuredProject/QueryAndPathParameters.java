package restAssuredProject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryAndPathParameters 
{
	/* https://reqres.in/api/users?page=2
		https://reqres.in/ --> domain 
		/api/users --> path
		?page=2 --> query parameter */
	
	
	@Test
	void testQueryAndPathParameters()
	{
		//Query parameter can be send directly via method(need not mention it in get url)
		//path parameter has to be mentioned in get url
		
		//https://reqres.in/api/users?page=2&id=5
		
		given()
			.pathParam("myPath", "users")
			.queryParams("page", 2)
			.queryParam("id", 5)
			
		
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
}


