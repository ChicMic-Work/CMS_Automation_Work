package cms.pages;


import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class AppiummobileBase {
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;


	@BeforeClass
	public void cmsbase() throws MalformedURLException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File ("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		
	   //  for real device
      options.setPlatformName("iOS");
      options.setDeviceName("iPhone 16");
      options.setPlatformVersion("18.1");
      options.setAutomationName("XCUITest");
      options.setUdid("00008140-000C158A0E13001C");
      options.setWdaLaunchTimeout(Duration.ofSeconds(30));
      options.setCapability("newCommandTimeout", 300);
					
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}	
	
	@AfterClass
    public void tearDown() {
        driver.quit();

//        // Stop the service
        if (service != null) {
            service.stop();
        }
    }
}
