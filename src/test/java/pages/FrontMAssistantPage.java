package pages;

import appium.Client;
import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontMAssistantPage extends BasePage {
    private final Logger LOGGER = LoggerFactory.getLogger(DashboardPage.class);

    public FrontMAssistantPage(AppiumDriver driver) {
        super(driver);
    }

    public void selectCommand(String command) {
        LOGGER.info("Selecting command:" + command);
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[contains(text(),'" + command + "')]");
        element.click();
    }

    public void clickSendIcon() {
        LOGGER.info("Sending current message");
        WebElement element = Client.driver.findElementByXPath("//android.widget.TextView[@content-desc='Right Button Send']");
        element.click();
    }


    public void enterMessage(String message) {
        LOGGER.info("Entering message:" + message);
        WebElement element = Client.driver.findElementByXPath("//android.widget.EditText[@text='Type something nice']");
        element.sendKeys(message);
    }

    public void clickReturnIcon() {
        LOGGER.info("Clicking back icon");
        WebElement element = Client.driver.findElementByXPath("//android.view.ViewGroup[@content-desc='Header Left Icon']");
        element.click();
    }
}
