package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"C:\\Akash\\eclipse-workspace\\CucumberProject\\Features"},
		glue= {"stepdefinations"}
		)

public class HrmTestRunner extends AbstractTestNGCucumberTests {

}
