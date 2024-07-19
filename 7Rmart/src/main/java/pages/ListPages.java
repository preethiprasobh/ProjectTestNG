package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementsUtility;

public class ListPages {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	public ListPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headinglistpages;
	@FindBy(xpath="//a[@onclick=\"return confirm('Do you want to delete this Page?')\"]")private WebElement deletebuttoninlistpages;
	
	public boolean isHeaderListPagesVisible()
	{
		boolean is_header_list_pages_available=webelementsutility.isElementDisplayed(headinglistpages);
		return is_header_list_pages_available;
	} 
	public void clickOnDeleteInListPages()
	{
		
		deletebuttoninlistpages.click();
		driver.switchTo().alert().accept();
		
	}
}
