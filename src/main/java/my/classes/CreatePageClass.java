package my.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePageClass {
	
	WebDriver driver;
	
	public CreatePageClass(WebDriver driver2) {
		driver= driver2;
	}

	public void createMethod()
	{
		
		
		WebElement create= driver.findElement(By.xpath("//a[text()='Create a Page']"));
		create.click();
		
		WebElement getstr= driver.findElement(By.xpath("//div[text()='Get Started']"));
		getstr.click();
	}

}
