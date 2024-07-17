package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.ListPages;
import pages.LoginPage;
import pages.ManagePageNew;
import utilities.ExcelUtility;

public class ListPagesTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterAndDeleteListProducts() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		
		ListPages listpages=new ListPages(driver);
		
		listpages.clickOnDeleteInListPages();

}
}
