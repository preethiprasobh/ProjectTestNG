package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByValue(WebElement element,String value) {
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
	
	

}
