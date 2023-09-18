package restAssuredProject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.*;
import org.json.JSONObject;

public class ParseJSONResponse 
{
//	@Test
	void testJsonResponseDirect()
	{
		//1) direct approach
		
		given()
			.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("book[3].title", equalTo("The Lord of the Rings")) //using jsonpath
			.log().headers();
		
	}	
	
	
	//If we want to convert entire response to string we use asString() method
	//If we want to convert a data in string we use toString() method
	
	//@Test
	void testJsonResponseUsingResponseVariable()
	{
		
		//Approach 2 - by storing it in Response variable
		Response res =	given()
			.contentType("ContentType.JSON")
			.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");
		
	}
	
	@Test
	void testJsonResponseUsingJSONObject()
	{
		
		//Approach 3 - by using JSON Object
		Response res =	given()
			.contentType("ContentType.JSON")
			.when()
			.get("http://localhost:3000/store");
		
		JSONObject js = new JSONObject(res.asString()); //converting response object to JSON Object type
		boolean status = false;
		//to get title from each object of books array
		for(int i=0; i<js.getJSONArray("book").length(); i++)
		{
			String bookname = js.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookname);
			if(bookname.equals("The Lord of the Rings"))
			{
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);

		
	}
	
	

}
