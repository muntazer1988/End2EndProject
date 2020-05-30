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

public class HomePage extends base { // Step 4 of End2End Framework
	public WebDriver driver;
	
	@BeforeTest
	public void initializing() throws IOException 
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String email,String password, String CnfPassword) throws IOException 
	{
		
		LandingPage landing = new LandingPage(driver);
		landing.getSingIn().click();
		
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.getCreateAccount().click();
		ca.getEmail().sendKeys(email);
		ca.getPassword().sendKeys(password);
		ca.getConfirmPassword().sendKeys(CnfPassword);
		ca.getCreateAccountButton().click();
		Assert.assertEquals(ca.getErrorText().getText(), "There was a problem with your information. Please try again.");
	 }
	
	@DataProvider
	public Object[][] getData() // here to parameterize data 
	{
		Object[][] data = new Object[2][3];
		//Send data for test# 1
		data[0][0]="omid.muntazeer@gmail.com";
		data[0][1]="costco12345";
		data[0][2]="costco12345";
		
		//Send data for test# 2
		data[1][0]="imran@gmail.com";
		data[1][1]="abcpapa@1234";
		data[1][2]="abcpapa@1234";
		
		return data;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
