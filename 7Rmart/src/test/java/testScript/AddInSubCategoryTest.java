package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.AddInSubCategory;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddInSubCategoryTest extends Base {
	@Test
	
	public void verifyTheUserIsAbleToAddSubCategory() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AddInSubCategory addinsubcategory=new AddInSubCategory(driver);
		addinsubcategory.clickOnManageCategory();
		
		
		addinsubcategory.clickOnNewInListSubCategory();
		
		String categorydropdownvalue=ExcelUtility.getIntegerData(0, 1, "AddInSubCategoryData");
		String subcategorytextfieldvalue=ExcelUtility.getStringData(1, 1, "AddInSubCategoryData");
		
		addinsubcategory.enterDataInAddSubcategoryWindow(categorydropdownvalue,subcategorytextfieldvalue);
		addinsubcategory.clickOnSaveButton();
		
	}

}
