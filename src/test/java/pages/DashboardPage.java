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

    public String getFrontMChannelTitle() {
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@text='FrontM Assistant']");
        return element.getText();
    }

    public void logout() {
        LOGGER.info("Clicking Testing channel");
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@text='Logout']");
        element.click();
    }


    public void clickChannelsIcon() {
        LOGGER.info("Clicking on Channels");
        WebElement element = Client.driver.findElementByXPath("//android.view.ViewGroup[@content-desc='channelsMenu']");
        element.click();
    }

    public void returnToHome(){
        LOGGER.info("Clicking on Home");
        WebElement element = Client.driver.findElementByXPath("//android.view.ViewGroup[@content-desc='homeMain']");
        element.click();
    }
}
