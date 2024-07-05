package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNews {
	
	WebDriver driver;
	public AddNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[11]/div/a")private WebElement managenews ;
		@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headermanagenews ;
		@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement rednewbutton ;
		@FindBy(xpath="//h3[text()='Enter News Informations']")private WebElement headerenternewsinformation ;
		@FindBy(xpath="//textarea[@id='news']")private WebElement newstextfield ;
		@FindBy(xpath="//button[@type='submit']")private WebElement redsavebutton ;
		
		public void clickOnManageNews()
		{
		managenews.click();	
		}
		
		public boolean ismanagenewswindowloaded()
		{
			return headermanagenews.isDisplayed();
		}
		public void clickOnRedNewButton()
		{
			rednewbutton.click();
		}
		public boolean isEnterNewsInformationPageLoaded()
		{
			return headerenternewsinformation.isDisplayed();
		}
		public void enterNewsInTextField(String news)
		{
			newstextfield.sendKeys(news);
		}
		public void clickOnSaveButton()
		{
			redsavebutton.click();
		}
		
		
		
		

}
