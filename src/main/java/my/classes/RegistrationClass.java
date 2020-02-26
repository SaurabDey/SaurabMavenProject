package my.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RegistrationClass {
	WebDriver driver;
	By firstname_locator=By.name("firstname");
	By surname_locator=By.name("lastname");
	By sign_locator=By.xpath("//button[text()='Sign Up wrong']");
	
	public RegistrationClass(WebDriver driver2) {
		driver=driver2;
	}
	public void registration()
	{
		driver.get("https://www.facebook.com/");
		
		//Assert.assertEquals( driver.getCurrentUrl(), "https://www.facebook.com/saurab");
		
		SoftAssert so= new SoftAssert();
		so.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		WebElement firstname = driver.findElement(firstname_locator);
		firstname.sendKeys("saurab");

		WebElement surname = driver.findElement(surname_locator);
		surname.sendKeys("jeet");

		WebElement sigup = driver.findElement(sign_locator);
		sigup.click();
		
		so.assertAll();
	}
}
