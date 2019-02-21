package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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


}
