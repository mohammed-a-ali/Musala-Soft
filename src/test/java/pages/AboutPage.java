package pages;

import org.openqa.selenium.By;

public class AboutPage extends PageBase {

    public void fillNameTextBox(String elementName, String text) {
        by = By.xpath("//*[text()='" + elementName + "']//..//input[@type='text']");
        setTextToTextBox(elementName, text);
    }

    public void fillEmailTextBox(String elementName, String text) {
        by = By.xpath("//*[text()='" + elementName + "']//..//input[@type='email']");
        setTextToTextBox(elementName, text);
    }

    public void fillMobileTextBox(String elementName, String text) {
        by = By.xpath("//*[text()='" + elementName + "']//..//input[@type='tel']");
        setTextToTextBox(elementName, text);
    }

    public void fillSubjectTextBox(String elementName, String text) {
        by = By.xpath("//*[text()='" + elementName + "']//..//input[@type='text']");
        setTextToTextBox(elementName, text);
    }

    public void fillYourMessageTextArea(String elementName, String text) {
        by = By.xpath("//*[text()='" + elementName + "']//..//textarea[@name='your-message']");
        setTextToTextBox(elementName, text);
    }

    public String getEmailText() {
        by = By.xpath("//*[text()='Email']//..//input[@type='email']");
        element = driver.findElement(by);
        return element.getAttribute("value");
    }

    public void clickSendButton(String elementName) {
        by = By.xpath("//input[@value='" + elementName + "']");
        System.out.println("Element '" + elementName + "' is found...");
        System.out.println("Going to click '" + elementName + "' button...");
        element = driver.findElement(by);
        scrollToElement();
        element.click();
    }

    public String checkEmailValidation() {
        by = By.xpath("//span[@class='wpcf7-not-valid-tip']");
        element = driver.findElement(by);
        String errorMsg = element.getText();
        return errorMsg;
    }
}
