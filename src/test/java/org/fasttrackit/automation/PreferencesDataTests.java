package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class PreferencesDataTests extends TestBase {

    protected PreferencesView page = new PreferencesView();

    @BeforeClass
    public void startsTests(){
        doLogin(USER_NAME,PASSWORD);
    }
    @AfterClass
    public void endsTests(){
        doLogout();
    }

//    @Test
//    public void preferencesWindowShouldCloseTest(){
//        page.open();
//        page.close();
//    }

    @Test(dataProvider = "passwords")
    public void inputChangePassword(String pass, String newPass, String repeatNewPass, String msg){

        page.open();
        page.setValues(pass,newPass,repeatNewPass);
        String message = page.getErrorMsg();
        assertThat(message, is(msg));
        page.close();
        if (msg == "Your password has been successfully changed." ){
            loginPasswordChanged(newPass);
        }
    }

    @DataProvider
    public Object[][] passwords(){
        return new Object[][]{
                {"wrongPass","newPass","newPass", "Your preview password is incorrect!"},
                {"eu.pass","pass","pass22222", "Password does not match the confirm password!"},
                {"eu.pass","pass","pass", "Your password has been successfully changed."},
                {"pass","eu.pass","eu.pass", "Your password has been successfully changed."}
        };
    }

    public void loginPasswordChanged(String password){
        doLogout();
        doLogin(USER_NAME,password);
    }

}
