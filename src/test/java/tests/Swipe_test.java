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

public class Swipe_test {
    AppiumDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps =  new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","11");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void swipe_test(){
        WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        actions = new AndroidTouchAction((PerformsTouchActions) driver);
        actions.tap(ElementOption.element(views)).perform();


        WebElement gallery= driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]"));
        actions.tap(ElementOption.element(gallery)).perform();

        WebElement photo1= driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]"));
        actions.tap(ElementOption.element(photo1)).perform();


        WebElement pic1= driver.findElements(By.className("android.widget.ImageView")).get(0);
        actions.press(ElementOption.element(pic1)).waitAction().moveTo(PointOption.point(-20,210))
                .release().perform();

    }
    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
