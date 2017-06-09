package org.fasttrackit.automation;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

public class PageObjectView extends WebLocator{

    private Button demoModal = new Button().setText("\n" +
            "        Launch demo modal\n" +
            "    ");


    private TextField email = new TextField(this).setId("email");
    private TextField username = new TextField(this).setId("userName");

    private Button save = new Button(this).setText("Save");
    private WebLocator close = new WebLocator(this).setClasses("btn btn-default").setText("Close");

    public PageObjectView (){
        setClasses("form-horizontal span3 experiment-tile");
    }

    public void setValues(String email, String username){

        this.email.setValue(email);
        this.username.setValue(username);
        this.save.click();
    }

    public void open(){
        demoModal.click();
        Utils.sleep(600);
    }

    public void close(){
        close.click();
        Utils.sleep(600);
    }

}
