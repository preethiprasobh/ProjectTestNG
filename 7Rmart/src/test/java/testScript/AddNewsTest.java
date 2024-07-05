package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddNews;
import pages.LoginPage;

public class AddNewsTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAddNews()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AddNews addnews=new AddNews(driver);
		addnews.clickOnManageNews();
		boolean ismanagenewswindowavailable=addnews.ismanagenewswindowloaded();
		
		addnews.clickOnRedNewButton();
		boolean isenterNewsInformationPageavailable=addnews.isEnterNewsInformationPageLoaded();
		String news="hello,welcome everyone.Have a great day";
		addnews.enterNewsInTextField(news);
		addnews.clickOnSaveButton();
		
		
		assertTrue(ismanagenewswindowavailable,"Manage News Window is not Loaded");
		assertTrue(isenterNewsInformationPageavailable,"Enter News Information Pages is not Loaded");
	}

}
