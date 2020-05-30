package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
	
	WebDriver driver;
	
	By createAccount = By.xpath("//a[@class='btn costco-button tertiary']"); // these are path initialization 
	By email = By.id("register_email1");
	By password = By.id("logonPassword");
	By confirmPassword = By.id("logonPasswordVerify");
	By createAccountButton = By.xpath("//div[@class='form-group']//input[@value='Create Account']");
	By errorText = By.id("email-section-error");
	
	
	
	
	public CreateAccountPage(WebDriver driver)// this constructor of POM calss
	{
		this.driver=driver;
	}
	
	
	public WebElement getCreateAccount() // These are methods for above initialized paths
	{
		return driver.findElement(createAccount);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getConfirmPassword()
	{
		return driver.findElement(confirmPassword);
	}
	public WebElement getCreateAccountButton()
	{
		return driver.findElement(createAccountButton);
	}
	public WebElement getErrorText()
	{
		return driver.findElement(errorText);
	}
    }
