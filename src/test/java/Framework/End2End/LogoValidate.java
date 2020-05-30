package Framework.End2End;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.CreateAccountPage;
import pageObjects.LandingPage;

public class LogoValidate extends base { // Step 4 of End2End Framework
	public WebDriver driver;
	
	@BeforeTest
	public void initializing() throws IOException 
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void basePageNavigation() throws IOException 
	{
		LandingPage landing = new LandingPage(driver);
		Assert.assertFalse(landing.geLogoDisplay().isDisplayed());
	 }
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
