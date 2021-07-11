package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class JoinUsPage extends PageBase {

    public void clickCheckOpenPositions(String dropdownMenu, String option) {
        by = By.xpath("//select[@id='" + dropdownMenu + "']");
        element = driver.findElement(by);
        Select dropdown = new Select(element);
        dropdown.selectByValue(option);
    }

    public void chooseOpenJob(String elementName) {
        if (driver.findElements(By.xpath("(//article[@class='card-jobsHot']//*[contains(text(),'" + elementName + "')])[1]")).size() != 0) {
            by = By.xpath("(//article[@class='card-jobsHot']//*[contains(text(),'" + elementName + "')])[1]");
        } else {
            by = By.xpath("(//article[@class='card-jobsHot']//*[contains(text(),'Developer')])[1]");
        }
        System.out.println("Element '" + elementName + "' is found...");
        System.out.println("Going to choose '" + elementName + "' job...");
        waitForElementPresence(by);
        element = driver.findElement(by);
        element.click();
    }
}
