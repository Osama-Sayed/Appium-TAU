package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Scroll_Android_Test {

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

    private void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction((PerformsTouchActions) driver).press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(0,scrollEnd)).release().perform();
    }
    @Test
    public void scroll_test(){
        WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        actions = new AndroidTouchAction((PerformsTouchActions) driver);
        actions.tap(ElementOption.element(views)).perform();

        //scroll

        scrollDown();

        WebElement lists= driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Lists\"]"));
        actions.tap(ElementOption.element(lists)).perform();
    }
    @AfterTest
    public void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
