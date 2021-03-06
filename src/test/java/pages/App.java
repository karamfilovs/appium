package pages;

import appium.Client;

public class App {
    private HomePage homePage;
    private LoginPage loginPage;


    //LAZY INSTANTIATING FOR PAGE OBJECTS
    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(Client.driver);
            return loginPage;
        } else {
            return loginPage;
        }
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(Client.driver);
            return homePage;
        } else {
            return homePage;
        }
    }


}
