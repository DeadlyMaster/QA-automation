package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;



public class PreferencesView  extends WebLocator{


    private Button preff = new Button().setText("Preferences");

//    private WebLocator win = new WebLocator().setId("preferences-win");

    private WebLocator closeX = new WebLocator(this).setClasses("close");

//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[1]/div/input")
    private TextField password = new TextField(this).setName("password");
//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[2]/div/input")
    private TextField newPassword = new TextField(this).setName("newPassword");
//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[3]/div/input")
    private TextField repeatNewPassword = new TextField(this).setName("newPasswordRepeat");
//    @FindBy(xpath = "//*[@id=\"preferences-win\"]/form/div/div/div[2]/div[5]/div/button")
    private Button save = new Button(this).setText("Save");

//    @FindBy(xpath = "//*[@id=\\\"preferences-win\\\"]/form/div/div/div[2]/div[4]")
    private WebLocator errorMsg = new WebLocator(this).setClasses("status-msg");

    public String getErrorMsg(){
        return errorMsg.getText();
    }


//    public String getMessage(){
//        return "Password does not match the confirm password!";
//    }


    public PreferencesView(){
        setId("preferences-win");
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
