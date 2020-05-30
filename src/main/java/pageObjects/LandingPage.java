package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class LandingPage { //Step 4 of End2End Framework
	
	public WebDriver driver;
	
	By signIn = By.id("header_sign_in");
	By coronaTitleText = By.xpath("//div[contains(text(),'Coronavirus Updates')]");
	By logoDisplayed = By.xpath("//div[@class='table-cell logo hidden-xs hidden-sm hidden-md hidden-lg']/a/img");
	
	
	
	
	public LandingPage(WebDriver driver) { // this is constructor of the class
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}


	public WebElement getSingIn()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getCoronaTitle()
	{
		return driver.findElement(coronaTitleText);
	}
	
	public WebElement geLogoDisplay()
	{
		return driver.findElement(logoDisplayed);
	}
	

}
