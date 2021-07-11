package utilites;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class Helper {
    //A method that takes a screenshot if the TestCase is failed

    public static void captureScreenShot(WebDriver driver, String screenshotName) {
        Path dest = Paths.get("./Screenshots", screenshotName + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Error while taking a screenshot" + e.getMessage());
        }
    }
}
