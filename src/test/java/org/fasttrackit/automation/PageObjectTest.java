package org.fasttrackit.automation;


import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

public class PageObjectTest extends TestBase{

    protected PageObjectView page = new PageObjectView();

    @Test
    public void pageWindowShouldCloseTest(){
        doLogin(USER_NAME,PASSWORD);
        page.open();
        page.close();
    }

    public void inputPageObject(String email, String username){
        doLogin(USER_NAME,PASSWORD);
        page.open();
        page.setValues(email,username);
    }

    @Test
    public void inputPageTest(){
        inputPageObject("vlad@gmail.com","Vlad Pintea");
        page.close();
        doLogout();
    }

}
