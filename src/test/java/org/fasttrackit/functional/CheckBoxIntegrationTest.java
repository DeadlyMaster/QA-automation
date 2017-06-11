package org.fasttrackit.functional;


import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.web.SearchType;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckBoxIntegrationTest  extends TestBase{

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckBoxIntegrationTest.class);

    private Form form = new Form(null, "Form Title");
    private CheckBox checkBox = new CheckBox(form);
    private CheckBox withEnterWebLocator = new CheckBox(form).setLabel("Label with Enter.", SearchType.CHILD_NODE).setLabelPosition("//");

    @BeforeClass
    public void startTests() {
//        driver.get(InputData.BOOTSTRAP_URL);
        doLogin(USER_NAME,PASSWORD);
    }

    @Test
    public void check() {
        assertTrue(checkBox.click());
        assertTrue(checkBox.isSelected());
    }

    @Test
    public void clickWith() {
        assertTrue(withEnterWebLocator.click());
    }

}
