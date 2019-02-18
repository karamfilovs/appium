package tests;

import appium.Client;
import base.MobileTest;
import enums.Direction;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends MobileTest {

    @Test
    public void canNavigateToLoginScreen() {
        // Verify home page loaded
        HomePage home = new HomePage(Client.driver);
        Assert.assertTrue(home.getHomePageText().contains(""));

        // Swipe 6 times
        for (int i = 0; i < 6; i++) {
            home.swipe(Direction.LEFT, Duration.ofMillis(1000));
        }

        // Verify login page
        LoginPage loginPage = new LoginPage(Client.driver);
        Assert.assertTrue(loginPage.getLoginScreenText().contains("Welcome!"));

        // Login
        loginPage.enterEmail("karamfilovs@gmail.com");
        loginPage.enterPassword("Safe2019$");
        loginPage.clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(Client.driver);
        dashboardPage.clickPragmatic();
    }

    public void canRegisterNewAccount(){

    }
}
