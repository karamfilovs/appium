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
        app.frontMAssistantPage().selectCommand("sure"); // Selects Yes sure
        app.frontMAssistantPage().selectCommand("Logout"); // Selects Logout
    }

    @Test
    public void canSendMessageInTestingChannel(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openFrontMAssistantChannel(); // Clicks on FrontM Assistant channel
        app.frontMAssistantPage().enterMessage("Yes sure");
        app.frontMAssistantPage().clickSendIcon();
        app.frontMAssistantPage().enterMessage("Logout");
        app.frontMAssistantPage().clickSendIcon();
        app.frontMAssistantPage().enterMessage("Yes");
    }


    @Test
    public void canNavigateToTestChannelAndReturnBack(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openTestingChannel();
        app.frontMAssistantPage().clickReturnIcon();
    }

    @Test
    public void canNavigateToFrontMAssistantChannelAndReturnBack(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openFrontMAssistantChannel();
        app.frontMAssistantPage().clickReturnIcon();
        Assert.assertEquals("FrontM Assitant", app.dashboardPage().getFrontMChannelTitle());
    }

    @Test
    public void canOpenChannelsMenu(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().clickChannelsIcon();
        app.dashboardPage().returnToHome();
        Assert.assertEquals("FrontM Assitant", app.dashboardPage().getFrontMChannelTitle());
    }
}
