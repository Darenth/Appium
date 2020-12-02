package tests.resources.apps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    static AppiumDriver<MobileElement> driver;

    public static void openCalculator() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();


        caps.setCapability("deviceName", "HUAWEI Mate 20 lite");
        caps.setCapability("udid", "HYFDU19311002353");
        caps.setCapability("platformVersion", "10.0.0");
        caps.setCapability("platformName", "ANDROID");

        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, caps);
    }

    public String sumOnApp(int digit, int digit2) {
        MobileElement one = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        MobileElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        MobileElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        MobileElement four = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        MobileElement five = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        MobileElement six = driver.findElement(By.id("com.android.calculator2:id/digit_6"));
        MobileElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        MobileElement eight = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        MobileElement nine = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
        MobileElement zero = driver.findElement(By.id("com.android.calculator2:id/digit_0"));
        MobileElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        MobileElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/formula"));

        switch (digit) {
            case 1:
                one.click();
                break;
            case 2:
                two.click();
                break;
            case 3:
                three.click();
                break;
            case 4:
                four.click();
                break;
            case 5:
                five.click();
                break;
            case 6:
                six.click();
                break;
            case 7:
                seven.click();
                break;
            case 8:
                eight.click();
                break;
            case 9:
                nine.click();
                break;
            case 0:
                zero.click();
                break;
        }
        plus.click();
        switch (digit2) {
            case 1:
                one.click();
                break;
            case 2:
                two.click();
                break;
            case 3:
                three.click();
                break;
            case 4:
                four.click();
                break;
            case 5:
                five.click();
                break;
            case 6:
                six.click();
                break;
            case 7:
                seven.click();
                break;
            case 8:
                eight.click();
                break;
            case 9:
                nine.click();
                break;
            case 0:
                zero.click();
                break;
        }
        equals.click();
        return result.getText();
    }

    public String sum(int digit, int digit2) {
        return String.valueOf(digit + digit2);
    }

    @BeforeTest
    public void tearDown() throws MalformedURLException {
        openCalculator();//
    }

    @Test
    public void testSumFunction() {
        int digit1 = 3;
        int digit2 = 6;
        Assert.assertEquals(sumOnApp(digit1, digit2), sum(digit1, digit2));

    }

}
