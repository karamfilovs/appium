package pages;

import appium.Client;

public class App {
    private HomePage homePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private FrontMAssistantPage frontMAssistantPage;


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

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(Client.driver);
            return dashboardPage;
        } else {
            return dashboardPage;
        }
    }

    public FrontMAssistantPage frontMAssistantPage() {
        if (frontMAssistantPage == null) {
            frontMAssistantPage = new FrontMAssistantPage(Client.driver);
            return frontMAssistantPage;
        } else {
            return frontMAssistantPage;
        }
    }
}
