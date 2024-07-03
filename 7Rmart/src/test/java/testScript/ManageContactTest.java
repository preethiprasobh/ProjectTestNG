package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAccessAndUpdateContactUs()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageContact managecontact=new ManageContact(driver);
		managecontact.clickOnManageContact();
		boolean iscontactuspageavailable=managecontact.IsContactUsPageLoaded();
		managecontact.clickOnUpdateIcon();
		boolean iscontactusinformationpageavailable=managecontact.IsContactUsInformationPageIsLoaded();
		
		managecontact.updateExistingContactInformation();
		managecontact.clickOnUpdateButton();
		
		assertTrue(iscontactuspageavailable,"Contact Us is not loaded");
		assertTrue(iscontactusinformationpageavailable,"Contact Us is not loaded");
	}

}
