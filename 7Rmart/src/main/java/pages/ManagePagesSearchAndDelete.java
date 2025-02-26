package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementsUtility;

public class ManagePagesSearchAndDelete {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	
	public ManagePagesSearchAndDelete(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchbutton ;
	
	@FindBy(xpath="//button[text()='Search']")private WebElement redsearchbutton ;
	
	@FindBy(xpath="//input[@placeholder='Title']")private WebElement searchtextbox ;
	
	@FindBy(xpath="//a[@href='http://groceryapp.uniqassosiates.com/admin/pages/index?un=Preethi&Search=sr&page_ad=1']")private WebElement searchedresultcount ;
	
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")private WebElement reddeletebutton ;//at search result page
	
	public void clickOnSearchButton()
	{
		
		searchbutton.click();
		
	}
	public boolean isRedDeleteButtonVisible()
	{
		boolean is_red_delete_button_available=webelementsutility.isElementDisplayed(reddeletebutton);
		return is_red_delete_button_available;
	}
	
	public void searchAction(String search)
	{
		searchtextbox.sendKeys(search);
		redsearchbutton.click();
		
	}
	public boolean isSearchedResultCountVisible()
	{
		boolean is_searched_result_count_available=webelementsutility.isElementDisplayed(searchedresultcount);
		return is_searched_result_count_available;
	}
	
	public void deleteTheSearchedResultValue()
	{
		reddeletebutton.click();
		driver.switchTo().alert().accept();	
	}

}
