package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Client {

    // Please replace Name and ID
    private static String appId = "com.frontm.frontm";
    private static String appActivity = "com.frontm.frontm.MainActivity";
    private static String deviceName = "device";
    private static String deviceId = "emulator-5554";

    public static AndroidDriver driver;

    public static void startAppiumClient() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appId);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 240);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, appId);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, appActivity);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceId);
        driver = new AndroidDriver<>(Server.service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static void stopAppiumClient() {
        if (driver != null) {
            driver.quit();
        }
    }
}
