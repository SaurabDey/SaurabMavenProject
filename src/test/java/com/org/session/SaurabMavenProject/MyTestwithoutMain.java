package com.org.session.SaurabMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import my.classes.LoginClass;
import my.classes.RegistrationClass;

public class MyTestwithoutMain {
	WebDriver driver;

	@Parameters("xyz")
	@BeforeMethod
	public void setup(String mycomingbrowserName) {
		
		System.out.println(mycomingbrowserName);
		
		if (mycomingbrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
			driver = new ChromeDriver();

		
System.out.println("changes kiran code");

			System.out.println("Sagar here");

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
	}
	@Test
	public void loginMethod() {
		LoginClass log = new LoginClass(driver);
		log.login();
	}
	
	@Test
	public void registrationMethod() {
		RegistrationClass reg = new RegistrationClass(driver);
		reg.registration();
		
	}
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();	
	}
}
