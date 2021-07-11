package pages;

import org.openqa.selenium.By;

public class HomePage extends PageBase {

    public void clickAboutUs(String elementName) {
        by = By.xpath("//*[contains(text(),'" + elementName + "')]");
        clickButtonByText(elementName);
    }

    public void clickOnNavBarLink(String elementName) {
        by = By.xpath("//div[@id='navbar']//*[text()='" + elementName + "']");
        clickOnLinkText(elementName);
    }
}
