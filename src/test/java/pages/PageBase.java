package pages;

import Browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import utilites.LoadProperties;

import java.time.Duration;

public class PageBase extends Driver {

    protected By by;
    protected WebElement element;

    protected void scrollToElement() {
        waitForElementPresence(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    protected void waitForElementPresence(By by) {
        FluentWait<WebDriver> wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .withMessage("Time out, the element did't appear...")
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickButtonByText(String elementName) {
        by = By.xpath("//*[contains(text(),'" + elementName + "')]");
        System.out.println("Element '" + elementName + "' is found...");
        System.out.println("Going to click '" + elementName + "' button...");
        element = driver.findElement(by);
        scrollToElement();
        element.click();
    }

    public void clickButtonByValue(String elementName) {
        by = By.xpath("//input[@type='submit' or @type='button' and @value='" + elementName + "']");
        System.out.println("Element '" + elementName + "' is found...");
        System.out.println("Going to click '" + elementName + "' button...");
        waitForElementPresence(by);
        element = driver.findElement(by);
        element.click();
    }

    protected void setTextToTextBox(String elementName, String text) {
        System.out.println("Element '" + elementName + "' is found...");
        System.out.println("Going to send '" + text + "' to '" + elementName + "' textBox...");
        element = driver.findElement(by);
        scrollToElement();
        element.clear();
        element.sendKeys(text);
    }

    protected void clickOnLinkText(String elementName){
        System.out.println("Element '" + elementName + "' is found...");
        System.out.println("Going to click '" + elementName + "' link...");
        element = driver.findElement(by);
        scrollToElement();
        element.click();
    }

    protected void verifyElementIsDisplayed(String elementName){
        System.out.println("Searching for " +elementName + "...");
        waitForElementPresence(by);
        element = driver.findElement(by);
        if(element.isDisplayed())
            System.out.println("The " + elementName+ " is present in the page");
        else
            System.out.println("Unfortunately I couldn't find the " + elementName+ "...");
    }

    public static void ValidateCurrentPageURL(String pageName) {
        String pageURL = driver.getCurrentUrl();
        if (pageName.equalsIgnoreCase("home"))
            Assert.assertEquals(pageURL, LoadProperties.environment.getProperty("URL"));
        else
            Assert.assertEquals(pageURL, LoadProperties.environment.getProperty("URL") + pageName + "/");
    }
}
