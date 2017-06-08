package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PreferencesPage {

    @FindBy(css = "button.btn.btn-default.navbar-btn")
    private WebElement preff;

    @FindBy(css = "#preferences-win button.close")
    private WebElement closeX;

    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[1]/div/input")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[2]/div/input")
    private WebElement newPassword;
    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[3]/div/input")
    private WebElement repeatNewPassword;
    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[5]/div/button")
    private WebElement save;

    @FindBy(xpath = "//*[@id=\\\"preferences-win\\\"]/form/div/div/div[2]/div[4]")
    private WebElement errorMsg;


    public String getMessage(){
        return "Password does not match the confirm password!";
    }



    public void setValues(String pass, String newPass, String repeatNewPass) {
        this.password.sendKeys(pass);
        this.newPassword.sendKeys(newPass);
        this.repeatNewPassword.sendKeys(repeatNewPass);
        this.save.click();
    }

    public void open() {
        preff.click();
        Utils.sleep(600);
    }

    public void close() {
        closeX.click();
        Utils.sleep(600);
    }
}
