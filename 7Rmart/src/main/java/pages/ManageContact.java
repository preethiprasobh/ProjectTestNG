package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WebElementsUtility;

public class ManageContact {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	PageUtility pageutility=new PageUtility();
	
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
	public boolean isHeaderContactUsVisible()
	{
		boolean is_header_contactus_available=webelementsutility.isElementDisplayed(headercontactus);
		return is_header_contactus_available;
	}
	
	public void clickOnUpdateIcon()
	{
		updateicon.click();
		
	}
	public boolean isHeaderContactUsInformationsVisible()
	{
		boolean is_header_contactus_information_available=webelementsutility.isElementDisplayed(headercontactusinformations);
		return is_header_contactus_information_available;
	}
	
	public void updateExistingContactInformation(String phonenumber,String email,String address,String deliverytime,String deliverychargelimit)
	{
		phonenumberfield.clear();
		phonenumberfield.sendKeys(phonenumber);
		emailfield.clear();
		emailfield.sendKeys(email);
		addressfield.clear();
		addressfield.sendKeys(address);
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytime);
		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys(deliverychargelimit);
		
	}
	public void clickOnUpdateButton()
	{
		
		pageutility.javaScriptExecutor(driver, updatebutton);
	}
}
