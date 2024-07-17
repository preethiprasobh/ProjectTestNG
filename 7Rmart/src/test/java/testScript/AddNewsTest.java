package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.AddNews;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddNewsTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAddNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AddNews addnews=new AddNews(driver);
		addnews.clickOnManageNews();
	
		addnews.clickOnRedNewButton();
		
		String news=ExcelUtility.getStringData(1, 0, "AddNewsData");
		addnews.enterNewsInTextField(news);
		addnews.clickOnSaveButton();	
		
	}

}
