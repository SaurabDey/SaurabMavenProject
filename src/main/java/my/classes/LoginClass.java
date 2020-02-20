package my.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class LoginClass {
	WebDriver driver;
	
	By user_locator=By.id("email");
	By pass_locator=By.id("pass");
	By login_locator=By.id("loginbutton");
	
	public LoginClass(WebDriver driver2) {
		driver=driver2;
	}

	public void login()
	{
		driver.get("https://www.facebook.com/");
		
		Assert.assertEquals("Facebook – log in or sign up", driver.getTitle());
		
		WebElement username = driver.findElement(user_locator);
		username.sendKeys("saurab@gmail.com");

		WebElement pass = driver.findElement(pass_locator);
		pass.sendKeys("saurab@gmail.com");

		WebElement login = driver.findElement(login_locator);
		login.click();
	}
}
