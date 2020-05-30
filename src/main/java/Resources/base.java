package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base { // Step 3 of End2End Framework
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException 
	{
		prop = new Properties(); // this is a class to access the properties of Data.properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\omid_\\eclipse-workspace\\End2End\\src\\main\\java\\Resources\\Data.properties"); // This is the path for Data.properties file
		
		prop.load(fis); // loading files data from Data.properties file
		String browserName = prop.getProperty("browser");
		
		
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\omid_\\Drivers\\ChromeLatest\\chromedriver.exe");
			driver =  new ChromeDriver();
		}
		
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver","");
			driver = new InternetExplorerDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;	
       } 
	   
	   public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	   {
		   TakesScreenshot ts=(TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		   FileUtils.copyFile(source, new File (destinationFile));
		   return destinationFile;
		   
	   }
	   
	       }
