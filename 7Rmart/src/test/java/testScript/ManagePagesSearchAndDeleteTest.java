package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ListPages;
import pages.LoginPage;

import pages.ManagePageNew;
import pages.ManagePagesSearchAndDelete;

public class ManagePagesSearchAndDeleteTest extends Base {
	@Test

	public void verifyTheUserIsAbleToSearchAndDeleteInManagePages()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		boolean ismanagepagesavailable=managepagenew.IsManagePageLoaded();
		
		String search="Preethi";
		
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
