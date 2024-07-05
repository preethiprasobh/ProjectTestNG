package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserInAdminUser {
	WebDriver driver;
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
		
		public void clickOnNewButton()
		{
			rednewbutton.click();
		}
		public boolean isAdminUsersInformationPageLoaded()
		{
			return adminuserpageheader.isDisplayed();
		}
		public void enterAdminUserInformations(String username1,String password1,String usertype)
		{
			usernamefield.sendKeys(username1);
			passwordfield.sendKeys(password1);
			Select select=new Select(dropdownforusertype);
			select.selectByValue(usertype);
		}
		public void clickOnSaveButton()
		{
			redsavebutton.click();
		}
}
