package org.fasttrackit.util;

import org.fasttrackit.automation.LoginPage;
import org.fasttrackit.automation.LoginView;
import org.fasttrackit.automation.PrefferencesPage;
import org.fasttrackit.automation.PrefferencesView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;
import org.testng.annotations.Test;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    
    public static WebDriver driver;

    public static String USER_NAME = "eu@fast.com";
    public static String PASSWORD= "eu.pass";

    protected LoginView loginPage  = new LoginView();

    static {
        startSuite();
    }


    public void doLogin(String user, String pass){
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        loginPage.login(user, pass);


    }

    private static void startSuite() {
        try {
            driver = WebDriverConfig.getWebDriver(Browser.CHROME);
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }
}
