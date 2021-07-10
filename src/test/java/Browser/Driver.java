package Browser;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utilites.LoadProperties;

import java.util.concurrent.TimeUnit;

public class Driver extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    static String url = LoadProperties.environment.getProperty("URL");
    static String browserName = LoadProperties.environment.getProperty("Browser");

    public static void startDriver() {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            try {
                throw new Exception("The driver name '" + browserName + "' is incorrect..");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public static void stopDriver() {
        driver.quit();
    }
}
