package org.fasttrackit.exemples;

import com.sdl.selenium.web.utils.Utils;
import com.sun.deploy.security.DeployURLClassPathCallback;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Andrei Pintea on 04.05.2017.
 */
public class LoginTest extends TestBase {

    @Test
    public void validLoginTest(){
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        driver.findElement(By.name("username")).sendKeys("eu@fast.com");
        driver.findElement(By.id("password")).sendKeys("eu.pass");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("eu.pass111111");
        passwordElement.clear();
        passwordElement.sendKeys("eu.pass");

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();


        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {

            Assert.fail("Could not login. Logout button not found.");
        }
    }

    @Test
    public void invalidLoginTest(){
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
//        try {
//            driver.findElement(By.name("username")).sendKeys("wrong@username");
//            driver.findElement(By.id("password")).sendKeys("wrong.password");
//            WebElement loginBtn = driver.findElement(By.id("loginButton"));
//            loginBtn.click();
//        } catch (NoSuchElementException e){
//            Assert.fail("Invalid username or password");
//        }

        driver.findElement(By.name("username")).sendKeys("wrong@username");
        driver.findElement(By.id("password")).sendKeys("wrong.password");
        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println(message);

        assertThat(message, is("Invalid user or password!"));
    }









}
