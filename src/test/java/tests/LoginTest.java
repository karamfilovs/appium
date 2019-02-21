package tests;

import enums.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @Test
    @Tag("smoke")
    @DisplayName("PC-13: Can login and logout")
    public void canLoginSuccessfully() {
        app.loginPage().enterEmail("sanders8411@gmail.com"); //Enters email
        app.loginPage().enterPassword("Safe2019$"); //Enters password
        app.loginPage().clickLoginButton(); // Clicks Login button
        app.homePage().loaded();
        app.homePage().clickHamburgerIcon();
        app.homePage().logout();
    }


    public void canLogoutFromTheAssistant(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openFrontMAssistantChannel(); // Clicks on FrontM Assistant channel
        app.frontMAssistantPage().selectCommand("sure"); // Selects Yes sure
        app.frontMAssistantPage().selectCommand("Logout"); // Selects Logout
    }


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



    public void canNavigateToTestChannelAndReturnBack(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openTestingChannel();
        app.frontMAssistantPage().clickReturnIcon();
    }

    public void canNavigateToFrontMAssistantChannelAndReturnBack(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().openFrontMAssistantChannel();
        app.frontMAssistantPage().clickReturnIcon();
    }

    @Test
    public void canOpenChannelsMenu(){
        app.homePage().loaded(); // Verifies homepage image is visible
        app.homePage().swipe(Direction.LEFT, Duration.ofMillis(1000), 5); // Performs 5 swipes
        app.loginPage().login("karamfilovs@gmail.com", "Safe2019$"); // Performs full login
        app.dashboardPage().clickChannelsIcon();
        app.dashboardPage().returnToHome();
    }
}
