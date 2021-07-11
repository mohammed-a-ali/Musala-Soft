package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobPage extends PageBase {

    public void verifySectionIsDisplayed(String sectionName) {
        by = By.xpath("//div[@class='joinus-content']//h2[text()='" + sectionName + "']");
        verifyElementIsDisplayed(sectionName);
    }

    public void clickApplyButton() {
        by = By.xpath("//div[@class='btn-apply-container']/a/input[@type='button']");
        waitForElementPresence(by);
        element = driver.findElement(by);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public void fillNameTextBox(String elementName, String name) {
        by = By.xpath("//input[@name='your-name' and @type='text']");
        setTextToTextBox(elementName, name);
    }

    public void fillEmailTextBox(String elementName, String email) {
        by = By.xpath("//input[@name='your-email' and @type='email']");
        setTextToTextBox(elementName, email);
    }

    public void uploadCV() {
        by = By.xpath("//input[@name='uploadtextfield' and @type='text']");
        setTextToTextBox("CVTextBox", "src\\main\\java\\Data\\CORE_CV_template_2.pdf");
    }

    public void fillYourMsgTextArea(String elementName, String text) {
        by = By.xpath("//textarea[@name='your-message']");
        setTextToTextBox(elementName, text);
    }

    public String validationError(String fieldName) {
        by = By.xpath("//p//*[text()='" + fieldName + "']//..//span[@aria-hidden='true']");
        waitForElementPresence(by);
        element = driver.findElement(by);
        return element.getText();
    }

    public void clickSendButton() {
        by = By.xpath("//input[@type='submit' and @value='Send']");
        waitForElementPresence(by);
        element = driver.findElement(by);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public void clickCloseError() {
        by = By.xpath("//button[@class='close-form']");
        waitForElementPresence(by);
        element = driver.findElement(by);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public void printPositions() {
        by = By.xpath("//article[@class='card-jobsHot' or @class='card-jobsHot card-regular']//h2");
        By by1 = By.xpath("//article[@class='card-jobsHot' or @class='card-jobsHot card-regular']//a");
        By by2 = By.xpath("//select[@id='get_location']");
        waitForElementPresence(by);
        List<WebElement> positions = driver.findElements(by);
        List<WebElement> links = driver.findElements(by1);
        System.out.println(driver.findElement(by2).getAttribute("value"));
        for (int i = 0; i < positions.size(); i++) {
            System.out.println("Position: " + positions.get(i).getText());
            System.out.println("More info: " + links.get(i).getAttribute("href"));
        }
        System.out.println("------------------------------------------------------------");
    }
}

