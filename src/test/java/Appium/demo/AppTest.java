package Appium.demo;

import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	private AppiumDriver<?> driver;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws Exception 
     */
    public AppTest( String testName ) throws Exception
    {
        System.out.println( "testName Hello World!" );
        
        File classpathRoot = new File(System.getProperty("user.dir"));

        File appDir = new File(classpathRoot, "/apps");

        File app = new File(appDir, "ContactManager.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","127.0.0.1:62001");

        capabilities.setCapability("platformVersion", "5.1.1");

        capabilities.setCapability("app", app.getAbsolutePath());

        capabilities.setCapability("appPackage", "com.example.android.contactmanager");

        capabilities.setCapability("appActivity", ".ContactManager");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App is launched!");
        
        WebElement el = driver.findElement(By.name("Add Contact"));

        el.click();

        List<AndroidElement> textFieldsList = (List<AndroidElement>) driver.findElementsByClassName("android.widget.EditText");

        textFieldsList.get(0).sendKeys("Some Name");

        textFieldsList.get(2).sendKeys("Some@example.com");

        //driver.swipe(100, 500, 100, 100, 2);

        driver.findElementByName("Save").click();

        System.out.println("App is done!");
        
        System.out.println( "End testName!" );
        
        driver.quit();
    }

    /**
     * Rigourous Test :-)
     */
    @Test
	public void testApp()
    {
        AssertJUnit.assertTrue( true );
    }
}
