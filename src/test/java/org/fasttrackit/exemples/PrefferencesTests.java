package org.fasttrackit.exemples;

import org.fasttrackit.automation.PrefferencesPage;
import org.fasttrackit.automation.PrefferencesView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Andrei Pintea on 11.05.2017.
 */
public class PrefferencesTests extends TestBase{

    protected PrefferencesView page = new PrefferencesView();


    @Test
    public void preferencesWindowShouldCloseTest(){
        LoginTest login = new LoginTest();
        login.doLogin(USER_NAME,PASSWORD);
        page.open();
        page.close();
    }

    @Test
    public void inputChangePassword(String pass, String newPass, String repeatNewPass){
        doLogin(USER_NAME,PASSWORD);
        page.open();
        page.setValues(pass,newPass,repeatNewPass);
    }

    @Test
    public void changePasswordWrong(){
        inputChangePassword("wrongPass","newPass","newPass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[4]"));
        String message = errorMsg.getText();
        assertThat(message, is("Your preview password is incorrect!"));

    }



    @Test
    public void changeNewPasswordWrong(){
        inputChangePassword("eu.pass","pass","pass22222");
        assertThat(page.getMessage(), is("Password does not match the confirm password!"));
    }

    @Test
    public void changeNewPasswordSucces(){
        inputChangePassword("eu.pass","pass","pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[4]"));
        String message = errorMsg.getText();
        assertThat(message, is("Your password has been successfully changed."));

    }

}
