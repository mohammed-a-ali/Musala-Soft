package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import pages.AboutPage;
import pages.HomePage;
import pages.PageBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestCase1Steps {
    @When("I click on {string} button")
    public void iClickOnButton(String element) {
        PageBase pageBase = new HomePage();
        pageBase.clickButton(element);
    }

    @And("I fill the below textBoxes from excel")
    public void iFillTheBelowTextBoxesFromExcel(DataTable table) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("src\\main\\java\\Data\\testData.xlsx"));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowsCount = sheet.getPhysicalNumberOfRows();

        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        AboutPage aboutPage = new AboutPage();
        for (int i = 1; i < rowsCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell;

                cell = row.getCell(0);
                aboutPage.fillNameTextBox(data.get(0).get("About Data"), cell.getStringCellValue());
                cell = row.getCell(1);
                aboutPage.fillEmailTextBox(data.get(1).get("About Data"), cell.getStringCellValue());
                cell = row.getCell(2);
                aboutPage.fillSubjectTextBox(data.get(2).get("About Data"), cell.getStringCellValue());
                cell = row.getCell(3);
                aboutPage.fillYourMessageTextArea(data.get(3).get("About Data"), cell.getStringCellValue());

                aboutPage.clickSendButton("Send");
                if (i < 5)
                    Assert.assertEquals(aboutPage.checkEmailValidation(), "The e-mail address entered is invalid.");
                else
                    Assert.assertEquals(aboutPage.checkEmailValidation(), "Please verify that you are not a robot.");
            }
        }
    }

    @Given("I am on the {string} page")
    public void iAmOnThePage(String currentPage) {
            PageBase.ValidateCurrentPageURL(currentPage.toLowerCase());
    }
}
