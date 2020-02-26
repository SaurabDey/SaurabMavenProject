package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtil {
	WebDriver driver;
	public CommonUtil(WebDriver driver2)
	{
		driver=driver2;
	}

	public String screenshotWhenNeeded(String number)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String filepath=System.getProperty("user.dir")+"\\resource\\screenshots\\screenshot"+number+".png";
		
		File destination = new File(filepath);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filepath;
	}
}
