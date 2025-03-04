package cms.utils;
import io.appium.java_client.AppiumDriver;
import java.util.HashMap;
import java.util.Map;

import cms.mobile.resources.mobileTestData;

public class AppiumappUtils {
    private AppiumDriver driver;

    public AppiumappUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public void launchAppWithPackageId(String packageId) {
        
        Map<String,String> params =new  HashMap<String,String>();
        params.put("bundleId", mobileTestData.bundelID);
		driver.executeScript("mobile:launchApp", params);
    }
}
