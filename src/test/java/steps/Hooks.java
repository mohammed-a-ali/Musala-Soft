package steps;

import Browser.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import utilites.Helper;

import static Browser.Driver.driver;

public class Hooks extends AbstractTestNGCucumberTests {

    @Before
    public void openBrowser() {
        Driver.startDriver();
    }

    @After
    public void closeBrowser() {
        Driver.stopDriver();
    }

    //Take a screenshot when testcase fails and add it to the Screenshot folder
    @AfterClass
    public void ScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking a Screenshot...");
            Helper.captureScreenShot(driver, result.getName());
        }
    }
}
