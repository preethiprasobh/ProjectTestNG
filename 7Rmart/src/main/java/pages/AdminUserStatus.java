package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserStatus {
WebDriver driver;
public AdminUserStatus(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement adminuserlink ;
	@FindBy(xpath="//h1[text()='Admin Users']")private WebElement adminheader ;
	@FindBy(xpath="/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[5]/a[1]/i")private WebElement statusicon ;
	@FindBy(xpath="/html/body/div/div[1]/section/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]/a/span")private WebElement statusinstatus ;

public void clickOnAdminUser()
{
	adminuserlink.click();
}

public boolean isAdminUserPageLoaded()
{
	return adminheader.isDisplayed();
}
public void getCurrentUserStatusInStatus()
{
	String statusText = statusinstatus.getText();
	System.out.println("current status of the user:"+statusText);
	
}

public void clickOnStatusIcon()
{
	
	statusicon.click();

}


}
