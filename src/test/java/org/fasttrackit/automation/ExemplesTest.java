package org.fasttrackit.automation;


import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;



public class ExemplesTest extends TestBase {

    @Test
    public void selectRow(){
        doLogin(USER_NAME,PASSWORD);

        WebLocator email = new WebLocator().setText("nickwhite@mail.com");
        WebLocator row = new WebLocator().setTag("tr").setChildNodes(email);
        WebLocator firstName = new WebLocator().setText("John");
        WebLocator lastName = new WebLocator().setText("Moore");
        CheckBox select = new CheckBox(row);
        select.click();

        row.setChildNodes(firstName,lastName);
        select.click();
    }

    @Test
    public void selectRowFromTable(){

        doLogin(USER_NAME,PASSWORD);

        Table table = new Table().setClasses("table-striped");
        Row row = table.getRow(2);
        CheckBox select = new CheckBox(row);
        select.click();

        Row row2 = table.getRow("nickwhite@mail.com");
        CheckBox select2 = new CheckBox(row2);
        select2.click();

        Row row3 = table.getRow("bobsmith@", SearchType.STARTS_WITH);
        CheckBox select3 = new CheckBox(row3);
        select3.click();

        Row row4 = table.getRow(new Cell(2,"David"), new Cell(3,"Miller"));
        CheckBox select4 = new CheckBox(row4);
        select4.click();

        Row row5 = table.getRow(new Cell("John"),new Cell("Moore"));
        CheckBox select5 = new CheckBox(row5);
        select5.click();

    }

    @Test
    public void removeRowFromTable(){
        doLogin(USER_NAME,PASSWORD);

        Table table = new Table().setClasses("table-striped");
        Row row = table.getRow(2);

        Button Details = new Button(row);
        Details.click();
        CheckBox select = new CheckBox(row);
        select.click();
        Utils.sleep(300);
        Button remove = new Button(row).setElCssSelector("btn-group btn btn-small");
        remove.click();

//        Cell cell = new Cell(row, 5);
//        Button remove  = new Button(cell).setElCssSelector("btn-group btn btn-small");
//        remove.click();

    }

    @Test
    public void checkIfRowFoundCorrect(){

        doLogin(USER_NAME, PASSWORD);

        Table table = new Table().setClasses("table-striped");

        Row row = table.getRow("bobsmith@",SearchType.STARTS_WITH);
        if (row.getCell(2).getText().equals("Bob") &&
                row.getCell(3).getText().equals("Smith")){
            CheckBox select = new CheckBox(row);
            select.click();
        }
        Utils.sleep(100);
        Button remove = new Button(row).setElCssSelector("btn-group btn btn-small");
        remove.click();

        doLogout();
    }

    @Test
    public void checkIfRowFound(){

        doLogin(USER_NAME,PASSWORD);

        Table table = new Table().setClasses("table-striped");

        Row row = table.getRow("bobsmith@",SearchType.STARTS_WITH);
        Row row2 = table.getRow(2);

        if (!row.equals(row2)){
            Button remove = new Button(row,"Remove");
            remove.click();
        }

        doLogout();

    }


}
