package cms.mobile.resources;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
// import io.appium.java_client.ios.IOSDriver;

public class mobilelement {
	
		
		//Used in morning scan for waiting and displayed button
		public static boolean isElementDisplayed(WebDriver driver, By locator) {
	    try {
	        return driver.findElement(locator).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
		}
	
		// Method to get text from an element
		public static String getElementText(AppiumDriver driver, By elementLocator) {
	    WebElement element = driver.findElement(elementLocator);
	    return element.getText();
		}
	
	
		// Method to perform horizontal swipe
		public static void performHorizontalSwipe(AppiumDriver driver) {
		    // Screen size
		    int screenWidth = driver.manage().window().getSize().width;
		    int screenHeight = driver.manage().window().getSize().height;
		
		    // Define start and end points for the swipe
		    int startX = (int) (screenWidth * 0.9);
		    int endX = (int) (screenWidth * 0.1);
		    int startY = screenHeight / 2;
		
		    // Create the touch actions using PointerInput
		    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		    Sequence swipe = new Sequence(finger, 1);
		
		    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		    swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, startY));
		    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		    driver.perform(Arrays.asList(swipe));
		}
	
	
		// mobile scroll down method
		public static void scrollDownToElement(AppiumDriver driver, String elementText) throws InterruptedException {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put(elementText, elementText);
        driver.executeScript("mobile:scroll", scrollObject);
        Thread.sleep(2000); // You can adjust the sleep duration as needed
    }

		// mobile scroll up method
		public static void scrollupToElement(AppiumDriver driver, String elementText) throws InterruptedException {
	    HashMap<String, Object> scrollObject = new HashMap<>();
	    scrollObject.put("direction", "up");
	    scrollObject.put(elementText, elementText);
	    driver.executeScript("mobile:scroll", scrollObject);
	    Thread.sleep(2000); // You can adjust the sleep duration as needed
	    }
	
	 
		// Generic click method
	    public static void clickElement(AppiumDriver driver, By elementLocator) {
	        WebElement element = driver.findElement(elementLocator);
	        element.click();
	    }
	    
	    // Generic click method for Keypad input
	    public static void clickElementByText(AppiumDriver driver, String text) {
	        By locator = AppiumBy.iOSNsPredicateString("label == \"" + text + "\"");
	        WebElement element = driver.findElement(locator);
	        element.click();
	    }
	    
	    // Method for looping for click mulitple time in fuel plus or anyother place
	    public static void clickElementMultipleTimes(AppiumDriver driver, By locator, int numberOfClicks) {
	        WebElement element = driver.findElement(locator);
	        for (int i = 0; i < numberOfClicks; i++) {
	            element.click();
	        }
	    }
	    
	    // Method for Time selection in mobile
	    public static void setPickerValues(AppiumDriver driver, By timeLocator, By pickerLocator, String[] valuesToSet) throws InterruptedException {
        WebElement timerClick = driver.findElement(timeLocator);
        timerClick.click();

        List<WebElement> values = driver.findElements(pickerLocator);
        for (int i = 0; i < valuesToSet.length; i++) {
            values.get(i).sendKeys(valuesToSet[i]);
            values.get(i).sendKeys(Keys.TAB);
            Thread.sleep(3500); // Adjust the sleep duration as needed
        }
	    }   
	    
	    // Method to send keys to an element
	    public static void sendKeysToElement(AppiumDriver driver, By elementLocator, String text) {
	        WebElement element = driver.findElement(elementLocator);
	        element.sendKeys(text);
	    }
	    public static boolean isElementPresent(AppiumDriver driver, By locator) {
	        try {
	            // Attempt to find the element
	            driver.findElement(locator);
	            return true; // Element found
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false; // Element not found
	        }
	    }

	    
	    
/**this is one function for Case57Advocate_chat where we select future date for ask for call*/
	    /*start function*/
	    // Method to calculate next date
	    private static String[] getNextDateValues() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_MONTH, 1); // Add one day to the current date
	        
	        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.ENGLISH);
	        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
	        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);
	        
	        String day = dayFormat.format(calendar.getTime());
	        String month = monthFormat.format(calendar.getTime());
	        String year = yearFormat.format(calendar.getTime());
	        
	        return new String[]{day, month, year};
	    }

	    // Method for Date selection in mobile
	    public static void setDatePickerValues(AppiumDriver driver, By pickerLocator) throws InterruptedException {
	        String[] nextDateValues = getNextDateValues();
	        
	        // Click to open the picker
	        WebElement datePicker = driver.findElement(pickerLocator);
	        datePicker.click();

	        // Find picker elements
	        List<WebElement> pickers = driver.findElements(pickerLocator);

	        // Iterate through values and set each one
	        for (int i = 0; i < nextDateValues.length; i++) {
	            pickers.get(i).sendKeys(nextDateValues[i]);
	            pickers.get(i).sendKeys(Keys.TAB);
	            Thread.sleep(3500); // Adjust the sleep duration as needed
	        }
	    }
	    
	    /*end this function*/
	
	    
	    
	 
}
	

