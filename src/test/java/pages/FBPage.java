package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.util.ArrayList;

public class FBPage extends PageBase {

    public void checkFBURL(){
        switchTab();
        String currentPageURL = driver.getCurrentUrl();
        Assert.assertSame(currentPageURL, "https://www.facebook.com/MusalaSoft?fref=ts");
    }

    private void switchTab(){
        ArrayList<String> fbTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(fbTab.get(1));
    }

    public void verifyMusalaPP(){
        by = By.xpath("//div[@id='entity_sidebar']//img");
        element = driver.findElement(by);
        Boolean MusalaPP = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", element);
        if (MusalaPP)
            System.out.println("The Musala Profile picture is displayed");
        else
            System.out.println("Errr");
    }
}
