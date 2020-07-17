package com.appiumIntro;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AppiumIntro {
    @Test
    public void intro1() {
        File apkFile = new File("src/test/resources/AppiumPractice.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "ChuckNorris");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        URL url;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver(url, desiredCapabilities);

        AndroidElement element = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']"));
        element.click();
        androidDriver.navigate().back();


        List<AndroidElement> allEllements = androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));

        System.out.println(allEllements.size());

        for(AndroidElement ell : allEllements){
            ell.click();
            androidDriver.navigate().back();
        }

    }


}