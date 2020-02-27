package com.org.session.SaurabMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	static ExtentReports extent;
	
	@BeforeTest
	public void bt()
	{
		htmlReporter = new ExtentHtmlReporter("ReportSelenium.html");
		//htmlReporter.setAppendExisting(true);
		//htmlReporter.config().setTheme(Theme.DARK);
		//htmlReporter.config().setChartVisibilityOnOpen(true);
		
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

	}
	
	@Parameters("xyz")
	@BeforeMethod
	public void setup(String mycomingbrowserName) {
		
		test = extent.createTest(mycomingbrowserName+": Facebook Automation");
		
		test.info("Autmation started");
		
		if (mycomingbrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(mycomingbrowserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if(mycomingbrowserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
			
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		test.pass("I have opened the browser");
	}
	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();	
		test.info("Closed the browser");
	}
	
	@AfterTest
	public void at()
	{
		test.info("Execution is done");
		extent.flush();
	}
}
