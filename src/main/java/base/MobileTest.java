package base;

import appium.Client;
import appium.Server;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class MobileTest {

    @BeforeClass
    public static void beforeClass() {
        Server.startAppiumServer();
        Client.startAppiumClient();
    }

    @BeforeTest
    public void beforeTest() {
    }

    @AfterTest
    public void afterTest() {
    }

    @AfterClass
    public static void afterClass() {
        Client.stopAppiumClient();
        Server.stopAppiumServer();
    }
}
