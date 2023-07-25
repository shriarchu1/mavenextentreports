package tpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {
	WebDriver driver;
	
	ExtentReports extent;
	@BeforeMethod
	public void configuration() {
	String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
	reporter.config().setReportName("omayo yest Report");
	reporter.config().setDocumentTitle("Omayo Test Report title");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Opertaing System", "Window 10");
	extent.setSystemInfo("Tested By", "Archana mate");
	
	
	}
	
	@Test
	public void TestOne (){
		
	  ExtentTest eTest = extent.createTest("Test one Created");
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      eTest.info("Browser launched");
      driver.get("https://omayo.blogspot.com/");
      eTest.info("navigated to Homepage");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      eTest.fail("TestOne Failed");
      Assert.assertEquals(driver.findElement(By.id("pah")).getText(), "PracticeAutomationHere123");
     
      }
   @AfterTest
	public void closure() {
		driver.close();
		extent.flush();
		
	}

}
