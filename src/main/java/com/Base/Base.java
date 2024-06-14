package com.Base;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base {

    protected RemoteWebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Define Sauce Labs credentials
        String sauceUsername = "oauth-kavitha.bharathiraja-16666";
        String sauceAccessKey = "1b0d034-2d08-4d2f-b179-b5e00a72341f";

        // Define Sauce Labs URL
        String sauceUrl = "https://" + sauceUsername + ":" + sauceAccessKey + "@ondemand.saucelabs.com/wd/hub";
      
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:deviceName", "Samsung.*");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "latest");
        sauceOptions.setCapability("username", "oauth-kavitha.bharathiraja-16666");
        sauceOptions.setCapability("accessKey", "e1b0d034-2d08-4d2f-b179-b5e00a72341f");
        sauceOptions.setCapability("build", "<your build id>");
        sauceOptions.setCapability("name", "<your test name>");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("browserName", "Safari");
//        caps.setCapability("appium:deviceName", "iPhone.*");
//        caps.setCapability("appium:automationName", "XCUITest");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("appiumVersion", "latest");
//        sauceOptions.setCapability("username", "oauth-kavitha.bharathiraja-16666");
//        sauceOptions.setCapability("accessKey", "e1b0d034-2d08-4d2f-b179-b5e00a72341f");
//        sauceOptions.setCapability("build", "<31684916>");
//        sauceOptions.setCapability("name", "<GeneralStore>");
//        caps.setCapability("sauce:options", sauceOptions);
//       
        
       // AndroidDriver driver = (AndroidDriver) new RemoteWebDriver(new URL(sauceUrl), caps);
        //URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
//        IOSDriver driver = new IOSDriver(url, caps);
//        // Define capabilities for Sauce Labs
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("username", sauceUsername);
//        caps.setCapability("accessKey", sauceAccessKey);
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "9.0");
//        caps.setCapability("deviceName", "Google Pixel 3");
//        caps.setCapability("app", "sauce-storage:General-Store.apk");

        try {
            // Initialize RemoteWebDriver with Sauce Labs URL and capabilities
            driver = (AndroidDriver) new RemoteWebDriver(new URL(sauceUrl), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}