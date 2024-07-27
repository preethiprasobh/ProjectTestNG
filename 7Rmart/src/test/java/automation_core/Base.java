package automation_core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream file;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		prop=new Properties();
		file=new FileInputStream(Constants.CONFIGFILE);
		prop.load(file);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			{
			throw new Exception("Browser is not correct");
			}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	
				}
	@AfterMethod
	
public void driverQuitandClose(ITestResult result) throws IOException  //only need failed testcases screenshots 
{
		if(result.getStatus()==ITestResult.FAILURE)//getStatus date type is integer here
		{
			takesScreenshots(result);
		}
	driver.quit();

}
	public void takesScreenshots(ITestResult result) throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot) driver;
		File screenshots=takescreenshot.getScreenshotAs(OutputType.FILE);//its in file type need to convert to image type
		FileUtils.copyFile(screenshots, new File("./Screenshots/"+result.getName()+".png") );       //"./Screenshots/"creates a folder with this name
	}
}


