package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContact {
	WebDriver driver;
	public ManageContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[10]/div/a")private WebElement managecontact;
	@FindBy(xpath="//h1[text()='Contact Us']")private WebElement headercontactus;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")private WebElement updateicon;
	@FindBy(xpath="//h3[text()='Contact Us Informations']")private WebElement headercontactusinformations;
	
	@FindBy(xpath="//input[@name='phone']")private WebElement phonenumberfield;
	@FindBy(xpath="//input[@name='email']")private WebElement emailfield;
	@FindBy(xpath="//textarea[@name='address']")private WebElement addressfield;
	@FindBy(xpath="//textarea[@name='del_time']")private WebElement deliverytimefield;
	@FindBy(xpath="//input[@name='del_limit']")private WebElement deliverychargelimitfield;
	
	@FindBy(xpath="//button[@name='Update']")private WebElement updatebutton;
	
	public void clickOnManageContact()
	{
		managecontact.click();
	}
	public boolean IsContactUsPageLoaded()
	{
		return headercontactus.isDisplayed();
	}
	public void clickOnUpdateIcon()
	{
		updateicon.click();
	}
	public boolean IsContactUsInformationPageIsLoaded()
	{
		return headercontactusinformations.isDisplayed();
	}
	public void updateExistingContactInformation()
	{
		phonenumberfield.clear();
		phonenumberfield.sendKeys("7863676ihuh");
		emailfield.clear();
		emailfield.sendKeys("preethi1234@gmail.com");
		addressfield.clear();
		addressfield.sendKeys("Thiruvananthapuram");
		deliverytimefield.clear();
		deliverytimefield.sendKeys("12312423992432");
		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys("345145f@#@#dgfdgf");
		
		
	}
	public void clickOnUpdateButton()
	{
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",updatebutton);
	}
	
	
	

}
