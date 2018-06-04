package junit;

import base.Driver;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;

public class ScreenshotOnFailureRule implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        String testResult = extensionContext.getExecutionException().isPresent() ? "FAILED" : "OK";
        if(testResult == "FAILED") {
            captureScreenshot();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] captureScreenshot() {
        TakesScreenshot scrShot = ((TakesScreenshot) Driver.getInstance().getDriver());
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }
}
