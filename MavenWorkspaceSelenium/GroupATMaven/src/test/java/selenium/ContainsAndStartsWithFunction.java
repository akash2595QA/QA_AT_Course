package selenium;
import org.openqa.selenium.chrome.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContainsAndStartsWithFunction {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/InteractiveLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%26ogbl%2F&emr=1&ltmpl=default&ltmplcache=2&osid=1&passive=true&rm=false&scc=1&service=mail&ss=1&ifkv=AXo7B7W6zZbxYhccaOPGobOCJKeyNVr_uTmRs8TTQd5q6xnPx36pwWk-rwSoE8LobwwS2GLaZPxO9w&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'account')]")));
		driver.findElement(By.xpath("//span[starts-with(text(), 'Create')]")).click();

	}
}
