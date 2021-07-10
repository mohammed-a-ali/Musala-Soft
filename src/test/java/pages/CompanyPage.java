package pages;

import org.openqa.selenium.By;

public class CompanyPage extends PageBase {
    public void verifyLeadershipSection(String elementName){
        by = By.xpath("//section[@class='company-members']//*//h2[text()='Leadership']");
        verifyElementIsDisplayed(elementName);
    }

    public void clickOnFBIcon(String elementName){
        by = By.xpath("//span[@class='musala musala-icon-facebook']");
        clickOnLinkText(elementName);
    }
}
