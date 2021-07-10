package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CompanyPage;
import pages.FBPage;
import pages.HomePage;

public class TestCase2Steps {
    @When("I click on {string} link from navbar")
    public void iClickOnLink(String linkText) {
        HomePage homePage = new HomePage();
        homePage.clickOnNavBarLink(linkText);
    }

    @Then("I should see the {string}")
    public void iShouldSeeThe(String sectionName) {
        CompanyPage companyPage = new CompanyPage();
        companyPage.verifyLeadershipSection(sectionName);
    }

    @When("I click on {string} icon")
    public void iClickOnIcon(String icon) {
        CompanyPage companyPage = new CompanyPage();
        companyPage.clickOnFBIcon(icon);
    }

    @Then("I should be directed to Musala FB page")
    public void iShouldBeDirectedToMusalaFBPage() {
        FBPage fbPage = new FBPage();
        fbPage.checkFBURL();
    }

    @And("Musala Soft profile picture should appears on the new page")
    public void musalaSoftProfilePictureShouldAppearsOnTheNewPage() {
        FBPage fbPage = new FBPage();
        fbPage.verifyMusalaPP();
    }
}
