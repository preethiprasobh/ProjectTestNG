package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.ManageContact;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test(groups={"smoke","regression"})
	public void verifyTheUserIsAbleToAccessAndUpdateContactUs() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageContact managecontact=new ManageContact(driver);
		managecontact.clickOnManageContact();
		boolean is_header_contactus_loaded=managecontact.isHeaderContactUsVisible();
		
		managecontact.clickOnUpdateIcon();
		boolean is_header_contactus_informations_loaded=managecontact.isHeaderContactUsInformationsVisible();
		
		
		String phonenumber=ExcelUtility.getIntegerData(1, 0,Constants.MANAGE_CONTACTS_DATA);
		String email=ExcelUtility.getStringData(1, 1,Constants.MANAGE_CONTACTS_DATA);
		String address=ExcelUtility.getStringData(1, 2,Constants.MANAGE_CONTACTS_DATA);
		String deliverytime=ExcelUtility.getIntegerData(1, 3,Constants.MANAGE_CONTACTS_DATA);
		String deliverychargelimit=ExcelUtility.getIntegerData(1, 4,Constants.MANAGE_CONTACTS_DATA);
		
		managecontact.updateExistingContactInformation(phonenumber,email,address,deliverytime,deliverychargelimit);
		managecontact.clickOnUpdateButton();
		
		assertTrue(is_header_contactus_loaded,Messages.HEADER_CONTACTUS_IS_NOT_LOADED);
		assertTrue(is_header_contactus_informations_loaded,Messages.HEADER_CONTACTUS_INFORMATION_IS_NOT_LOADED);
			}

}
