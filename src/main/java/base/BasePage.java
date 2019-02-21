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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {
    private final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void swipe(Direction direction, Duration duration) {
        LOGGER.info("Swiping:" + direction);
        Dimension size = Client.driver.manage().window().getSize();

        int startX = size.width / 2;
        int endX = startX;
        int startY = size.height / 2;
        int endY = startY;


        if (direction == Direction.LEFT) {
            startX = (int) (size.width * 0.9);
            endX = (int) (size.width * 0.1);
        } else if (direction == Direction.RIGHT) {
            startX = (int) (size.width * 0.1);
            endX = (int) (size.width * 0.9);
        } else if (direction == Direction.UP) {
            startY = (int) (size.height * 0.9);
            endY = (int) (size.height * 0.1);
        } else {
            startY = (int) (size.height * 0.1);
            endY = (int) (size.height * 0.9);
        }

        new TouchAction(Client.driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }


    public void swipe(Direction direction, Duration duration, int times){
        for (int i = 0; i<times; i++){
            swipe(direction, duration);
        }
    }





}
