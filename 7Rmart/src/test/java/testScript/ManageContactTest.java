package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.LoginPage;
import pages.ManageContact;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAccessAndUpdateContactUs() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageContact managecontact=new ManageContact(driver);
		managecontact.clickOnManageContact();
		
		managecontact.clickOnUpdateIcon();
		
		
		String phonenumber=ExcelUtility.getIntegerData(1, 0, "ManageContactsData");
		String email=ExcelUtility.getStringData(1, 1, "ManageContactsData");
		String address=ExcelUtility.getStringData(1, 2, "ManageContactsData");
		String deliverytime=ExcelUtility.getIntegerData(1, 3, "ManageContactsData");
		String deliverychargelimit=ExcelUtility.getIntegerData(1, 4, "ManageContactsData");
		
		managecontact.updateExistingContactInformation(phonenumber,email,address,deliverytime,deliverychargelimit);
		managecontact.clickOnUpdateButton();
		
			}

}
