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
}
