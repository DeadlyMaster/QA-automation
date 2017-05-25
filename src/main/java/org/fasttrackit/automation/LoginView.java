package org.fasttrackit.automation;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginView {


    public TextField userNameElement = new TextField().setName("username").setId("email");
    public TextField passwordElement = new TextField().setId("password");
    public WebLocator loginBtn = new WebLocator().setId("loginButton");



    public void login(String user, String pass) {

        this.userNameElement.setValue(user);
        this.passwordElement.setValue(pass);
        this.loginBtn.click();
    }
}
