package packageName.packagename;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.DiffHelper.Diff;

import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.comparison.*;

public class CompareScreenshots {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		AShot ashot = new AShot();
		
		//capture screenshot and store in variable
		Screenshot pageScreenshot = ashot.takeScreenshot(driver);
		
		File scImagePath = new File("C:\\Akash\\eclipse-workspace\\NewWorkingPackage\\image_screenshots\\dashboardSC.png");
		BufferedImage actualImage=pageScreenshot.getImage();
		//extract image from screenshot using getImage and store it in file format png
		ImageIO.write(actualImage,"png",scImagePath);
		
		if(scImagePath.exists())
		{
			System.out.println("File created");
			
		}
		else
		{
			System.out.println("File not created");
		}
		
		BufferedImage expectedImage = ImageIO.read(new File("C:\\Akash\\eclipse-workspace\\NewWorkingPackage\\image_screenshots\\expectedImageFiles\\expectedImage1.png"));
		//BufferedImage actualImageTest = ImageIO.read(new File("C:\\Akash\\eclipse-workspace\\NewWorkingPackage\\image_screenshots\\expectedImageFiles\\expectedImage1.png"));
		//To compare we have a class called ImageDiffer
		ImageDiffer imgDiff1 = new ImageDiffer();
		
		//spot the differences in image and store the result in ImageDiff reference
		ImageDiff diff1 =  imgDiff1.makeDiff(expectedImage, actualImage).withDiffSizeTrigger(10);
		diff1.withDiffSizeTrigger(20);
		
		BufferedImage highlightedScreenshot = diff1.getMarkedImage();
		ImageIO.write(highlightedScreenshot, "png", new File("C:\\Akash\\eclipse-workspace\\NewWorkingPackage\\image_screenshots\\diff_spotted.png"));
		//To check if there is any difference
		if(diff1.hasDiff()==true)
		{
			System.out.println("Images are not same");
		}
		else
		{
			System.out.println("Images are same");
		}
		driver.quit();
		
	}

}
