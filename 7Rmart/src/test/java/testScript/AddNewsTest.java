package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constants.Constants;
import constants.Messages;
import pages.AddNews;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddNewsTest extends Base {
	@Test
	public void verifyTheUserIsAbleToAddNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AddNews addnews=new AddNews(driver);
		addnews.clickOnManageNews();
		boolean is_header_manage_news_loaded=addnews.isHeaderManageNewsVisible();
	
		addnews.clickOnRedNewButton();
		boolean is_header_enter_news_information_loaded=addnews.isHeaderEnterNewsInformationVisible();
		
		String news=ExcelUtility.getStringData(1, 0,Constants.NEWS_DATA);
		addnews.enterNewsInTextField(news);
		addnews.clickOnSaveButton();	
		
		assertTrue(is_header_manage_news_loaded,Messages.HEADER_MANAGE_NEWS_NOT_LOADED);
		assertTrue(is_header_enter_news_information_loaded,Messages.HEADER_ENTER_NEWS_INFORMATION_NOT_LOADED);
		
		
	}

}
