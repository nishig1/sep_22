package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentSparkReporter htmlreport;
	public static ExtentReports report;
	public static ExtentTest test;
	

	@BeforeSuite
	public void initialize() throws Exception
	{
		prop=new Properties();
		prop.load(new FileInputStream("./src/main/java/config/config.properties"));
		
		htmlreport=new ExtentSparkReporter("./Reports/Ebay.html");
		htmlreport.config().setReportName("Ebay Functional Testing");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("ApplicationName","ebay.com");
		report.setSystemInfo("Tester","ram");
		report.setSystemInfo("Environment","TestEnv");
		
	}
	@BeforeTest
	public void setup()
	{		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void verifyTitle(String exp)
	{
		test=report.createTest("ValidateTitle");
		if(driver.getTitle().contains(exp))
		{			
			test.log(Status.PASS,"Title is as expected :"+"Expected  : "+exp+"   Actual  :  "+driver.getTitle());
		}
		else
		{		
			test.log(Status.FAIL,"Title is NOT as expected :"+"Expected  : "+exp+"   Actual  :  "+driver.getTitle());
		}

	}
	@AfterSuite
	public void closeBrowser()
	{
		report.flush();  //to save the report
		driver.quit();
	}
}
