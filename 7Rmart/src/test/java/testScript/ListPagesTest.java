package testScript;



import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ListPages;
import pages.LoginPage;
import pages.ManagePageNew;

public class ListPagesTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterAndDeleteListProducts()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		
		
		
		ListPages listpages=new ListPages(driver);
		boolean islistpagesavailable=listpages.IsListPagesLoaded();
		listpages.clickOnDeleteInListPages();
		
		assertTrue(islistpagesavailable,"List Pages is not loaded");

}
}
