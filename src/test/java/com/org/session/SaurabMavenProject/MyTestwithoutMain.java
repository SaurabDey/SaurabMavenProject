package com.org.session.SaurabMavenProject;

import java.io.IOException;
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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utility.CommonUtil;

import my.classes.LoginClass;
import my.classes.RegistrationClass;

public class MyTestwithoutMain extends BaseClass{

	@Test
	public void loginMethod(){
		
		try {
			LoginClass log = new LoginClass(driver);
			log.login();
			test.pass("Login successfully!!");
		} catch (Exception e) {
			CommonUtil common= new  CommonUtil(driver);
			MediaEntityModelProvider mediaModel = null;
			try {
				mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(common.screenshotWhenNeeded("Login Error")).build();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			test.fail("Login error ", mediaModel);
		}
		
	}
	
	@Test
	public void registrationMethod() {
		try {
			RegistrationClass reg = new RegistrationClass(driver);
			reg.registration();
			test.pass("Registration successfully!!");
		} catch (Exception e) {
			CommonUtil common= new  CommonUtil(driver);
			MediaEntityModelProvider mediaModel = null;
			try {
				mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(common.screenshotWhenNeeded("Registration Error")).build();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			test.fail("Registration error ", mediaModel);
		}
		
		
	}
	
}
