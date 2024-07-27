package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WebElementsUtility;

public class AddNews {
	
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	PageUtility pageutility=new PageUtility();
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
		public boolean isHeaderManageNewsVisible()
		{
			boolean isHeadermanagenewsavailable=webelementsutility.isElementDisplayed(headermanagenews);
			return isHeadermanagenewsavailable;
		}
		
		
		public void clickOnRedNewButton()
		{
			pageutility.javaScriptExecutor(driver, rednewbutton);
			
		}
		public boolean isHeaderEnterNewsInformationVisible()
		{
			boolean isheaderenternewsinformationavailable=webelementsutility.isElementDisplayed(headerenternewsinformation);
			return isheaderenternewsinformationavailable;
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
