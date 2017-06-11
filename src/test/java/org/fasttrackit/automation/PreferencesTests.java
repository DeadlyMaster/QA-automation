package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class PreferencesTests extends TestBase{

    protected PreferencesView page = new PreferencesView();


    @Test
    public void preferencesWindowShouldCloseTest(){
        LoginTest login = new LoginTest();
        login.doLogin(USER_NAME,PASSWORD);
        page.open();
        page.close();
    }

    @Test
    public void inputChangePassword(String pass, String newPass, String repeatNewPass){
        doLogin(USER_NAME, PASSWORD);
        page.open();
        page.setValues(pass,newPass,repeatNewPass);

    }


    @Test
    public void changePasswordWrong(){
        inputChangePassword("wrongPass","newPass","newPass");

//        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[4]"));
        String message = page.getErrorMsg();
        assertThat(message, is("Your preview password is incorrect!"));

    }



    @Test
    public void changeNewPasswordWrong(){
        inputChangePassword("eu.pass","pass","pass22222");
        assertThat(page.getErrorMsg(), is("Password does not match the confirm password!"));
    }

    @Test
    public void changeNewPasswordSucces(){
        inputChangePassword("eu.pass","pass","pass");

//        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[4]"));
        String message = page.getErrorMsg();
        assertThat(message, is("Your password has been successfully changed."));

        page.close();
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

//        PASSWORD = "new.pass";
//        doLogin(USER_NAME, PASSWORD);
//        logoutBtn = driver.findElement(By.linkText("Logout"));
//        logoutBtn.click();

        PASSWORD = "pass";

        inputChangePassword(PASSWORD, "eu.pass", "eu.pass");
//        errorMsg = driver.findElement(By.xpath("//*[@id='preferences-win']//*[@class='status-msg']"));
        message = page.getErrorMsg();
        assertThat(message, is("Your password has been successfully changed."));
        PASSWORD = "eu.pass";
        page.close();
        logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();


    }

}
