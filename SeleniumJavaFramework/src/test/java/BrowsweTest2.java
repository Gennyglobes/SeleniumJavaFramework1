import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrowsweTest2 {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;

	@BeforeSuite
	public  void setup() {

		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeTest
	public void SetUptest()
	{

		String projectPth= System.getProperty("user.dir");
		System.out.println("projectPth " + projectPth);
		System.setProperty("webdriver.gecko.driver",projectPth +"/drivers/geckodriver/geckodriver");
		driver = new FirefoxDriver();
	}

	@Test
	public void googleSearch2() throws Exception{

		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://www.google.com");
		test.pass("navigated to google.com");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");




	}

	@AfterTest
	public void teardownTest()
	{
		//driver.close();
		
		if(driver!=null)
		driver.quit();
	}


	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		
	}

}
