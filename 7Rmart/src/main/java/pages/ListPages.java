package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPages {
	WebDriver driver;
	public ListPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headinglistpages;
	@FindBy(xpath="//a[@onclick=\"return confirm('Do you want to delete this Page?')\"]")private WebElement deletebuttoninlistpages;

	public boolean IsListPagesLoaded()
	{
		return headinglistpages.isDisplayed();
	}
	
	public void clickOnDeleteInListPages()
	{
		deletebuttoninlistpages.click();
		driver.switchTo().alert().accept();
		
	}
}
