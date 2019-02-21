package tests;

import appium.Client;
import appium.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.App;

public class BaseTest {
    protected static App app;

    @BeforeAll
    public static void beforeAll() {
        Server.startAppiumServer();
        Client.startAppiumClient();
        app = new App();

    }

    @BeforeEach
    public void beforeTest() {
    }

    @AfterEach
    public void afterTest() {
    }

    @AfterAll
    public static void afterClass() {
        Client.stopAppiumClient();
        Server.stopAppiumServer();
    }
}
