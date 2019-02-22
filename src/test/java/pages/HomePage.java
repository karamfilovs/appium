package pages;

import appium.Client;
import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retrieves text from the ho
     *
     * @return
     */
    public void loaded() {
        WebElement element = Client.driver.findElementByXPath("//android.widget.ImageButton[@content-desc='com.talkonlinepanel.android:string/drawer_open']");
    }

    public void clickHamburgerIcon() {
        LOGGER.info("Clicking Hamburger icon");
        WebElement element = Client.driver.findElementByXPath("//android.widget.ImageButton[@content-desc='com.talkonlinepanel.android:string/drawer_open']");
        element.click();
    }


    public void logout() {
        LOGGER.info("Clicking Logout");
        Client.driver.findElementByXPath("//android.widget.CheckedTextView[@text='Logout']").click();
    }

    public void confirmLogout() {
        LOGGER.info("Confirm Logout");
        Client.driver.findElementByXPath("//android.widget.Button[@text='LOGOUT']").click();
    }


}
