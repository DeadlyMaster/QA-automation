package org.fasttrackit.functional;


import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TableIntegrationTest extends TestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableIntegrationTest.class);

    private Form form = new Form(null,"Form Table");
    private Table table = new Table(form);

    @BeforeClass
    public void startsTests(){
        doLogin(USER_NAME,PASSWORD);
    }

    @AfterClass
    public void endsTests(){
        doLogout();
    }

    @Test
    public void VerifyIfCheckBoxIsPresent(){
        Cell cell = table.getCell(1,new Cell(2,"John", SearchType.EQUALS),
                new Cell(3,"Carter",SearchType.EQUALS));
        assertTrue(new CheckBox(cell).isElementPresent());
    }

    @Test
    public void verifyIfCellByTextIsPresent(){
        Row row = table.getRow(new Cell("Carter", SearchType.EQUALS));
        assertTrue(row.isElementPresent());
    }

    @Test
    public void verifyIfButtonsIsPresent(){
        Row row = table.getRow(1,new Cell(2,"John", SearchType.EQUALS),
                new Cell(3,"Carter",SearchType.EQUALS));
        Button first = new Button(row).setText("Details", SearchType.CONTAINS);
        Button second = new Button(row,"Remove");
        assertTrue(first.isElementPresent());
        assertTrue(second.isElementPresent());
    }

    @Test
    public void verifyHeaderName(){
        Cell row = new Cell(1,"Row",SearchType.EQUALS).setTag("th");
        Cell firstName = new Cell(2,"First Name",SearchType.EQUALS).setTag("th");
        Cell lastName = new Cell(3,"Last Name",SearchType.EQUALS).setTag("th");
        Cell email = new Cell(4,"Email",SearchType.EQUALS).setTag("th");
        Cell buttons = new Cell(5,"Actions",SearchType.EQUALS).setTag("th");
        assertTrue(table.getRow(row,firstName,lastName,email,buttons).ready());
    }

    @Test(dataProvider = "validUsers")
    public void getAllTextFromRow(String nr, String firstName, String lastName, String email, String buttons){
        List<String> listOfInfo = Arrays.asList(nr, firstName, lastName, email, buttons);

        Row row = table.getRow(new Cell(2,firstName,SearchType.EQUALS),
                new Cell(3,lastName,SearchType.EQUALS));
        List<String> cellsText = row.getCellsText();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n| ");
        for (String el : cellsText){
            stringBuffer.append(el).append(" | ");
        }
        LOGGER.info("test {}",stringBuffer);
        assertEquals(cellsText,listOfInfo);
    }

    @DataProvider
    public Object[][] validUsers(){

        return new Object[][]{
                {"", "John", "Carter", "johncarter@mail.com", "Details Remove"},
                {"", "Peter", "Parker", "peterparker@mail.com", "Details Remove"},
                {"", "John", "Moore", "johnmoore@mail.com", "Details Remove"},
                {"", "David", "Miller", "davidmiller@mail.com", "Details Remove"},
                {"", "Nick", "White", "nickwhite@mail.com", "Details Remove"},
                {"", "Bob", "Smith", "bobsmith@mail.com", "Details Remove"}
        };
    }

    @Test
    public void getAllTexts(){
        List<List<String>> listOfList = new ArrayList<>();

        listOfList.add(Arrays.asList("", "John", "Carter", "johncarter@mail.com", "Details Remove"));
        listOfList.add(Arrays.asList("", "Peter", "Parker", "peterparker@mail.com", "Details Remove"));
        listOfList.add(Arrays.asList("", "John", "Moore", "johnmoore@mail.com", "Details Remove"));
        listOfList.add(Arrays.asList("", "David", "Miller", "davidmiller@mail.com", "Details Remove"));
        listOfList.add(Arrays.asList("", "Nick", "White", "nickwhite@mail.com", "Details Remove"));
        listOfList.add(Arrays.asList("", "Bob", "Smith", "bobsmith@mail.com", "Details Remove"));

        List<List<String>> cellsText = table.getCellsText();
        StringBuffer stringBuffer = new StringBuffer();
        for (List<String> listEl : cellsText){
            stringBuffer.append("\n | ");
            for (String el : listEl){
                stringBuffer.append(el).append(" | ");
            }
        }
        LOGGER.info("test {}",stringBuffer);
        assertEquals(cellsText, listOfList);
    }




}
