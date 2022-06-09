package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SendSMS {
    AndroidDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps =  new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","11");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("appPackage","com.android.messaging");
        caps.setCapability("appActivity",".ui.conversationlist.ConversationListActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void sendSMS(){

        driver.sendSMS("002-010-123-45678","Hello From My App test");
    }
    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
