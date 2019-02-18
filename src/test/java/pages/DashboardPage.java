package pages;

import appium.Client;
import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends BasePage {
    private final Logger LOGGER = LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(AppiumDriver driver) {
        super(driver);
    }

    public void openTestingChannel() {
        LOGGER.info("Clicking Testing channel");
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@text='Testing channel']");
        element.click();
    }

    public void openFrontMAssistantChannel() {
        LOGGER.info("Clicking FrontM Assistant channel");
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@text='FrontM Assistant']");
        element.click();
    }

    public void logout() {
        LOGGER.info("Clicking Testing channel");
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@text='Logout']");
        element.click();
    }

    public void selectCommand(String command) {
        LOGGER.info("Selecting command:" + command);
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[contains(text(),'" + command + "')]");
        element.click();
    }

    public void returnBackToDashboardPage() {
        LOGGER.info("Clicking Testing channel");
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@text='.']");
        element.click();
    }
}
