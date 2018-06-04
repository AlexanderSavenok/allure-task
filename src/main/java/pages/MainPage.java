package pages;

import base.PageBase;
import helpers.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public class MainPage extends PageBase {

    private static final By LOGOUT_HYPERLINK = By.id("PH_logoutLink");
    private static final By INBOX_HYPERLINK = By.cssSelector("div.b-nav__item_unread");
    private static final By DATA_EMAIL_LIST = By.className("b-datalist__item__link");

    public LoginPage logout() {
        driver.findElement(LOGOUT_HYPERLINK).click();
        return new LoginPage();
    }

    public boolean waitInboxHyperlinkDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(INBOX_HYPERLINK));

        return driver.findElement(INBOX_HYPERLINK).isDisplayed();
    }

    public boolean waitLogoutHyperlinkDisplayed() {
        FluentWait waitHandleStaleRefException = new Waiters().getWaiterIgnoringStaleReferenceException();
        waitHandleStaleRefException.until(ExpectedConditions.presenceOfElementLocated(LOGOUT_HYPERLINK));

        return driver.findElement(LOGOUT_HYPERLINK).isDisplayed();
    }

    public List<WebElement> getInboxMailCollection() {
        return driver.findElements(DATA_EMAIL_LIST);
    }
}
