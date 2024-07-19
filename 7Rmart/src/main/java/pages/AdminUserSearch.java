package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WebElementsUtility;

public class AdminUserSearch {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	PageUtility pageutility=new PageUtility();
	public AdminUserSearch(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement bluesearchbutton ;
		@FindBy(xpath="//h4[text()='Search Admin Users']")private WebElement headersearchadminusers ;
		@FindBy(xpath="//input[@id='un']")private WebElement username2 ;
		@FindBy(xpath="//select[@id='ut']")private WebElement dropdownusertype2 ;
		@FindBy(xpath="//button[@value='sr']")private WebElement redsearchbutton ;
		public void clickOnBlueSearchButton()
		{
			bluesearchbutton.click();
			
		}
		public boolean isHeaderSearchAdminUserVisible()
		{
			boolean is_header_search_admin_user_available=webelementsutility.isElementDisplayed(headersearchadminusers);
			return is_header_search_admin_user_available;
		}
		
		
		public void enterSearchDetails(String username,String usertype)
		{
			username2.sendKeys(username);
			pageutility.selectByValue(dropdownusertype2, usertype);
		}
		public void clickOnRedSearchButton()
		{
			redsearchbutton.click();
		}
		
}
