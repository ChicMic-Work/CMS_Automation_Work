package cms.mobile.resources;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class mobileLocators {
	
	public static final By homeScreenElement = AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"Home\"`][2]");
	public static final By allowClick = AppiumBy.accessibilityId("Allow");
	public static final By countryValues = AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"🇮🇳\"])[2]");
	public static final By countryName = AppiumBy.accessibilityId("text-input-country-filter");
	public static final By indiaSelection = AppiumBy.accessibilityId("country-selector-IN");
	public static final By mobileField = AppiumBy.iOSNsPredicateString("name == \"SignInTextInput\"");
	public static final By signInTextInput = AppiumBy.accessibilityId("SignInTextInput");
	public static final By loginButton = AppiumBy.accessibilityId("LoginButton");
	public static final By otp1 = AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"OTPTextInput\"])[1]");
	public static final By otp2 = AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"OTPTextInput\"])[2]");
	public static final By otp3 = AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"OTPTextInput\"])[3]");
	public static final By otp4 = AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"OTPTextInput\"])[4]");
	public static final By otp5 = AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"OTPTextInput\"])[5]");
	public static final By otp6 = AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"OTPTextInput\"])[6]");
	public static final By submitButton = AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"Submit\"])[3]");
	public static final By notificationClick1 = AppiumBy.accessibilityId("Allow");
	
}
