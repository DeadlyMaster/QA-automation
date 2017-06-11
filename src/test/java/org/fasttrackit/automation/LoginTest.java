package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class LoginTest extends TestBase {

//    protected LoginView loginView = new LoginView();

    @Test
    public void validLoginTest(){
//        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//
//        driver.findElement(By.name("username")).sendKeys(USER_NAME);
//        driver.findElement(By.id("password")).sendKeys(PASSWORD);
//
//        WebElement passwordElement = driver.findElement(By.id("password"));
//        passwordElement.sendKeys("eu.pass111111");
//        passwordElement.clear();
//        passwordElement.sendKeys("eu.pass");
//
//        WebElement loginBtn = driver.findElement(By.id("loginButton"));
//        loginBtn.click();

        LoginTest login = new LoginTest();
        login.doLogin(USER_NAME,PASSWORD);




        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {

            Assert.fail("Could not login. Logout button not found.");
        }
    }

//    @Test
//    public void invalidLoginTest(){
//        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//
//        driver.findElement(By.name("username")).sendKeys("wrong@username");
//        driver.findElement(By.id("password")).sendKeys("wrong.password");
//        WebElement loginBtn = driver.findElement(By.id("loginButton"));
//        loginBtn.click();
//
//        WebElement errorMsg = driver.findElement(By.className("error-msg"));
//        String message = errorMsg.getText();
//        System.out.println(message);
//
//        assertThat(message, is("Invalid user or password!"));
//    }

    @Test(dataProvider = "invalidUsers")
    public void invalidLoginTest(String user, String pass, String msg){
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        List<WebElement> inputElements = driver.findElements(By.tagName("input"));
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println(message);

        assertThat(message, is(msg));
    }
    @DataProvider
    public Object[][] invalidUsers(){

        return new Object[][]{
                {"wrong@user","wrong.pass","Invalid user or password!"},
                {"empty.pass@user","","Please enter your password!"},
                {"","empty.user","Please enter your email!"}
        };
    }


}
