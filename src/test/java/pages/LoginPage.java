package pages;

import appium.Client;
import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public String getLoginScreenText() {
        return Client.driver.findElement(By.className("android.widget.TextView")).getText();
    }

    public void enterEmail(String email) {
        LOGGER.info("Entering email:" + email);
        WebElement element = Client.driver.findElementByXPath("//android.widget.EditText[@text='email@example.com']");
        element.clear();
        element.sendKeys(email);
        Client.driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public void enterPassword(String password) {
        LOGGER.info("Entering password:" + password);
        WebElement element = Client.driver.findElementByXPath("//android.widget.EditText[@text='password']");
        element.clear();
        element.sendKeys(password);
        Client.driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public void clickLoginButton() {
        LOGGER.info("Clicking Log in button");
        Client.driver.findElementByXPath("//android.widget.TextView[@text='Log in']").click();
    }

    public void clickSignUp() {
        System.out.println("Clicking Sign up");
        Client.driver.findElementByXPath("//android.widget.TextView[@text='You don’t have an account? Sign up I']").click();
    }

    public void clickReturnToLogin() {
        LOGGER.info("Clicking Sign up");
        Client.driver.findElementByXPath("//android.widget.TextView[@text='Already have an account?  Log in I']").click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
