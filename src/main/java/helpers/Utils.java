package helpers;

import base.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public final static String SCREENSHOT_PATH = "src/main/resources/screenshots/";

    public static void takeScreenshot(String testName) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) Driver.getInstance().getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(setScreenshotName(testName));
        Files.copy(srcFile.toPath(), destFile.toPath());
    }

    private static String setScreenshotName(String testName) {
        String simpleFormatDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String finalTestName = testName.replace("(TestInfo)", "");
        return String.format(SCREENSHOT_PATH + "%s_%s.png", finalTestName, simpleFormatDate);
    }
}
