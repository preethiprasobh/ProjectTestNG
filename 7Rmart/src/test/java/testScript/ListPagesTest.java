package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.ListPages;
import pages.LoginPage;
import pages.ManagePageNew;
import utilities.ExcelUtility;

public class ListPagesTest extends Base {
	@Test(groups={"sanity","regression"})
	public void verifyTheUserIsAbleToEnterAndDeleteListProducts() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		
		ListPages listpages=new ListPages(driver);
		
		boolean is_header_list_pages_loaded=listpages.isHeaderListPagesVisible();
		listpages.clickOnDeleteInListPages();
		
		Assert.assertTrue(is_header_list_pages_loaded,Messages.HEADER_LIST_PAGES_IS_NOT_LOADED);

}
}
