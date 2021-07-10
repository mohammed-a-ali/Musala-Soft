package steps;

import io.cucumber.java.en.And;
import pages.JoinUsPage;

public class TestCase3Steps {
    @And("I select {string} from {string} dropdown")
    public void iSelectFrom(String optionName, String dropdown) {
        JoinUsPage joinUsPage = new JoinUsPage();
        joinUsPage.clickCheckOpenPositions(dropdown, optionName);
    }
}
