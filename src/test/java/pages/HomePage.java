package pages;

import appium.Client;
import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retrieves text from the ho
     * @return
     */
    public void loaded() {
        WebElement element = Client.driver.findElementByXPath("//android.widget.ImageButton[@content-desc='com.talkonlinepanel.android:string/drawer_open']");
    }

    public void clickHamburgerIcon() {
        System.out.println("Clicking Hamburger icon");
        WebElement element = Client.driver.findElementByXPath("//android.widget.ImageButton[@content-desc='com.talkonlinepanel.android:string/drawer_open']");
        element.click();
    }


    public void logout() {
        System.out.println("Clicking Logout");
        Client.driver.findElementByXPath("//android.widget.CheckedTextView[@text='Logout']").click();
    }



}
