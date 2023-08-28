package restAssuredProject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.*;
import io.restassured.path.xml.*;

public class ParseXMLResponse 
{
	//here instead of json path we use xmlpath
	
//	@Test
	void testXMLResponseDirect() 
	{
		given()
			
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].id", equalTo("11133"));
	}
	
	//verify total number of traverlers using XMLPath object and verify for a name
	@Test
	void testXMLResponseXMLPathmethod() 
	{
		Response res =	given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath obj = new XmlPath(res.asString());
		List<String> travelers = obj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		System.out.println(travelers.size());
		List<String> travelers_name = obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		System.out.println(travelers.size());
		
		boolean status = false;
		for(String s: travelers_name)
		{
			if(s.equals("Developer"))
			{
			status = true;
			break;
			}
		}
		
		Assert.assertEquals(status, true);
	}
	
}
