package org.fasttrackit.automation;


import org.fasttrackit.onlinelibrary.view.LoginView;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "username")
    public WebElement userNameElement;
    @FindBy(id = "password")
    public WebElement passwordElement;
    @FindBy(id = "loginButton")
    public WebElement loginBtn;



    public void login(String user, String pass) {

        this.userNameElement.sendKeys(user);
        this.passwordElement.sendKeys(pass);
        this.loginBtn.click();
    }
}
