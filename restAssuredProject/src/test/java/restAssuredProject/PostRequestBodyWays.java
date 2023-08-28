package restAssuredProject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONTokener;


public class PostRequestBodyWays 
{

/*	***In how many ways can we create body in POST request.
	1) using HashMap
	2) using org.json library
	3) using pojo class(plain old java object)
	4) using external .json file ..!  */
	
	//1) using HashMap
	
//	@Test(priority=1)
	void postHashMap1()
	{
		HashMap hm = new HashMap();
		hm.put("name", "sky");
		hm.put("location", "Portugal");
		hm.put("phone", "875867887");
		
		String courseArr[] = {"Ruby", "Postman"};
		hm.put("cources", courseArr);
	
		given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("sky"))
			.body("location", equalTo("Portugal"))
			.body("phone", equalTo("875867887"))
			.body("cources[0]", equalTo("Ruby"))
			.body("cources[1]", equalTo("Postman"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
	
	
	//Delete Request
	@Test(priority=2)
	void deleteData()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/4")
					
		.then()
			.statusCode(200);
	}
	
	//2)using json library
//	@Test(priority=1)
	void postUsingJson()
	{
		JSONObject data = new JSONObject();
		data.put("name", "sky");
		data.put("location", "Portugal");
		data.put("phone", "875867887");
		
		String courseArr[] = {"Ruby", "Postman"};
		data.put("cources", courseArr);
	
		given()
			.contentType("application/json")
			.body(data.toString())       //here data has to be in string format so we have to convert it
								// from json format to string format
		
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("sky"))
			.body("location", equalTo("Portugal"))
			.body("phone", equalTo("875867887"))
			.body("cources[0]", equalTo("Ruby"))
			.body("cources[1]", equalTo("Postman"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
	
	
	//3)using pojo class
	//@Test(priority=1)
	void postUsingPOJO()
	{
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setName("sky");
		data.setLocation("Portugal");
		data.setPhone("875867887");
		
		String courseArr[] = {"Ruby", "Postman"};
		data.setCourses(courseArr);
	
		given()
			.contentType("application/json")
			.body(data)       
		
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("sky"))
			.body("location", equalTo("Portugal"))
			.body("phone", equalTo("875867887"))
			.body("courses[0]", equalTo("Ruby"))
			.body("courses[1]", equalTo("Postman"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
	
	//4) using external .json file
	
	@Test(priority=1)
	void postUsingExternalJson() throws FileNotFoundException
	{
		File fl = new File(".\\body.json"); //open file
		FileReader fr = new FileReader(fl); //read file
		JSONTokener jt = new JSONTokener(fr); //generate json token
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())       //here data has to be in string format so we have to convert it
								// from json format to string format
		
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("sky"))
			.body("location", equalTo("Portugal"))
			.body("phone", equalTo("875867887"))
			.body("cources[0]", equalTo("Ruby"))
			.body("cources[1]", equalTo("Postman"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
	
}
