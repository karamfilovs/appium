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
        Client.driver.findElement(By.className("android.widget.TextView"));
    }


}
