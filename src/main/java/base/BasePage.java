package base;

import appium.Client;
import enums.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {
    private AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void swipe(Direction direction, Duration duration) {
        System.out.println("Swiping");
        Dimension size = Client.driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = size.height / 2;
        int endY = startY;


        if (direction == Direction.LEFT) {
            startX = (int) (size.width * 0.8);
            endX = (int) (size.width * 0.2);
        } else if (direction == Direction.RIGHT) {
            startX = (int) (size.width * 0.2);
            endX = (int) (size.width * 0.8);
        } else if (direction == Direction.UP) {
            startY = (int) (size.height * 0.8);
            endY = (int) (size.height * 0.2);
        } else {
            startY = (int) (size.height * 0.2);
            endY = (int) (size.height * 0.8);
        }

        new TouchAction(Client.driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
