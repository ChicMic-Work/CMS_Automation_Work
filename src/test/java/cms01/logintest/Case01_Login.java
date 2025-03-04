package cms01.logintest;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cms.allure.reporting.AllureUtils;
import cms.mobile.resources.mobileTestData;
import cms.pages.AppiummobileBase;
import cms.utils.AppiumappUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import cms.mobile.resources.mobileLocators;

@Epic("Login detail Screen")
@Feature("Verify functionality for Login screen")
public class Case01_Login extends AppiummobileBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(Case01_Login.class);

    @BeforeClass
    public void setUp() {
    }

    @Test
    @Owner("QA")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login functionality with OTP verification")
    @Story("Click on mobile field and input values and then redirect to OTP screen & click on login button")
    public void login() throws InterruptedException {
        // Create an instance of AppiumUtils and pass the driver
        AppiumappUtils appiumUtils = new AppiumappUtils(driver);
        appiumUtils.launchAppWithPackageId(mobileTestData.bundelID);

        // Check if user is already logged in
        try {
            WebElement homeScreenElement = driver.findElement(mobileLocators.homeScreenElement);
            if (homeScreenElement.isDisplayed()) {
                // Log message to console and Allure report
                LOGGER.info("Member already logged in the app.");
                AllureUtils.logStep("Member already logged in the app.");
                return; // Skip the rest of the login steps
            }
        } catch (NoSuchElementException e) {
            LOGGER.info("User is not logged in, proceeding with login steps.");
            AllureUtils.logStep("User is not logged in, proceeding with login steps.");
        }

        // Proceed with the login steps if the user is not already logged in
        WebElement allowClick = null;
        try {
            allowClick = driver.findElement(mobileLocators.allowClick);
            if (allowClick.isDisplayed()) {
                allowClick.click();
                // Log message to console and Allure report
                LOGGER.info("Click on allow notification alert for permission");
                AllureUtils.logStep("Click on allow notification");
            } else {
                LOGGER.info("OK allow element is not displayed.");
                AllureUtils.logStep("OK allow element is not displayed.");
            }
        } catch (NoSuchElementException e) {
            LOGGER.info("Crossclick element not found.");
            AllureUtils.logStep("Crossclick element not found.");
        }

        try {
            WebElement countryValues = driver.findElement(mobileLocators.countryValues);
            countryValues.click();
            LOGGER.info("Click on country values icon");
            AllureUtils.logStep("Click on country values icon");

            WebElement countryName = driver.findElement(mobileLocators.countryName);
            countryName.sendKeys("India");
            LOGGER.info("Enter India values in field");
            AllureUtils.logStep("Input India values in field");

            WebElement indiaSelection = driver.findElement(mobileLocators.indiaSelection);
            indiaSelection.click();
            LOGGER.info("Select India values from list");
            AllureUtils.logStep("Select India values from list");

            AllureUtils.captureScreenshot(driver, "Country selection");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
            WebElement mobileField = wait.until(ExpectedConditions.elementToBeClickable(mobileLocators.mobileField));
            mobileField.click();
            LOGGER.info("Click on phone number field");
            AllureUtils.logStep("Click on phone number field");

            driver.findElement(mobileLocators.signInTextInput).sendKeys(mobileTestData.phoneNumber);

            LOGGER.info("Member phone number input in app");
            AllureUtils.logStep("Phone number input in phone number field");

            AllureUtils.captureScreenshot(driver, "Mobile number input before login tap");

            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(mobileLocators.loginButton);
            loginButton.click();
            LOGGER.info("Click on Login button");
            AllureUtils.logStep("Click on Login button");

            WebElement otp1 = driver.findElement(mobileLocators.otp1);
            otp1.sendKeys(mobileTestData.otp1);
            WebElement otp2 = driver.findElement(mobileLocators.otp2);
            otp2.sendKeys(mobileTestData.otp2);
            WebElement otp3 = driver.findElement(mobileLocators.otp3);
            otp3.sendKeys(mobileTestData.otp3);
            WebElement otp4 = driver.findElement(mobileLocators.otp4);
            otp4.sendKeys(mobileTestData.otp4);
            WebElement otp5 = driver.findElement(mobileLocators.otp5);
            otp5.sendKeys(mobileTestData.otp5);
            WebElement otp6 = driver.findElement(mobileLocators.otp6);
            otp6.sendKeys(mobileTestData.otp6);

            LOGGER.info("Input OTP values in field");
            AllureUtils.logStep("OTP values inserted in field");

            WebElement submitButton = driver.findElement(mobileLocators.submitButton);
            submitButton.click();
            LOGGER.info("Click on submit button");
            AllureUtils.logStep("Click on submit button");

            WebElement notificationClick1 = null;
            try {
                notificationClick1 = driver.findElement(mobileLocators.notificationClick1);
                if (notificationClick1.isDisplayed()) {
                    notificationClick1.click();
                    LOGGER.info("Click on notification button");
                    AllureUtils.logStep("Click on notification button");
                } else {
                    LOGGER.info("Notification element is not displayed.");
                    AllureUtils.logStep("Notification element is not displayed.");
                }
            } catch (NoSuchElementException e) {
                LOGGER.info("Crossclick element not found.");
                AllureUtils.logStep("Crossclick element not found.");
            }

            AllureUtils.captureScreenshot(driver, "Landed on home screen");

            Thread.sleep(3500);
            driver.terminateApp(mobileTestData.bundelID);
        } catch (NoSuchElementException e) {
            LOGGER.error("An element could not be located on the page using the given search parameters.", e);
            AllureUtils.logStep("An element could not be located on the page using the given search parameters: " + e.getMessage());
            // Optionally, take a screenshot on failure
            AllureUtils.captureScreenshot(driver, "Error_Screenshot");
        }
    }
}
