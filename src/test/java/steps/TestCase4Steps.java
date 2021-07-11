package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.JobPage;
import pages.JoinUsPage;

import java.util.List;
import java.util.Map;

public class TestCase4Steps {
    @And("I select below locations from {string} dropdown and see opn jobs in console")
    public void iSelectBelowLocationsFromDropdown(String dropdown, DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        JoinUsPage joinUsPage = new JoinUsPage();
        JobPage jobPage = new JobPage();
        for (int i = 0; i<data.size(); i++){
            joinUsPage.clickCheckOpenPositions(dropdown, data.get(i).get("Location"));
            jobPage.printPositions();
        }
    }
}
