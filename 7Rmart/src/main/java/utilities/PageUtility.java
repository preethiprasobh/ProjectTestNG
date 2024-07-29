package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByValue(WebElement element,String value) 
	{
		Select select =new Select(element);
		select.selectByValue(value);		
			
	}
	public void actionClick(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element);
		
	}
	public void actionDoubleClick(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	public void javaScriptExecutor(WebDriver driver,WebElement element)
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();",element);

	}
	public void hoverOverElement(WebDriver driver, WebElement element) 
	{
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) 
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void acceptAlert(WebDriver driver) 
	{
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	public void dismissAlert(WebDriver driver) 
	{
	    Alert alert = driver.switchTo().alert();
	    alert.dismiss();
	}
	
}
