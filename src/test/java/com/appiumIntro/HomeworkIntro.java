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

public class HomeworkIntro {


    AndroidDriver<AndroidElement> androidDriver;

    @Before
    public void setup() {
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

        androidDriver = new AndroidDriver(url, desiredCapabilities);
    }

    /*
    Make all 3 as separate @Test:
1. Preference -> Default values -> Checkbox preference
2. Preference -> Default values -> Edit text preference -> type "Hello Techtorial" -> OK
3. Preference -> Default values -> List preference -> Click cancel
     */

    @Test
    public void test1() {
        AndroidElement preference = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        preference.click();

        AndroidElement defaultValues = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='4. Default values']"));
        defaultValues.click();
        AndroidElement checkboxPreference = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox preference']"));
        checkboxPreference.click();

    }

    @Test
    public void test2(){
        AndroidElement preference = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        preference.click();

        AndroidElement defaultValues = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='4. Default values']"));
        defaultValues.click();

        AndroidElement editTextPreference = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout" +
                "/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
        editTextPreference.click();

        AndroidElement boxEditTextPreference =androidDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']"));
        boxEditTextPreference.clear();
        boxEditTextPreference.sendKeys("Hello Techtorial");

        AndroidElement buttonOK =androidDriver.findElement(By.xpath("//android.widget.Button\n[@resource-id='android:id/button1']"));
        buttonOK.click();
    }

    @Test
    public void test3(){

        AndroidElement preference = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
        preference.click();

        AndroidElement defaultValues = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='4. Default values']"));
        defaultValues.click();

        AndroidElement listPreference = androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget" +
                ".FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView" +
                "/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView[1]"));
        listPreference.click();

        AndroidElement cancelButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text='CANCEL']"));
        cancelButton.click();
    }

}
