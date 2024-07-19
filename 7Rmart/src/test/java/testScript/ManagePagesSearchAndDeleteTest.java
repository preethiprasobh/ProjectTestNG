package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;

import pages.ManagePageNew;
import pages.ManagePagesSearchAndDelete;
import utilities.ExcelUtility;

public class ManagePagesSearchAndDeleteTest extends Base {
	@Test

	public void verifyTheUserIsAbleToSearchAndDeleteInManagePages() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		
		String search=ExcelUtility.getStringData(0, 1,Constants.MANAGE_PAGES_SEARCH_AND_DELETE_DATA);
		
		ManagePagesSearchAndDelete managepagessearchanddelete=new ManagePagesSearchAndDelete(driver);
		managepagessearchanddelete.clickOnSearchButton();
		boolean isRedDeleteButtonLoaded=managepagessearchanddelete.isRedDeleteButtonVisible();
		
		managepagessearchanddelete.searchAction(search);
		boolean isSearchedResultCountLoaded=managepagessearchanddelete.isSearchedResultCountVisible();
		
		managepagessearchanddelete.deleteTheSearchedResultValue();
		
		assertTrue(isRedDeleteButtonLoaded,Messages.RED_DELETE_BUTTON_IS_NOT_LOADED);
		assertTrue(isSearchedResultCountLoaded,Messages.SEARCHED_RESULT_COUNT_IS_NOT_LOADED);
		
			}
}
