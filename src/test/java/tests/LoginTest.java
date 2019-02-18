package tests;

import appium.Client;
import enums.Direction;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @Test
    public void canLoginSuccessfully() {
        app.homePage().loaded(); // Verify home page loaded
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Swipe 5 times
        Assert.assertTrue(app.loginPage().getLoginScreenText().contains("Welcome!")); // Verify login text
        app.loginPage().enterEmail("karamfilovs@gmail.com"); //Enters email
        app.loginPage().enterPassword("Safe2019$"); //Enters password
        app.loginPage().clickLoginButton(); // Clicks Login button
    }

    @Test
    public void canLogoutFromTheAssistant(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openFrontMAssistantChannel(); // Clicks on FrontM Assistant channel
        app.dashboardPage().selectCommand("sure"); // Selects Yes sure
        app.dashboardPage().selectCommand("Logout"); // Selects Logout
    }

    @Test
    public void canSendMessageInTestingChannel(){

    }
}
