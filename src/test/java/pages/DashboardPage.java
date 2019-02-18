package pages;

import appium.Client;
import base.BasePage;
import io.appium.java_client.AppiumDriver;

public class DashboardPage extends BasePage {
    public DashboardPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickPragmatic() {
        System.out.println("Clicking pragmatic channel");
        Client.driver.findElementByClassName("android.view.ViewGroup").click();
    }
}
