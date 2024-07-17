package utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

public class WebElementsUtility {
	// Method to check if a WebElement is displayed and assert
    public void assertElementDisplayed(WebElement element) {
      assertTrue(element.isDisplayed(), "Element is not displayed.");
    }

    // Method to check if a WebElement is selected and assert
    public void assertElementSelected(WebElement element) {
        assertTrue(element.isSelected(), "Element is not selected.");
    }

    // Method to check if a WebElement is enabled and assert
    public void assertElementEnabled(WebElement element) {
      assertTrue(element.isEnabled(), "Element is not enabled.");
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if element is not found or not displayed
        }

    }}
