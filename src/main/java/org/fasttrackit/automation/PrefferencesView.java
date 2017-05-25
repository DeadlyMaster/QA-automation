package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Andrei Pintea on 18.05.2017.
 */
public class PrefferencesView {


    private Button preff = new Button().setElCssSelector("button.btn.btn-default.navbar-btn");
    private Button closeX = new Button().setElCssSelector("#preferences-win button.close");

//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[1]/div/input")
    private TextField password = new TextField().setElPath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[1]/div/input");
//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[2]/div/input")
    private TextField newPassword = new TextField().setElPath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[2]/div/input");;
//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[3]/div/input")
    private TextField repeatNewPassword = new TextField().setElPath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[3]/div/input");;
//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[5]/div/button")
    private Button save = new Button().setElPath("//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[5]/div/button");

//    @FindBy(xpath = "//*[@id=\\\"preferences-win\\\"]/form/div/div/div[2]/div[4]")
    private WebLocator errorMsg = new WebLocator().setElPath("//*[@id=\\\"preferences-win\\\"]/form/div/div/div[2]/div[4]");


    public String getMessage(){
        return "Password does not match the confirm password!";
    }



    public void setValues(String pass, String newPass, String repeatNewPass) {
        this.password.setValue(pass);
        this.newPassword.setValue(newPass);
        this.repeatNewPassword.setValue(repeatNewPass);
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
