package restAssuredProject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation 
{
	@Test
	void jsonSchemaValidate()
	{
		given()
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			//.assertThat().body(RestAssuredMatchers.matchesXsd("traveller.xsd") <-- this is for xml validation
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
			
	}
}
