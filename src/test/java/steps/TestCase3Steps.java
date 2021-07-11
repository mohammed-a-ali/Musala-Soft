package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.JobPage;
import pages.JoinUsPage;
import pages.PageBase;
import utilites.FakingData;

public class TestCase3Steps {
    JoinUsPage joinUsPage = new JoinUsPage();
    JobPage jobPage = new JobPage();

    @And("I select {string} from {string} dropdown")
    public void iSelectFrom(String optionName, String dropdown) {
        joinUsPage.clickCheckOpenPositions(dropdown, optionName);
    }

    @And("I choose {string} from open jobs")
    public void iChooseFromOpenJobs(String jobName) {
        joinUsPage.chooseOpenJob(jobName);
    }

    @Then("I should see the {string} in the join-us page")
    public void iShouldSeeTheInTheJoinUsPage(String sectionName) {
        jobPage.verifySectionIsDisplayed(sectionName);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        PageBase pageBase = new PageBase();
        pageBase.clickButtonByValue(buttonName);
    }

    @And("I click on Apply button")
    public void iClickOnButton() {
        jobPage.clickApplyButton();
    }

    @And("I fill the fields using invalid data")
    public void iFillTheFieldsUsingInvalidData() {
        FakingData fakingData = new FakingData();
        jobPage.fillNameTextBox("Name", fakingData.getFullName());
        jobPage.fillEmailTextBox("Email", fakingData.getFullName());
        jobPage.uploadCV();
        jobPage.fillYourMsgTextArea("Your Message", fakingData.getBigText());
    }

    @And("I click on Send button")
    public void iClickOnSendButton() {
        jobPage.clickSendButton();
    }

    @And("I click on Close button")
    public void iClickOnCloseButton() {
        jobPage.clickCloseError();
    }

    @Then("I should see some validation errors")
    public void iShouldSeeSomeValidationErrors() {
        Assert.assertEquals(jobPage.validationError("Email"), "The e-mail address entered is invalid.");
        Assert.assertEquals(jobPage.validationError("Mobile"), "The field is required.");
    }
}
