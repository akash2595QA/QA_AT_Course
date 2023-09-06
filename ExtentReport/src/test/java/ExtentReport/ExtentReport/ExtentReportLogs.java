package ExtentReport.ExtentReport;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportLogs {

	public static void main(String[] args) throws IOException {
		ExtentReports extent = new ExtentReports(); //Extent report Engine
		
		//There are 4 types of Extent Reporters which are also called destinations where our our
		//entire report is printed in its respective format -> one of it is ExtentSparkReporter
		File file = new File("extent-report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReporter); 
		
		extent.createTest("Test 1").pass("This test passed");
		extent.createTest("Test 2").log(Status.FAIL, "This test fails");
		extent.createTest("Test 3").skip("skip this test");
		
		//It is mandatory to call the flush method to ensure
		//information is written to the started reporters.
			
		/* There are 5 types of log levels in EntentReport after v5
		Fail
		Skip
		Warning
		Pass
		Info
		Error, Debug and fatal level logs are removed
		
		If we mention multiple log levels for same test then the order in which above
		log levels are written takes precedence and main test case shows status as per order--> */
		
		//bold
		extent.createTest("Bold and italic text")
			.log(Status.INFO, "<b>bold text</b>")
			.log(Status.INFO, "normal text")
			.log(Status.INFO, "<b><i>bold text</i></b>");
		
		//XML and JSON data we need to handle differenctly
		//as if we directly store it as a text the format would not be good
		
		String jsonData ="{\r\n"
				+ "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\r\n"
				+ "  \"title\": \"Generated schema for Root\",\r\n"
				+ "  \"type\": \"object\",\r\n"
				+ "  \"properties\": {\r\n"
				+ "    \"book\": {\r\n"
				+ "      \"type\": \"array\",\r\n"
				+ "      \"items\": {\r\n"
				+ "        \"type\": \"object\",\r\n"
				+ "        \"properties\": {\r\n"
				+ "          \"author\": {\r\n"
				+ "            \"type\": \"string\"\r\n"
				+ "          },\r\n"
				+ "          \"category\": {\r\n"
				+ "            \"type\": \"string\"\r\n"
				+ "          },\r\n"
				+ "          \"price\": {\r\n"
				+ "            \"type\": \"number\"\r\n"
				+ "          },\r\n"
				+ "          \"title\": {\r\n"
				+ "            \"type\": \"string\"\r\n"
				+ "          },\r\n"
				+ "          \"isbn\": {\r\n"
				+ "            \"type\": \"string\"\r\n"
				+ "          }\r\n"
				+ "        },\r\n"
				+ "        \"required\": [\r\n"
				+ "          \"author\",\r\n"
				+ "          \"category\",\r\n"
				+ "          \"price\",\r\n"
				+ "          \"title\"\r\n"
				+ "        ]\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  },\r\n"
				+ "  \"required\": [\r\n"
				+ "    \"book\"\r\n"
				+ "  ]\r\n"
				+ "}";
		
		String xmlData ="<bookstore>  \r\n"
				+ "  <book category=\"COOKING\">  \r\n"
				+ "    <title lang=\"en\">Everyday Italian</title>  \r\n"
				+ "    <author>Giada De Laurentiis</author>  \r\n"
				+ "    <year>2005</year>  \r\n"
				+ "    <price>30.00</price>  \r\n"
				+ "  </book>  \r\n"
				+ "  <book category=\"CHILDREN\">  \r\n"
				+ "    <title lang=\"en\">Harry Potter</title>  \r\n"
				+ "    <author>J K. Rowling</author>  \r\n"
				+ "    <year>2005</year>  \r\n"
				+ "    <price>29.99</price>  \r\n"
				+ "  </book>  \r\n"
				+ "  <book category=\"WEB\">  \r\n"
				+ "    <title lang=\"en\">Learning XML</title>  \r\n"
				+ "    <author>Erik T. Ray</author>  \r\n"
				+ "    <year>2003</year>  \r\n"
				+ "    <price>39.95</price>  \r\n"
				+ "  </book>  \r\n"
				+ "</bookstore> ";
		
		extent.createTest("Handle XML data")
			.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		extent.createTest("handle JSON Data")
			.info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		/* display collection data for set, Map and List
		extent.createTest("handle Set, Map and List Ordered List (with numbering format)")
			.info(MarkupHelper.createOrderedList("SetData/MapData/ListData"));
		
		extent.createTest("handle Set, Map and List (with bullet points)")
		.info(MarkupHelper.createUnorderedList("SetData/MapData/ListData")); */
		
		//Highlight text
		extent.createTest("Highlight Text")
		.info("Normal Text")
		.info(MarkupHelper.createLabel("This is text to highlight", ExtentColor.YELLOW));
		
		//Handle Exceptions text
		try {
		int i =5/0;
		} catch (Exception e)
		{
			extent.createTest("Display Exception 1")
				.fail(e);
		}
		//or
		
		Throwable t = new RuntimeException("This is custom exception");
		extent.createTest("Display Exception 2")
			.fail(t)
;		
		extent.flush(); //Use this at the end after recording all the cases
		Desktop.getDesktop().browse(new File("extent-report.html").toURI());
	}

}
