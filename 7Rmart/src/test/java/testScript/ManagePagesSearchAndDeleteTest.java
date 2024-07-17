package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.ListPages;
import pages.LoginPage;

import pages.ManagePageNew;
import pages.ManagePagesSearchAndDelete;
import utilities.ExcelUtility;

public class ManagePagesSearchAndDeleteTest extends Base {
	@Test

	public void verifyTheUserIsAbleToSearchAndDeleteInManagePages() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		boolean ismanagepagesavailable=managepagenew.IsManagePageLoaded();
		
		String search=ExcelUtility.getStringData(0, 1, "ManagePagesSearchAndDeleteData");
		
		ManagePagesSearchAndDelete managepagessearchanddelete=new ManagePagesSearchAndDelete(driver);
		managepagessearchanddelete.clickOnSearchButton();
		
		boolean issearchpageavailable=managepagessearchanddelete.IsSearchWindowLoaded();
		
		managepagessearchanddelete.searchAction(search);
		boolean issearchedresultavailable=managepagessearchanddelete.IsSearchResultLoaded();
		
		managepagessearchanddelete.deleteTheSearchedResultValue();
		
		
		assertTrue(ismanagepagesavailable,"ManagePages window is not loaded");
			assertTrue(issearchpageavailable,"Manage pages search window is not loaded");
		assertTrue(issearchedresultavailable,"Searched result not found");
		
	}
}
