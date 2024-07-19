package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WebElementsUtility;

public class AddUserInAdminUser {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	PageUtility pageutility=new PageUtility();
	
	public AddUserInAdminUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		@FindBy(xpath="/html/body/div/div[1]/section/div[1]/a[1]")private WebElement rednewbutton ;
		@FindBy(xpath="//h3[text()='Admin Users Informations']")private WebElement adminuserpageheader ;
		@FindBy(xpath="//input[@id='username']")private WebElement usernamefield ;
		@FindBy(xpath="//input[@id='password']")private WebElement passwordfield ;
		@FindBy(xpath="//select[@id='user_type']")private WebElement dropdownforusertype ;
		@FindBy(xpath="//button[@name='Create']")private WebElement redsavebutton ;
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertbox ;
		
		public void clickOnNewButton()
		{
			rednewbutton.click();
			
		}
		public boolean isHeaderAdminUserPageVisible()
		{
			boolean is_header_admin_user_page_available=webelementsutility.isElementDisplayed(adminuserpageheader);
			return is_header_admin_user_page_available;
		}
		
		
		public void enterAdminUserInformations(String username1,String password1,String usertype)
		{
			
			usernamefield.sendKeys(username1);
			passwordfield.sendKeys(password1);
			pageutility.selectByValue(dropdownforusertype, usertype);
			
		}
		public void clickOnSaveButton()
		{
			redsavebutton.click();
			
		}
		public boolean isAlertBoxVisible()
		{
			boolean is_alert_box_available=webelementsutility.isElementDisplayed(alertbox);
			return is_alert_box_available;
		}
		
}
