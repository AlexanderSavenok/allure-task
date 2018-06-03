package helpers;

import base.Driver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    private WebDriver driver = Driver.getInstance().getDriver();

    public FluentWait<WebDriver> getWaiterIgnoringStaleReferenceException() {
        return getWaiter().ignoring(StaleElementReferenceException.class);
    }

    public WebDriverWait getWaiter() {
        return getWaiter(10);
    }

    public WebDriverWait getWaiter(int seconds) {
        return new WebDriverWait(driver, seconds);
    }
}
