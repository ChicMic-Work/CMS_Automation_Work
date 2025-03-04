package cms.allure.reporting;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AllureUtils {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);          
            File destination = new File("screenshots/" + screenshotName + ".png");                     
            FileUtils.copyFile(source, destination);
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(destination));
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    
    
    public static void logStep(String message) {
        Allure.step(message);
    }

    public static void logMessageAndStep(String message, String stepDescription) {
        System.out.println(message);
        Allure.step(stepDescription);
    }
    }


